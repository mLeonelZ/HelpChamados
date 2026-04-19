package br.com.helpchamados.dto.usuarios;

import br.com.helpchamados.enums.TipoUsuario;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UsuarioResponse(
        UUID id,
        String usuario,
        String nome,
        String email,
        TipoUsuario tipo,
        Boolean ativo,
        String nomeDepartamento
) {
}
