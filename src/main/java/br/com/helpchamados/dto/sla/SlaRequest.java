package br.com.helpchamados.dto.sla;

import br.com.helpchamados.enums.Prioridade;

public record SlaRequest(
        String nome,
        Prioridade prioridade,
        Integer tempo_resposta_horas,
        Integer tempo_resolucao_horas
) {
}
