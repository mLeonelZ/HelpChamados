package br.com.helpchamados.mapper;

import br.com.helpchamados.domain.Categoria;
import br.com.helpchamados.dto.categoria.CategoriaRequest;
import br.com.helpchamados.dto.categoria.CategoriaResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoriaMapper {

    public Categoria toCategoria(CategoriaRequest request){
        Categoria categoria = new Categoria();
        categoria.setNome(request.nome());
        categoria.setDescricao(request.descricao());

        return categoria;
    }

    public CategoriaResponse toResponse(Categoria categoria){
        return CategoriaResponse.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .descricao(categoria.getDescricao())
                .ativo(categoria.getAtivo())
                .slaId(categoria.getSlaPadrao() != null ? categoria.getSlaPadrao().getId() : null)
                .nomeSla(categoria.getSlaPadrao() != null ? categoria.getSlaPadrao().getNome() : "Sem SLA")
                .build();
    }

}
