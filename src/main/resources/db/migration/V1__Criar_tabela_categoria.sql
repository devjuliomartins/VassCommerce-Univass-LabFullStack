CREATE TABLE categoria (
    id BIGSERIAL PRIMARY KEY,
    imagem_simbolo_url VARCHAR(255),
    nome VARCHAR(100) NOT NULL,
    descricao TEXT
);
