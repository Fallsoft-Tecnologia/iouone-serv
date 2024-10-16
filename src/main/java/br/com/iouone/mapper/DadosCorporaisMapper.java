package br.com.iouone.mapper;

import br.com.iouone.dto.DadosPessoaisCorporaisRequest;
import br.com.iouone.entity.AtividadeFisica;
import br.com.iouone.entity.DadosCorporais;
import org.springframework.stereotype.Component;

@Component
public class DadosCorporaisMapper {

    public DadosCorporais convertDadosCorporaisRequesttoDadosCorporais(DadosPessoaisCorporaisRequest dadosPessoaisCorporaisRequest) {
        DadosCorporais corporais = new DadosCorporais();
        corporais.setPesoIdeal(dadosPessoaisCorporaisRequest.getPesoIdeal());
        corporais.setAltura(dadosPessoaisCorporaisRequest.getAltura());
        corporais.setPesoAtual(dadosPessoaisCorporaisRequest.getPesoAtual());

        return corporais;

    }
}
