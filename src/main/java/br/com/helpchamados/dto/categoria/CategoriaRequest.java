package br.com.helpchamados.dto.categoria;

import java.util.UUID;

public record CategoriaRequest(
        String nome,
        String descricao,
        UUID slaId
) {
}
