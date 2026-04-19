package br.com.helpchamados.domain;

import br.com.helpchamados.enums.Prioridade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_slas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sla {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Prioridade prioridade;

    @Column(nullable = false)
    private Integer tempo_resposta_horas;

    @Column(nullable = false)
    private Integer tempo_resolucao_horas;

    @Column(nullable = false)
    private Boolean ativo = true;

    @Column(updatable = false)
    private LocalDateTime criado_em;

    @PrePersist
    protected void onCreate(){
        this.criado_em = LocalDateTime.now();
    }

}
