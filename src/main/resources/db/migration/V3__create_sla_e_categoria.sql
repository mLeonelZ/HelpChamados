CREATE TABLE tb_slas (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(100) NOT NULL,
    prioridade VARCHAR(50) NOT NULL,
    tempo_resposta_horas INT NOT NULL,
    tempo_resolucao_horas INT NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_categorias (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    sla_padrao_id UUID NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_sla_padrao FOREIGN KEY (sla_padrao_id) REFERENCES tb_slas(id)
);