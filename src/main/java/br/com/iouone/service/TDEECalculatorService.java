package br.com.iouone.service;

import br.com.iouone.dto.PessoaCalculoDTO;
import br.com.iouone.entity.*;
import br.com.iouone.repository.BiotipoRepository;
import br.com.iouone.repository.CalculoTDEERepository;
import br.com.iouone.repository.ObjetivoRepository;
import br.com.iouone.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class TDEECalculatorService {

    private final PessoaService pessoaService;
    private final CalculoTDEERepository calculoTDEERepository;
    private final ObjetivoRepository objetivoRepository;
    private final BiotipoRepository biotipoRepository;

    @Autowired
    public TDEECalculatorService(PessoaService pessoaService,
                                 CalculoTDEERepository calculoTDEERepository,
                                 ObjetivoRepository objetivoRepository, BiotipoRepository biotipoRepository) {
        this.pessoaService = pessoaService;
        this.calculoTDEERepository = calculoTDEERepository;
        this.objetivoRepository = objetivoRepository;
        this.biotipoRepository = biotipoRepository;
    }

    public PessoaCalculoDTO calcularTDEE(int pessoaId, int objetivoId, int biotipoId) {
        Pessoa pessoa = pessoaService.findByIdPessoa(pessoaId);

        DadosCorporais dadosCorporais = pessoa.getDadosCorporais();
        if (dadosCorporais == null) {
            throw new IllegalArgumentException("Dados corporais não cadastrados para esta pessoa");
        }

        Objetivo objetivo = objetivoRepository.findById(objetivoId)
                .orElseThrow(() -> new IllegalArgumentException("Objetivo não encontrado"));

        Biotipo biotipo = biotipoRepository.findById(biotipoId)
                .orElseThrow(() -> new IllegalArgumentException("Biotipo não encontrado"));

        double tmb = calcularTMB(dadosCorporais,pessoaId);
        double fatorAtividade = obterFatorAtividade(pessoa.getAtividadeFisica().getAtividadeFisica());

        double tdee = tmb * fatorAtividade;
        double tdeeAjustado = ajustarTDEEConformeObjetivo(tdee, objetivo);
        
        return mapToPessoaCalculoDTO(pessoa, objetivo, biotipo, tdeeAjustado, tdeeAjustado);
    }


    private double ajustarTDEEConformeObjetivo(double tdee, Objetivo objetivo) {
        switch (objetivo.getObjetivo().toLowerCase()) {
            case "emagrecer":
                return tdee * 0.8;
            case "ganhar peso":
                return tdee * 1.2;
            case "manter":
            default:
                return tdee;
        }
    }

    private double calcularTMB(DadosCorporais dadosCorporais, Integer pessoaId) {
        Pessoa pessoa = pessoaService.findByIdPessoa(pessoaId);

        int idade = pessoa.getDataNascimento().until(LocalDate.now()).getYears();
        Float altura = dadosCorporais.getAltura();
        Float pesoBD = dadosCorporais.getPesoAtual();
        Float peso = (pesoBD != null) ? pesoBD : 0;
        
        return 655 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
    }

    private double obterFatorAtividade(String atividadeFisica) {
        switch (atividadeFisica.toLowerCase()) {
            case "sedentário":
                return 1.2;
            case "levemente ativo":
                return 1.375;
            case "moderadamente ativo":
                return 1.55;
            case "muito ativo":
                return 1.725;
            case "extremamente ativo":
                return 1.9;
            default:
                return 1.2;
        }
    }

    public PessoaCalculoDTO criarCalculoAutomaticamente(int pessoaId, int objetivoId, int biotipoId, String dataCalculo) {
        Pessoa pessoa = pessoaService.findByIdPessoa(pessoaId);


        Objetivo objetivo = objetivoRepository.findById(objetivoId)
                .orElseThrow(() -> new IllegalArgumentException("Objetivo não encontrado"));

        Biotipo biotipo = biotipoRepository.findById(biotipoId)
                .orElseThrow(() -> new IllegalArgumentException("Biotipo não encontrado"));

        PessoaCalculoDTO pessoaCalculoDTO = calcularTDEE(pessoaId, objetivoId, biotipoId);

        CalculoTDEE calculoTDEE = new CalculoTDEE();
        calculoTDEE.setPessoa(pessoa);
        calculoTDEE.setTdee(pessoaCalculoDTO.getTdee());
        calculoTDEE.setCaloriasDiarias(pessoaCalculoDTO.getCaloriasDiarias());
        calculoTDEE.setDataCalculo(LocalDate.parse(dataCalculo));

        calculoTDEERepository.save(calculoTDEE);

        return mapToPessoaCalculoDTO(pessoa, objetivo, biotipo, pessoaCalculoDTO.getTdee(), pessoaCalculoDTO.getCaloriasDiarias());
    }


    private PessoaCalculoDTO mapToPessoaCalculoDTO(Pessoa pessoa, Objetivo objetivo, Biotipo biotipo, double tdee, double caloriasDiarias) {
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
}
