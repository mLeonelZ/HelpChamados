package br.com.helpchamados.dto.departamento;

import lombok.Builder;

import java.util.UUID;

@Builder
public record DepartamentoResponse(
        UUID id,
        String nome,
        String descricao,
        Boolean ativo
) {
}
