package br.com.helpchamados.mapper;

import br.com.helpchamados.domain.Departamento;
import br.com.helpchamados.dto.departamento.DepartamentoRequest;
import br.com.helpchamados.dto.departamento.DepartamentoResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DepartamentoMapper {

    public static Departamento toDepartamento(DepartamentoRequest request){
        Departamento departamento = new Departamento();
        departamento.setNome(request.nome());
        departamento.setDescricao(request.descricao());

        return departamento;
    }

    public static DepartamentoResponse toResponse(Departamento departamento){
        return DepartamentoResponse.builder()
                .id(departamento.getId())
                .nome(departamento.getNome())
                .descricao(departamento.getDescricao())
                .ativo(departamento.getAtivo())
                .build();
    }

}
