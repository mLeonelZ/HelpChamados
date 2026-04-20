package br.com.helpchamados.service;

import br.com.helpchamados.domain.Categoria;
import br.com.helpchamados.domain.Sla;
import br.com.helpchamados.dto.categoria.CategoriaRequest;
import br.com.helpchamados.dto.categoria.CategoriaResponse;
import br.com.helpchamados.mapper.CategoriaMapper;
import br.com.helpchamados.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;
    private final SlaService slaService;

    @Transactional
    public CategoriaResponse criar(CategoriaRequest request){
        Sla sla = slaService.buscarEntidadePorId(request.slaId());
        Categoria categoria = CategoriaMapper.toCategoria(request);
        categoria.setSlaPadrao(sla);
        Categoria salva = repository.save(categoria);

        return CategoriaMapper.toResponse(salva);
    }

    @Transactional (readOnly = true)
    public List<CategoriaResponse> listar(){
        return repository.findAll()
                .stream()
                .map(categoria -> CategoriaMapper.toResponse(categoria))
                .toList();
    }

    public Categoria buscarEntidadePorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada"));
    }



}
