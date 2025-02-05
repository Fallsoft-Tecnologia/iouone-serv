package br.com.iouone.service;

import br.com.iouone.dto.CalculoTDEEDTO;
import br.com.iouone.dto.CriarCalculoRequestDTO;
import br.com.iouone.dto.DadosPessoaTDEEDTO;
import br.com.iouone.dto.PessoaCalculoDTO;
import br.com.iouone.entity.*;
import br.com.iouone.repository.BiotipoRepository;
import br.com.iouone.repository.CalculoTDEERepository;
import br.com.iouone.repository.ObjetivoRepository;
import br.com.iouone.repository.PessoaRepository;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class TDEECalculatorService {

    private final PessoaService pessoaService;
    private final CalculoTDEERepository calculoTDEERepository;
    private final ObjetivoRepository objetivoRepository;
    private final BiotipoRepository biotipoRepository;
    private final AtividadeFisicaService atividadeFisicaService;
    private final DadosCorporaisService dadosCorporaisService;

    @Autowired
    public TDEECalculatorService(PessoaService pessoaService,
                                 CalculoTDEERepository calculoTDEERepository,
                                 ObjetivoRepository objetivoRepository, BiotipoRepository biotipoRepository, AtividadeFisicaService atividadeFisicaService, DadosCorporaisService dadosCorporaisService) {
        this.pessoaService = pessoaService;
        this.calculoTDEERepository = calculoTDEERepository;
        this.objetivoRepository = objetivoRepository;
        this.biotipoRepository = biotipoRepository;
        this.atividadeFisicaService = atividadeFisicaService;
        this.dadosCorporaisService = dadosCorporaisService;
    }

    public PessoaCalculoDTO calcularTDEE(Pessoa pessoa, Objetivo objetivo, Biotipo biotipo) {
        DecimalFormat df = new DecimalFormat("####.0");

        DadosCorporais dadosCorporais = pessoa.getDadosCorporais();
        if (dadosCorporais == null) {
            throw new IllegalArgumentException("Dados corporais não cadastrados para esta pessoa");
        }

        double tmb = calcularTMB(dadosCorporais, pessoa.getDataNascimento());
        double fatorAtividade = obterFatorAtividade(pessoa.getAtividadeFisica().getAtividadeFisica());
        double tdee = tmb * fatorAtividade;
        double tdeeAjustado = ajustarTDEEConformeObjetivo(tdee, objetivo);

        return mapToPessoaCalculoDTO(pessoa, objetivo, biotipo, df.format(tdeeAjustado).replace(",", "."), df.format(tmb).replace(",", "."));
    }


    private double ajustarTDEEConformeObjetivo(double tdee, Objetivo objetivo) {
        switch (objetivo.getObjetivo().toLowerCase()) {
            case "emagrecer":
                return tdee * 0.85; // Déficit moderado (15%)
            case "emagrecer agressivo":
                return tdee * 0.75; // Déficit agressivo (25%)
            case "manter":
                return tdee; // Sem alteração
            case "ganhos secos":
                return tdee * 1.1; // Superávit moderado (10%)
            case "ganhar agressivo":
                return tdee * 1.25; // Superávit agressivo (25%)
            default:
                throw new IllegalArgumentException("Objetivo desconhecido: " + objetivo.getObjetivo());
        }
    }


    private double calcularTMB(DadosCorporais dadosCorporais, LocalDate dataNascimento) {


        int idade = dataNascimento.until(LocalDate.now()).getYears();
        Float altura = dadosCorporais.getAltura();
        Float pesoBD = dadosCorporais.getPesoAtual();
        Float peso = (pesoBD != null) ? pesoBD : 0;

        return 655 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
    }

    private double obterFatorAtividade(String atividadeFisica) {
        switch (atividadeFisica.toLowerCase()) {
            case "Nenhum":
                return 1.2;
            case "Baixo":
                return 1.375;
            case "Moderado":
                return 1.55;
            case "Frequente":
                return 1.725;
            default:
                return 1.2;
        }
    }

    public CalculoTDEEDTO criarCalculoAutomaticamente(int pessoaId, CriarCalculoRequestDTO criarCalculoRequestDTO) {
        Pessoa pessoa = pessoaService.findByIdPessoa(pessoaId);
        var dadosCorporais = dadosCorporaisService.getDadosCorporais(pessoaId);

        Objetivo retonroObjetivo = objetivoRepository.findObjetivoByObjetivo(criarCalculoRequestDTO.getObjetivo());

        Biotipo retornoBiotipo = biotipoRepository.findBiotipoByBiotipo(criarCalculoRequestDTO.getBiotipo());
        if(dadosCorporais.getId() == null ){
            pessoa.setDadosCorporais(
                    new DadosCorporais(Float.parseFloat(criarCalculoRequestDTO.getAltura()),
                            Float.parseFloat(criarCalculoRequestDTO.getPeso()),0F));
        }else{
            pessoa.setDadosCorporais(
                    new DadosCorporais(Float.parseFloat(criarCalculoRequestDTO.getAltura()),
                            Float.parseFloat(criarCalculoRequestDTO.getPeso()), dadosCorporais.getPesoIdeal()));
        }


        var atividadeFisica = atividadeFisicaService.buscarAtividadeFisicaPorNome(criarCalculoRequestDTO.getNivelAtividadeFisica());
        pessoa.setAtividadeFisica(atividadeFisica);

        pessoaService.createPessoa(pessoa);

        PessoaCalculoDTO pessoaCalculoDTO = calcularTDEE(pessoa, retonroObjetivo, retornoBiotipo);

        var idCalculo = calculoTDEERepository.buscarIdCalculoTDEE(pessoa.getId());
        CalculoTDEE calculoTDEE = new CalculoTDEE();
        if(idCalculo != null){
            calculoTDEE.setId(idCalculo);
            calculoTDEE.setPessoa(pessoa);
            calculoTDEE.setTdee(Double.parseDouble(pessoaCalculoDTO.getTdee()));
            calculoTDEE.setCaloriasDiarias(Double.parseDouble(pessoaCalculoDTO.getCaloriasDiarias()));
            calculoTDEE.setDataCalculo(LocalDate.now());
            calculoTDEE.setBiotipo(retornoBiotipo);
            calculoTDEE.setObjetivo(retonroObjetivo);

        }else {
            calculoTDEE.setPessoa(pessoa);
            calculoTDEE.setTdee(Double.parseDouble(pessoaCalculoDTO.getTdee()));
            calculoTDEE.setCaloriasDiarias(Double.parseDouble(pessoaCalculoDTO.getCaloriasDiarias()));
            calculoTDEE.setDataCalculo(LocalDate.now());
            calculoTDEE.setBiotipo(retornoBiotipo);
            calculoTDEE.setObjetivo(retonroObjetivo);

        }


        calculoTDEERepository.save(calculoTDEE);



        return new CalculoTDEEDTO(retonroObjetivo.getObjetivo(), retornoBiotipo.getBiotipo(), pessoaCalculoDTO.getTdee(), pessoaCalculoDTO.getCaloriasDiarias());
    }


    private PessoaCalculoDTO mapToPessoaCalculoDTO(Pessoa pessoa, Objetivo objetivo, Biotipo biotipo, String tdee, String caloriasDiarias) {
        PessoaCalculoDTO dto = new PessoaCalculoDTO();
        dto.setId(pessoa.getId().longValue());
        dto.setNome(pessoa.getNome());
        dto.setEmail(pessoa.getEmail());
        dto.setCelular(pessoa.getCelular());
        dto.setCpf(pessoa.getCpf());
        dto.setDataNascimento(pessoa.getDataNascimento());
        dto.setAtividadeFisica(
                Optional.ofNullable(pessoa.getAtividadeFisica())
                        .map(atividade -> atividade.getAtividadeFisica())
                        .orElse("Atividade física não cadastrada")
        );

        DadosCorporais dadosCorporais = pessoa.getDadosCorporais();
        if (dadosCorporais != null) {
            dto.setPesoAtual(Optional.ofNullable(dadosCorporais.getPesoAtual())
                    .map(Float::doubleValue)
                    .orElse(0.0));

            dto.setPesoIdeal(Optional.ofNullable(dadosCorporais.getPesoIdeal())
                    .map(Float::doubleValue)
                    .orElse(0.0));

            dto.setAltura(dadosCorporais.getAltura());

            dto.setBiotipo(Optional.ofNullable(biotipo.getBiotipo()).orElse("Biotipo não cadastrado"));
            dto.setObjetivo(Optional.ofNullable(objetivo.getObjetivo()).orElse("Objetivo não cadastrado"));
        }

        dto.setTdee(tdee);
        dto.setCaloriasDiarias(caloriasDiarias);

        return dto;
    }

    public DadosPessoaTDEEDTO buscarDadosPessoaTDEE(Integer pessoaId) {
        return pessoaService.dadosPessoaTDEE(pessoaId);

    }
}
