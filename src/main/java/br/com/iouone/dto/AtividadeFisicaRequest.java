package br.com.iouone.dto;

import jakarta.validation.constraints.NotBlank;

public record AtividadeFisicaRequest(

        Integer id,
        @NotBlank(message = "A atividade física não pode ser vazia.")
        String atividadeFisica) {
}
