package br.com.iouone.mapper;

import br.com.iouone.dto.DadosPessoaisEnderecoRequest;
import br.com.iouone.entity.Endereco;
import br.com.iouone.entity.Paises;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    public Endereco convertEnderecoResponsetoEndereco(DadosPessoaisEnderecoRequest dadosPessoaisEnderecoRequest, Paises paises){
         Endereco endereco = new Endereco();
         endereco.setEndereco(dadosPessoaisEnderecoRequest.getEndereco());
         endereco.setCidade(dadosPessoaisEnderecoRequest.getCidade());
         endereco.setEstado(dadosPessoaisEnderecoRequest.getEstado());
         endereco.setPaises(paises);

         return endereco;
    }
}
