package br.com.helpchamados.service;

import br.com.helpchamados.domain.Categoria;
import br.com.helpchamados.domain.Chamado;
import br.com.helpchamados.domain.Sla;
import br.com.helpchamados.domain.Usuario;
import br.com.helpchamados.dto.chamado.ChamadoRequest;
import br.com.helpchamados.dto.chamado.ChamadoResponse;
import br.com.helpchamados.mapper.ChamadoMapper;
import br.com.helpchamados.repository.ChamadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChamadoService {

    private final ChamadoRepository repository;
    private final UsuarioService usuarioService;
    private final CategoriaService categoriaService;


    @Transactional
    public ChamadoResponse criar(ChamadoRequest request){
        Usuario cliente = usuarioService.buscarPorId(request.abertoPor());
        Categoria categoria = categoriaService.buscarEntidadePorId(request.categoriaId());

        Sla sla = categoria.getSlaPadrao();
        Chamado chamado = ChamadoMapper.toChamado(request);

        chamado.setAbertoPor(cliente);
        chamado.setCategoria(categoria);
        chamado.setSla(sla);

        chamado.setPrioridade(sla.getPrioridade());
        LocalDateTime agora = LocalDateTime.now();
        chamado.setPrazoResposta(agora.plusHours(sla.getTempo_resposta_horas()));
        chamado.setPrazoResolucao(agora.plusHours(sla.getTempo_resolucao_horas()));

        Chamado chamadoSalvo = repository.save(chamado);
        return ChamadoMapper.toResponse(chamadoSalvo);
    }
}
