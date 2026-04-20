package br.com.helpchamados.dto.chamado;

import br.com.helpchamados.enums.CanalAtendimento;
import br.com.helpchamados.enums.Prioridade;
import br.com.helpchamados.enums.StatusChamado;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record ChamadoResponse(
        UUID id,
        String assunto,
        String descricao,
        StatusChamado status,
        Prioridade prioridade,
        CanalAtendimento canal,
        LocalDateTime dataHoraAbertura,
        LocalDateTime prazoResposta,
        LocalDateTime prazoResolucao,
        Boolean slaViolado,
        UUID categoriaId,
        String nomeCategoria,
        UUID abertoPorId,
        String nomeAbertoPor,
        UUID atendenteId,
        String nomeAtendente
){
}
