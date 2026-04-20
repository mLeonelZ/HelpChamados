package br.com.helpchamados.domain;

import br.com.helpchamados.enums.CanalAtendimento;
import br.com.helpchamados.enums.Prioridade;
import br.com.helpchamados.enums.StatusChamado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_chamados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aberto_por", nullable = false)
    private Usuario abertoPor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atendente")
    private Usuario atendente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sla_id", nullable = false)
    private Sla sla;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @Column(nullable = false, length = 150)
    private String assunto;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao", nullable = false)
    private StatusChamado status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CanalAtendimento canal;

    @Column(name = "data_hora_abertura", nullable = false, updatable = false)
    private LocalDateTime dataHoraAbertura;

    @Column(name = "data_primeira_resposta")
    private LocalDateTime dataPrimeiraResposta;

    @Column(name = "prazo_resposta", nullable = false)
    private LocalDateTime prazoResposta;

    @Column(name = "prazo_resolucao", nullable = false)
    private LocalDateTime prazoResolucao;

    @Column(name = "data_hora_fechamento")
    private LocalDateTime dataHoraFechamento;

    @Column(name = "sla_violado", nullable = false)
    private Boolean slaViolado = false;

    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @PrePersist
    protected void onCreate(){
        LocalDateTime agora = LocalDateTime.now();
        this.criadoEm = agora;
        this.dataHoraAbertura = agora;

        if(this.status == null){
            this.status = StatusChamado.ABERTO;
        }

        if(this.slaViolado == null){
            this.slaViolado = false;
        }
    }

    @PreUpdate
    protected void onUpdate(){
        this.atualizadoEm = LocalDateTime.now();
    }
}
