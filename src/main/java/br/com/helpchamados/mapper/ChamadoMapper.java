package br.com.helpchamados.mapper;

import br.com.helpchamados.domain.Chamado;
import br.com.helpchamados.dto.chamado.ChamadoRequest;
import br.com.helpchamados.dto.chamado.ChamadoResponse;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class ChamadoMapper {

    public Chamado toChamado(ChamadoRequest request){
        Chamado chamado = new Chamado();
        chamado.setAssunto(request.assunto());
        chamado.setDescricao(request.descricao());
        chamado.setCanal(request.canal());
        return chamado;
    }

    public ChamadoResponse toResponse(Chamado chamado){

        String nomeAtendente = chamado.getAtendente() != null
                ? chamado.getAtendente().getNome()
                : "Não atribuído";
        UUID atendenteId = chamado.getAtendente() != null
                ? chamado.getAtendente().getId()
                : null;

        return ChamadoResponse.builder()
                .id(chamado.getId())
                .assunto(chamado.getAssunto())
                .descricao(chamado.getDescricao())
                .status(chamado.getStatus())
                .prioridade(chamado.getPrioridade())
                .canal(chamado.getCanal())
                .dataHoraAbertura(chamado.getDataHoraAbertura())
                .prazoResposta(chamado.getPrazoResposta())
                .prazoResolucao(chamado.getPrazoResolucao())
                .slaViolado(chamado.getSlaViolado())
                .categoriaId(chamado.getCategoria().getId())
                .nomeCategoria(chamado.getCategoria().getNome())
                .abertoPorId(chamado.getAbertoPor().getId())
                .nomeAbertoPor(chamado.getAbertoPor().getNome())
                .atendenteId(atendenteId)
                .nomeAtendente(nomeAtendente)
                .build();
    }
}
