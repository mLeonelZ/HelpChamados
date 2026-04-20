package br.com.helpchamados.service;

import br.com.helpchamados.domain.Departamento;
import br.com.helpchamados.domain.Usuario;
import br.com.helpchamados.dto.usuarios.UsuarioRequest;
import br.com.helpchamados.dto.usuarios.UsuarioResponse;
import br.com.helpchamados.mapper.UsuarioMapper;
import br.com.helpchamados.repository.DepartamentoRepository;
import br.com.helpchamados.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final DepartamentoService departamentoService;

    @Transactional
    public UsuarioResponse criar(UsuarioRequest request) {
        Departamento departamento = departamentoService.buscarEntidadePorId(request.departamentoId());

        departamentoService.validarSeEstaAtivo(departamento);

        Usuario usuario = UsuarioMapper.toUsuario(request);
        usuario.setDepartamento(departamento);
        usuario = repository.save(usuario);

        return UsuarioMapper.toResponse(usuario);
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponse> listarTodos() {
        return repository.findAll().stream()
                .map(UsuarioMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }
}