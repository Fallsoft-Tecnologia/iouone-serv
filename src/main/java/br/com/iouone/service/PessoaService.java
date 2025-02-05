package br.com.iouone.service;

import br.com.iouone.config.RabbitConfig;
import br.com.iouone.dto.*;
import br.com.iouone.entity.AtividadeFisica;
import br.com.iouone.entity.DadosCorporais;
import br.com.iouone.entity.Endereco;
import br.com.iouone.entity.Pessoa;
import br.com.iouone.exception.ExceptionCpf;
import br.com.iouone.exception.ExceptionEmail;
import br.com.iouone.mapper.DadosCorporaisMapper;
import br.com.iouone.mapper.EnderecoMapper;
import br.com.iouone.mapper.PessoaMapper;
import br.com.iouone.mapper.PessoaToDtoConverter;
import br.com.iouone.repository.PessoaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    @Autowired
    private PessoaMapper pessoaMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(PessoaService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private EnderecoService enderecoService;


    @Autowired
    private EnderecoMapper enderecoMapper;

    @Autowired
    private AtividadeFisicaService atividadeFisicaService;

    @Autowired
    private DadosCorporaisService dadosCorporaisService;

    @Autowired
    private DadosCorporaisMapper dadosCorporaisMapper;

    public PessoaResponse savePessoa(PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaMapper.toEntity(pessoaRequest);
        pessoa.setSenha(passwordEncoder.encode(pessoaRequest.getSenha()));
        Pessoa savedPessoa = pessoaRepository.save(pessoa);
        PessoaDTO pessoaDTO = PessoaToDtoConverter.convert(savedPessoa);
        logger.info("Enviando mensagem para a fila com PessoaId: {}", pessoaDTO.getId());
        rabbitTemplate.convertAndSend(RabbitConfig.PESSOA_REGISTRATION_QUEUE, pessoaDTO);
        return pessoaMapper.toResponse(savedPessoa);
    }


    public Optional<PessoaResponse> findPessoaById(Integer id) {
        return pessoaRepository.findById(id)
                .map(pessoaMapper::toResponse);
    }

    public List<PessoaResponse> findAllPessoas() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoaMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<PessoaResponse> updatePessoa(Integer id, PessoaRequest pessoaRequest) {
        return pessoaRepository.findById(id).map(pessoa -> {
            pessoa.setCpf(pessoaRequest.getCpf());
            pessoa.setNome(pessoaRequest.getNome());
            pessoa.setEmail(pessoaRequest.getEmail());
            pessoa.setCelular(pessoaRequest.getCelular());
            pessoa.setDataNascimento(pessoaRequest.getDataNascimento());

            if (pessoaRequest.getAtividadeFisicaId() != null) {
                AtividadeFisica atividadeFisica = atividadeFisicaService.buscarAtividadeFisicaPorId(pessoaRequest.getAtividadeFisicaId());
                pessoa.setAtividadeFisica(atividadeFisica);
            }

            if (pessoaRequest.getSenha() != null && !pessoaRequest.getSenha().isEmpty()) {
                pessoa.setSenha(passwordEncoder.encode(pessoaRequest.getSenha()));
            }

            Pessoa updatedPessoa = createPessoa(pessoa);

            return pessoaMapper.toResponse(updatedPessoa);
        });
    }

    public boolean deletePessoa(Integer id) {
        return pessoaRepository.findById(id).map(pessoa -> {
            pessoaRepository.delete(pessoa);
            return true;
        }).orElse(false);
    }

    public void updateCustomerId(Integer pessoaId, String customerId) {
        Pessoa pessoa = findByIdPessoa(pessoaId);
        pessoa.setCustomerId(customerId);
        createPessoa(pessoa);
    }

    public ResponseFluxoId cadastroDadosLogin(LoginDTO loginDTO) throws Exception {
        var pessoaFindEmail = pessoaRepository.findByEmail(loginDTO.getEmail());
        var pessoaFindCpf = pessoaRepository.findByCpf(loginDTO.getCpf());

        if(pessoaFindCpf.isPresent()){
            throw new ExceptionCpf("CPF já cadastrado!");
        }

        if(pessoaFindEmail.isPresent()){
            throw new ExceptionEmail("Email já cadastrado!");
        }

        Pessoa pessoa = pessoaMapper.convertLoginToPessoa(loginDTO);
        pessoa.setSenha(passwordEncoder.encode(loginDTO.getPassword()));
        pessoa.setFluxoId(UUID.randomUUID().toString());
        Pessoa savePessoa = createPessoa(pessoa);
        return new ResponseFluxoId(savePessoa.getFluxoId());
    }

    public ResponseFluxoId cadastroDadosPessoais(DadosPessoaisPessoaRequest dadosPessoaisPessoaRequest, String fluxoId) {
        Pessoa getPessoa = findPessoaByFluxoId(fluxoId);
        Pessoa pessoa = pessoaMapper.convertDadosPessoaisToPessoa(getPessoa, dadosPessoaisPessoaRequest);
        Pessoa savePessoa = createPessoa(pessoa);
        return new ResponseFluxoId(savePessoa.getFluxoId());
    }

    public ResponseFluxoId cadastroDadosEndereco(DadosPessoaisEnderecoRequest dadosPessoaisEnderecoRequest, String fluxoId) {
        Pessoa getPessoa = findPessoaByFluxoId(fluxoId);
        Endereco convertEndereco = enderecoMapper.convertEnderecoResponsetoEndereco(dadosPessoaisEnderecoRequest);
        Endereco saveEndereco = enderecoService.saveEndereco(convertEndereco);
        Pessoa pessoa = pessoaMapper.convertDadosEnderecoToPessoa(getPessoa, saveEndereco);
        Pessoa savePessoa = createPessoa(pessoa);
        return new ResponseFluxoId(savePessoa.getFluxoId());
    }

    public ResponseFluxoId cadastroDadosCorporais(DadosPessoaisCorporaisRequest dadosPessoaisCorporaisRequest, String fluxoId) {
        Pessoa getPessoa = findPessoaByFluxoId(fluxoId);
        AtividadeFisica atividadeFisica = atividadeFisicaService.buscarAtividadeFisicaPorNome(dadosPessoaisCorporaisRequest.getAtividadeFisica());
        DadosCorporais convertDadosCorporais = dadosCorporaisMapper.convertDadosCorporaisRequesttoDadosCorporais(dadosPessoaisCorporaisRequest);
        DadosCorporais saveDadosCorporais = dadosCorporaisService.saveDadosCorporais(convertDadosCorporais);
        Pessoa savePessoa = pessoaMapper.convertDadosCorporaisToPessoa(getPessoa, saveDadosCorporais, atividadeFisica);
        createPessoa(savePessoa);
        PessoaDTO pessoaDTO = PessoaToDtoConverter.convert(savePessoa);
        logger.info("Enviando mensagem para a fila com PessoaId: {}", pessoaDTO.getId());
        rabbitTemplate.convertAndSend(RabbitConfig.PESSOA_REGISTRATION_QUEUE, pessoaDTO);

        return new ResponseFluxoId(savePessoa.getFluxoId());
    }

    public CadastroCompletoDTO getCadastroCompleto(String fluxoId) {
        // Recuperar a entidade Pessoa e outros dados relacionados
        Pessoa pessoa = pessoaRepository.findByFluxoId(fluxoId);
        if (pessoa == null) {
            throw new RuntimeException("Fluxo não encontrado.");
        }

        CadastroCompletoDTO dto = new CadastroCompletoDTO();

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setCpf(pessoa.getCpf());
        loginDTO.setEmail(pessoa.getEmail());
        dto.setLogin(loginDTO);

        DadosPessoaisPessoaRequest dadosPessoais = new DadosPessoaisPessoaRequest();
        dadosPessoais.setNome(pessoa.getNome());
        dadosPessoais.setDataNascimento(pessoa.getDataNascimento());
        dadosPessoais.setCelular(pessoa.getCelular());
        dto.setDadosPessoais(dadosPessoais);

        if (pessoa.getEndereco() != null) {
            DadosPessoaisEnderecoRequest endereco = new DadosPessoaisEnderecoRequest();
            endereco.setCep(pessoa.getEndereco().getCep());
            endereco.setEndereco(pessoa.getEndereco().getEndereco());
            endereco.setCidade(pessoa.getEndereco().getCidade());
            endereco.setEstado(pessoa.getEndereco().getEstado());
            endereco.setPais(pessoa.getEndereco().getPaises());
            dto.setEndereco(endereco);
        }

        if (pessoa.getDadosCorporais() != null) {
            DadosPessoaisCorporaisRequest corporais = new DadosPessoaisCorporaisRequest();
            corporais.setPesoIdeal(pessoa.getDadosCorporais().getPesoIdeal());
            corporais.setAltura(pessoa.getDadosCorporais().getAltura());
            corporais.setPesoAtual(pessoa.getDadosCorporais().getPesoAtual());
            dto.setCorporais(corporais);
        }

        return dto;
    }

    public Pessoa findByIdPessoa(Integer id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + id));
    }

    private Pessoa findPessoaByFluxoId(String fluxoId) {
        Pessoa pessoa = pessoaRepository.findByFluxoId(fluxoId);
        if (pessoa == null) {
            throw new RuntimeException("Pessoa não encontrada");
        }
        return pessoa;
    }

    public DadosEnderecoPessoaDTO dadosPagamentoEnderecoPessoa(String fluxoId) {
        return pessoaRepository.buscarEnderecoPessoaPorFluxoId(fluxoId);
    }

    public DadosPessoaTDEEDTO dadosPessoaTDEE(Integer pessoaId) {
        return pessoaRepository.buscarDadosPessoaTDEE(pessoaId);
    }


    public Pessoa createPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

}
