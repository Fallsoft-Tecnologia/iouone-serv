package br.com.iouone.mapper;

import br.com.iouone.dto.DadosPessoaisEnderecoRequest;
import br.com.iouone.entity.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    public Endereco convertEnderecoResponsetoEndereco(DadosPessoaisEnderecoRequest dadosPessoaisEnderecoRequest){
         Endereco endereco = new Endereco();
         endereco.setEndereco(dadosPessoaisEnderecoRequest.getEndereco());
         endereco.setCidade(dadosPessoaisEnderecoRequest.getCidade());
         endereco.setEstado(dadosPessoaisEnderecoRequest.getEstado());
         endereco.setPaises(dadosPessoaisEnderecoRequest.getPais());
         endereco.setCep(dadosPessoaisEnderecoRequest.getCep());

         return endereco;
    }
}
