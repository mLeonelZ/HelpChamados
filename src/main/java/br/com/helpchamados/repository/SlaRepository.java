package br.com.helpchamados.repository;

import br.com.helpchamados.domain.Sla;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SlaRepository extends JpaRepository<Sla, UUID> {
}
