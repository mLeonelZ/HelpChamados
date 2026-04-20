package br.com.helpchamados.dto.chamado;

import br.com.helpchamados.enums.CanalAtendimento;

import java.util.UUID;

public record ChamadoRequest(
        UUID abertoPor,
        UUID categoriaId,
        String assunto,
        String descricao,
        CanalAtendimento canal
){
}
