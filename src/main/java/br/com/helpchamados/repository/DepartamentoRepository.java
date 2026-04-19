package br.com.helpchamados.repository;

import br.com.helpchamados.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartamentoRepository extends JpaRepository<Departamento, UUID> {

}
