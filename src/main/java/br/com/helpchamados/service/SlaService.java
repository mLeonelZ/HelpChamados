package br.com.helpchamados.service;

import br.com.helpchamados.domain.Sla;
import br.com.helpchamados.dto.sla.SlaRequest;
import br.com.helpchamados.dto.sla.SlaResponse;
import br.com.helpchamados.mapper.SlaMapper;
import br.com.helpchamados.repository.SlaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SlaService {

    private final SlaRepository repository;

    @Transactional
    public SlaResponse criar(SlaRequest request){
        if (request.tempo_resposta_horas() <= 0 || request.tempo_resolucao_horas() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Os tempos de SLA devem ser maiores que zero");
        }

        Sla sla = SlaMapper.toSla(request);
        sla = repository.save(sla);

        return SlaMapper.toResponse(sla);
    }

    @Transactional(readOnly = true)
    public List<SlaResponse> listarTodos(){
        return repository.findAll().stream()
                .map(SlaMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public SlaResponse listarId(UUID id){
        Sla sla = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SLA não encontrado"));
        return SlaMapper.toResponse(sla);
    }

    public Sla buscarEntidadePorId(UUID id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SLA não encontrado"));
    }

}
