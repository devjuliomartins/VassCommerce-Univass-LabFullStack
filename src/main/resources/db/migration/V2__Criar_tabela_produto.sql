CREATE TABLE produto (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    foto_url VARCHAR(255),
    valor_unitario NUMERIC(38,2) NOT NULL,
    id_categoria BIGINT NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_ultima_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_produto_categoria FOREIGN KEY (id_categoria)
        REFERENCES categoria(id)
);