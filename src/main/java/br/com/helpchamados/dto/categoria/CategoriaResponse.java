package br.com.helpchamados.dto.categoria;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CategoriaResponse(
        UUID id,
        String nome,
        String descricao,
        Boolean ativo,
        UUID slaId,
        String nomeSla
) {
}
