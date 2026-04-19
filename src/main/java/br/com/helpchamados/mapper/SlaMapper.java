package br.com.helpchamados.mapper;

import br.com.helpchamados.domain.Sla;
import br.com.helpchamados.dto.sla.SlaRequest;
import br.com.helpchamados.dto.sla.SlaResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SlaMapper {

    public static Sla toSla(SlaRequest request){
        Sla sla = new Sla();
        sla.setNome(request.nome());
        sla.setPrioridade(request.prioridade());
        sla.setTempo_resposta_horas(request.tempo_resposta_horas());
        sla.setTempo_resolucao_horas(request.tempo_resolucao_horas());

        return sla;
    }

    public static SlaResponse toResponse(Sla sla){
        return SlaResponse.builder()
                .id(sla.getId())
                .nome(sla.getNome())
                .prioridade(sla.getPrioridade())
                .tempo_resposta_horas(sla.getTempo_resposta_horas())
                .tempo_resolucao_horas(sla.getTempo_resolucao_horas())
                .ativo(sla.getAtivo())
                .build();
    }

}
