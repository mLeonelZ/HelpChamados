CREATE TABLE tb_chamados (
    id UUID PRIMARY KEY,

    aberto_por UUID NOT NULL,
    atendente UUID,
    categoria_id UUID NOT NULL,
    sla_id UUID NOT NULL,
    departamento_id UUID,

    assunto VARCHAR(150) NOT NULL,
    descricao TEXT NOT NULL,

    prioridade VARCHAR(50) NOT NULL,
    situacao VARCHAR(50) NOT NULL,
    canal VARCHAR(50) NOT NULL,

    data_hora_abertura TIMESTAMP NOT NULL,
    data_primeira_resposta TIMESTAMP,
    prazo_resposta TIMESTAMP NOT NULL,
    prazo_resolucao TIMESTAMP NOT NULL,
    data_hora_fechamento TIMESTAMP,
    sla_violado BOOLEAN NOT NULL DEFAULT FALSE,

    criado_em TIMESTAMP,
    atualizado_em TIMESTAMP,

    CONSTRAINT fk_chamado_aberto_por FOREIGN KEY (aberto_por) REFERENCES tb_usuarios(id),
    CONSTRAINT fk_chamado_atendente FOREIGN KEY (atendente) REFERENCES tb_usuarios(id),
    CONSTRAINT fk_chamado_categoria FOREIGN KEY (categoria_id) REFERENCES tb_categorias(id),
    CONSTRAINT fk_chamado_sla FOREIGN KEY (sla_id) REFERENCES tb_slas(id),
    CONSTRAINT fk_chamado_departamento FOREIGN KEY (departamento_id) REFERENCES tb_departamentos(id)
);