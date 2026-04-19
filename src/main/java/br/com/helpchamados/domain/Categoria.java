package br.com.helpchamados.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_categorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private Boolean ativo = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sla_padrao_id", nullable = false)
    private Sla slaPadrao;

    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criado_em;

    @PrePersist
    protected void onCreate(){
        this.criado_em = LocalDateTime.now();
    }

}
