package br.com.iouone.mapper;

import br.com.iouone.dto.PessoaDTO;
import br.com.iouone.entity.Pessoa;
import java.time.format.DateTimeFormatter;

public class PessoaToDtoConverter {

    public static PessoaDTO convert(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setName(pessoa.getNome());
        pessoaDTO.setEmail(pessoa.getEmail());
        pessoaDTO.setDocument(pessoa.getCpf());
        pessoaDTO.setType("individual");
        pessoaDTO.setGender("male");

        if (pessoa.getDataNascimento() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = pessoa.getDataNascimento().format(formatter);
            pessoaDTO.setBirthdate(formattedDate);
        }

        if (pessoa.getCelular() != null) {
            pessoaDTO.setCelular(pessoa.getCelular());
        }

        return pessoaDTO;
    }

}
