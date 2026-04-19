package br.com.helpchamados.service;

import br.com.helpchamados.domain.Departamento;
import br.com.helpchamados.dto.departamento.DepartamentoRequest;
import br.com.helpchamados.dto.departamento.DepartamentoResponse;
import br.com.helpchamados.exceptions.NegocioException;
import br.com.helpchamados.mapper.DepartamentoMapper;
import br.com.helpchamados.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository repository;

    @Transactional
    public DepartamentoResponse criar(DepartamentoRequest request) {
        Departamento departamento = DepartamentoMapper.toDepartamento(request);

        departamento = repository.save(departamento);

        return DepartamentoMapper.toResponse(departamento);
    }

    @Transactional(readOnly = true)
    public List<DepartamentoResponse> listarTodos() {
        return repository.findAll().stream()
                .map(DepartamentoMapper::toResponse) // Referência de métohdo chamando a classe estática!
                .toList();
    }

    @Transactional(readOnly = true)
    public DepartamentoResponse buscarPorId(UUID id) {
        Departamento departamento = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado"));

        return DepartamentoMapper.toResponse(departamento);
    }

    @Transactional
    public void inativar(UUID id) {
        Departamento departamento = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado"));

        departamento.setAtivo(false);
        repository.save(departamento);
    }

    @Transactional(readOnly = true)
    public Departamento buscarEntidadePorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado"));
    }

    public void validarSeEstaAtivo(Departamento departamento) {
        if (!departamento.getAtivo()) {
            throw new NegocioException("O departamento '" + departamento.getNome() + "' está inativo.");
        }
    }
}
