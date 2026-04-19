package br.com.helpchamados.dto.sla;

import br.com.helpchamados.enums.Prioridade;
import lombok.Builder;

import java.util.UUID;

@Builder
public record SlaResponse(
        UUID id,
        String nome,
        Prioridade prioridade,
        Integer tempo_resposta_horas,
        Integer tempo_resolucao_horas,
        Boolean ativo
) {
}
