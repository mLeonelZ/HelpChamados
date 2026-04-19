package br.com.helpchamados.mapper;

import br.com.helpchamados.domain.Usuario;
import br.com.helpchamados.dto.usuarios.UsuarioRequest;
import br.com.helpchamados.dto.usuarios.UsuarioResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioMapper {

    public Usuario toUsuario(UsuarioRequest request){
        Usuario usuario = new Usuario();
        usuario.setUsuario(request.usuario());
        usuario.setSenha(request.senha());
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setTipo(request.tipo());

        return usuario;
    }

    public UsuarioResponse toResponse(Usuario usuario){
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .usuario(usuario.getUsuario())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .tipo(usuario.getTipo())
                .ativo(usuario.getAtivo())
                .nomeDepartamento(usuario.getDepartamento() != null ? usuario.getDepartamento().getNome() : "Sem departamento")
                .build();
    }

}
