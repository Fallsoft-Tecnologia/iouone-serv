package br.com.iouone.service;

import br.com.iouone.config.RabbitConfig;
import br.com.iouone.dto.*;
import br.com.iouone.entity.*;
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
    private PaisesService paisesService;

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

            Pessoa updatedPessoa = pessoaRepository.save(pessoa);

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
        pessoaRepository.save(pessoa);
    }

    public PessoaResponse cadastroDadosLogin(LoginRequest loginRequest) {
        Pessoa pessoa = pessoaMapper.convertLoginToPessoa(loginRequest);
        pessoa.setSenha(passwordEncoder.encode(loginRequest.getPassword()));
        Pessoa savePessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.toResponse(savePessoa);
    }

    public PessoaResponse cadastroDadosPessoais(DadosPessoaisPessoaRequest dadosPessoaisPessoaRequest) {
        Pessoa getPessoa = findByIdPessoa(dadosPessoaisPessoaRequest.getIdPessoa());
        Pessoa pessoa = pessoaMapper.convertDadosPessoaisToPessoa(getPessoa,dadosPessoaisPessoaRequest);
        Pessoa savePessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.toResponse(savePessoa);
    }

    public PessoaResponse cadastroDadosEndereco(DadosPessoaisEnderecoRequest dadosPessoaisEnderecoRequest) {
        Pessoa getPessoa = findByIdPessoa(dadosPessoaisEnderecoRequest.getIdPessoa());
        Paises pais = paisesService.getPaisByAbreviacao(dadosPessoaisEnderecoRequest.getPais().abreviacao());
        Endereco convertEndereco = enderecoMapper.convertEnderecoResponsetoEndereco(dadosPessoaisEnderecoRequest, pais);
        Endereco saveEndereco = enderecoService.saveEndereco(convertEndereco);
        Pessoa pessoa = pessoaMapper.convertDadosEnderecoToPessoa(getPessoa, saveEndereco);
        Pessoa savePessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.toResponse(savePessoa);

    }

    public PessoaResponse cadastroDadosCorporais(DadosPessoaisCorporaisRequest dadosPessoaisCorporaisRequest) {
        Pessoa getPessoa = findByIdPessoa(dadosPessoaisCorporaisRequest.getIdPessoa());

        AtividadeFisica atividadeFisica = atividadeFisicaService.buscarAtividadeFisicaPorId(dadosPessoaisCorporaisRequest.getAtividadeFisicaRequest().id());
        DadosCorporais convertDadosCorporais = dadosCorporaisMapper.convertDadosCorporaisRequesttoDadosCorporais(dadosPessoaisCorporaisRequest);
        DadosCorporais saveDadosCorporais = dadosCorporaisService.saveDadosCorporais(convertDadosCorporais);
        Pessoa savePessoa = pessoaMapper.convertDadosCorporaisToPessoa(getPessoa, saveDadosCorporais, atividadeFisica);
        return pessoaMapper.toResponse(savePessoa);
    }

    private Pessoa findByIdPessoa(Integer id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + id));
    }

}
