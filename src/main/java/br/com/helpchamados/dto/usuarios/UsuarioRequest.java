package br.com.helpchamados.dto.usuarios;

import br.com.helpchamados.enums.TipoUsuario;

import java.util.UUID;

public record UsuarioRequest(
        String usuario,
        String senha,
        String nome,
        String email,
        TipoUsuario tipo,
        UUID departamentoId
) {
}
