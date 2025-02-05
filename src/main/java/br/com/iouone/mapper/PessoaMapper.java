package br.com.iouone.mapper;

import br.com.iouone.dto.*;
import br.com.iouone.entity.AtividadeFisica;
import br.com.iouone.entity.DadosCorporais;
import br.com.iouone.entity.Endereco;
import br.com.iouone.entity.Pessoa;
import br.com.iouone.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public Pessoa toEntity(PessoaRequest pessoaRequest) {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(pessoaRequest.getCpf());
        pessoa.setNome(pessoaRequest.getNome());
        pessoa.setEmail(pessoaRequest.getEmail());
        pessoa.setSenha(pessoaRequest.getSenha());
        pessoa.setCelular(pessoaRequest.getCelular());
        pessoa.setDataNascimento(pessoaRequest.getDataNascimento());

        if (pessoaRequest.getAtividadeFisicaId() != null) {
            AtividadeFisica atividadeFisica = atividadeRepository
                    .findById(pessoaRequest.getAtividadeFisicaId())
                    .orElse(null);
            pessoa.setAtividadeFisica(atividadeFisica);
        }

        return pessoa;
    }

    public PessoaResponse toResponse(Pessoa pessoa) {
        PessoaResponse pessoaResponse = new PessoaResponse();
        pessoaResponse.setCpf(pessoa.getCpf());
        pessoaResponse.setNome(pessoa.getNome());
        pessoaResponse.setEmail(pessoa.getEmail());
        pessoaResponse.setCelular(pessoa.getCelular());
        pessoaResponse.setDataNascimento(pessoa.getDataNascimento());
        pessoa.setFluxoId(pessoaResponse.getFluxoId());

        if (pessoa.getAtividadeFisica() != null) {
            pessoaResponse.setAtividadeFisica(pessoa.getAtividadeFisica().getAtividadeFisica());
        }

        return pessoaResponse;
    }


    public Pessoa convertLoginToPessoa(LoginDTO loginDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail(loginDTO.getEmail());
        pessoa.setSenha(loginDTO.getPassword());
        pessoa.setCpf(loginDTO.getCpf());

        return pessoa;
    }

    public Pessoa convertDadosPessoaisToPessoa(Pessoa pessoa, DadosPessoaisPessoaRequest dadosPessoaisPessoaRequest) {
        pessoa.setNome(dadosPessoaisPessoaRequest.getNome());
        pessoa.setDataNascimento(dadosPessoaisPessoaRequest.getDataNascimento());
        pessoa.setCelular(dadosPessoaisPessoaRequest.getCelular());
        return pessoa;
    }

    public Pessoa convertDadosEnderecoToPessoa(Pessoa pessoa, Endereco endereco) {
        pessoa.setEndereco(endereco);
        return pessoa;
    }

    public Pessoa convertDadosCorporaisToPessoa(Pessoa pessoa, DadosCorporais dadosCorporais, AtividadeFisica atividadeFisica) {
        pessoa.setDadosCorporais(dadosCorporais);
        pessoa.setAtividadeFisica(atividadeFisica);
        return pessoa;
    }

    public PessoaRequest convertPessoaToPessoaRequest(Pessoa pessoa, Integer idAtividadeFisica) {
        PessoaRequest request = new PessoaRequest();

        request.setCpf(pessoa.getCpf());
        request.setNome(pessoa.getNome());
        request.setEmail(pessoa.getEmail());
        request.setSenha(pessoa.getSenha());
        request.setCelular(pessoa.getCelular());
        request.setDataNascimento(pessoa.getDataNascimento());
        request.setAtividadeFisicaId(idAtividadeFisica);

        return request;
    }


}
