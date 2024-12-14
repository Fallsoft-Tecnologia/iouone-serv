-- TABELA ATIVIDADE FISICA --
CREATE TABLE tb_atividade_fisica
(
    id               int PRIMARY KEY auto_increment,
    atividade_fisica varchar(50)
);

-- TABELA ENDERECO --
CREATE TABLE tb_endereco
(
    id       INT AUTO_INCREMENT,
    endereco varchar(255),
    cidade   varchar(255),
    estado   varchar(20),
    pais     varchar(10),
    cep      varchar(20),

    PRIMARY KEY (id)

);

-- TABELA DADOS CORPORAIS --
CREATE TABLE tb_dados_corporais
(
    id         int PRIMARY KEY auto_increment,
    altura     float NOT NULL,
    peso_atual float NOT NULL,
    peso_ideal float NOT NULL
);


-- TABELA PESSOA --
CREATE TABLE tb_pessoa
(
    id                  INT AUTO_INCREMENT,
    cpf                 VARCHAR(11) UNIQUE,
    nome                VARCHAR(255),
    email               VARCHAR(255) UNIQUE,
    senha               TEXT,
    celular             VARCHAR(15),
    dt_nascimento       DATE,
    customer_id         VARCHAR(255),
    fluxo_id            VARCHAR(255),
    fk_atividade_fisica int,
    fk_endereco         int,
    fk_dados_corporais  int,

    CONSTRAINT fk_atividadade_pessoa_id FOREIGN KEY (fk_atividade_fisica) REFERENCES tb_atividade_fisica (id),
    CONSTRAINT fk_endereco_pessoa_id FOREIGN KEY (fk_endereco) REFERENCES tb_endereco (id),
    CONSTRAINT fk_dados_corporais_pessoa_id FOREIGN KEY (fk_dados_corporais) REFERENCES tb_dados_corporais (id),
    PRIMARY KEY (id)
);


-- Criação da tabela tb_mensagens
CREATE TABLE tb_mensagens
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    mensagem       TEXT     NOT NULL,
    data_envio     DATETIME NOT NULL,
    fk_enviado_por INT      NOT NULL,
    CONSTRAINT fk_enviado_por FOREIGN KEY (fk_enviado_por) REFERENCES tb_pessoa (id)
);

-- Criação da tabela tb_comentario_mensagem
CREATE TABLE tb_comentario_mensagem
(
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    fk_mensagem_inicial INT      NOT NULL,
    mensagem_comentario TEXT     NOT NULL,
    fk_comentario_pai   INT DEFAULT NULL,
    data_envio          DATETIME NOT NULL,
    pessoa_id           INT      NOT NULL,
    CONSTRAINT fk_mensagem_inicial FOREIGN KEY (fk_mensagem_inicial) REFERENCES tb_mensagens (id),
    CONSTRAINT fk_comentario_pai FOREIGN KEY (fk_comentario_pai) REFERENCES tb_comentario_mensagem (id),
    CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES tb_pessoa (id)
);



CREATE TABLE dietas_atualizadas
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    nome      VARCHAR(255),
    descricao TEXT,
    foto      BLOB
);

CREATE TABLE treino_atualizado
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    nome      VARCHAR(255),
    descricao TEXT,
    foto      BLOB
);

CREATE TABLE tipo_treino
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    tipo_treino VARCHAR(255)
);

CREATE TABLE exercicio_em_casa
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    nome            VARCHAR(255),
    url_treino_casa VARCHAR(255),
    video           BLOB,
    foto            BLOB
);

CREATE TABLE fit_dance
(
    id                INT PRIMARY KEY AUTO_INCREMENT,
    nome              VARCHAR(255),
    url_fit_dance     VARCHAR(255),
    video             BLOB,
    contador_vistos   INT,
    id_tipo_fit_dance INT,
    autor             VARCHAR(255),
    foto              BLOB
);

CREATE TABLE tipo_fit_dance
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    tipo_fit_dance VARCHAR(255)
);

CREATE TABLE cha_desinchar
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    nome            VARCHAR(255),
    descricao       TEXT,
    modo_de_preparo TEXT,
    foto            BLOB
);

CREATE TABLE dia_semana
(
    id         INT PRIMARY KEY,
    dia_semana VARCHAR(30)
);

CREATE TABLE alimentacoes_diarias
(
    id                 INT PRIMARY KEY,
    alimentacao_diaria VARCHAR(255)
);

CREATE TABLE dieta_detalhada
(
    id                      INT PRIMARY KEY,
    id_alimentacoes_diarias INT,
    id_dia_semana           INT,
    id_dietas_atualizadas   INT,
    id_ingredientes         INT,
    id_unidade_de_medida    INT,
    quantidade              FLOAT
);

CREATE TABLE cardapio_atualizados
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    nome      VARCHAR(255),
    descricao TEXT,
    foto      BLOB
);

CREATE TABLE cardapio_detalhado
(
    id                      INT PRIMARY KEY AUTO_INCREMENT,
    quantidade              FLOAT,
    id_cardapio_atualizados INT,
    id_alimentacoes_diarias INT,
    id_dia_semana           INT,
    id_unidade_de_medida    INT,
    id_ingredientes         INT
);

CREATE TABLE cha_gordura
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    nome            VARCHAR(255),
    descricao       TEXT,
    modo_de_preparo TEXT,
    foto            BLOB
);

CREATE TABLE marmita_fit
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    nome            VARCHAR(255),
    descricao       TEXT,
    modo_de_preparo TEXT,
    foto            BLOB
);

CREATE TABLE detox
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    nome            VARCHAR(255),
    descricao       TEXT,
    modo_de_preparo TEXT,
    foto            BLOB
);

CREATE TABLE ingredientes
(
    id   INT PRIMARY KEY,
    nome VARCHAR(100)
);

CREATE TABLE receitas_cha_desinchar
(
    id                   INT PRIMARY KEY,
    quantidade           FLOAT,
    id_ingredientes      INT,
    id_cha_desinchar     INT,
    id_unidade_de_medida INT
);

CREATE TABLE receita_detox
(
    id                   INT PRIMARY KEY,
    quantidadade         FLOAT,
    id_ingredientes      INT,
    id_detox             INT,
    id_unidade_de_medida INT
);

CREATE TABLE unidade_de_medida
(
    id                INT PRIMARY KEY,
    unidade_de_medida VARCHAR(10)
);

CREATE TABLE receita_cha_gordura
(
    id                   INT PRIMARY KEY,
    quantidade           FLOAT,
    id_ingredientes      INT,
    id_cha_gordura       INT,
    id_unidade_de_medida INT
);

CREATE TABLE receita_marmita_fit
(
    id                   INT PRIMARY KEY,
    quantidade           INT,
    id_marmita_fit       INT,
    id_ingredientes      INT,
    id_unidade_de_medida INT
);

CREATE TABLE musculo
(
    id      INT PRIMARY KEY,
    musculo VARCHAR(255)
);

CREATE TABLE exercicio
(
    id        INT PRIMARY KEY,
    exercicio TEXT
);

CREATE TABLE treino_completo
(
    id                   INT PRIMARY KEY,
    id_tipo_treino       INT,
    id_exercicio         INT,
    id_musculo           INT,
    id_treino_atualizado INT
);

CREATE TABLE tb_biotipo
(
    id      INT PRIMARY KEY,
    biotipo VARCHAR(255)
);

CREATE TABLE tb_objetivo
(
    id       INT PRIMARY KEY,
    objetivo VARCHAR(255)
);

CREATE TABLE tb_calculo_tdee
(
    id           INT PRIMARY KEY,
    tdee DOUBLE,
    calorias_diarias DOUBLE,
    data_calculo DATE,
    fk_pessoa    int,
    fk_objetivo  int,
    fk_biotipo   int
);

ALTER TABLE tb_calculo_tdee
    ADD FOREIGN KEY (fk_pessoa) REFERENCES tb_pessoa (id);
ALTER TABLE tb_calculo_tdee
    ADD FOREIGN KEY (fk_objetivo) REFERENCES tb_objetivo (id);
ALTER TABLE tb_calculo_tdee
    ADD FOREIGN KEY (fk_biotipo) REFERENCES tb_biotipo (id);
ALTER TABLE fit_dance
    ADD FOREIGN KEY (id_tipo_fit_dance) REFERENCES tipo_fit_dance (id);
ALTER TABLE dieta_detalhada
    ADD FOREIGN KEY (id_alimentacoes_diarias) REFERENCES alimentacoes_diarias (id);
ALTER TABLE dieta_detalhada
    ADD FOREIGN KEY (id_dia_semana) REFERENCES dia_semana (id);
ALTER TABLE dieta_detalhada
    ADD FOREIGN KEY (id_dietas_atualizadas) REFERENCES dietas_atualizadas (id);
ALTER TABLE dieta_detalhada
    ADD FOREIGN KEY (id_ingredientes) REFERENCES ingredientes (id);
ALTER TABLE dieta_detalhada
    ADD FOREIGN KEY (id_unidade_de_medida) REFERENCES unidade_de_medida (id);
ALTER TABLE cardapio_detalhado
    ADD FOREIGN KEY (id_cardapio_atualizados) REFERENCES cardapio_atualizados (id);
ALTER TABLE cardapio_detalhado
    ADD FOREIGN KEY (id_alimentacoes_diarias) REFERENCES alimentacoes_diarias (id);
ALTER TABLE cardapio_detalhado
    ADD FOREIGN KEY (id_dia_semana) REFERENCES dia_semana (id);
ALTER TABLE cardapio_detalhado
    ADD FOREIGN KEY (id_unidade_de_medida) REFERENCES unidade_de_medida (id);
ALTER TABLE cardapio_detalhado
    ADD FOREIGN KEY (id_ingredientes) REFERENCES ingredientes (id);
ALTER TABLE receitas_cha_desinchar
    ADD FOREIGN KEY (id_ingredientes) REFERENCES ingredientes (id);
ALTER TABLE receitas_cha_desinchar
    ADD FOREIGN KEY (id_cha_desinchar) REFERENCES cha_desinchar (id);
ALTER TABLE receitas_cha_desinchar
    ADD FOREIGN KEY (id_unidade_de_medida) REFERENCES unidade_de_medida (id);
ALTER TABLE receita_detox
    ADD FOREIGN KEY (id_ingredientes) REFERENCES ingredientes (id);
ALTER TABLE receita_detox
    ADD FOREIGN KEY (id_detox) REFERENCES detox (id);
ALTER TABLE receita_detox
    ADD FOREIGN KEY (id_unidade_de_medida) REFERENCES unidade_de_medida (id);
ALTER TABLE receita_cha_gordura
    ADD FOREIGN KEY (id_ingredientes) REFERENCES ingredientes (id);
ALTER TABLE receita_cha_gordura
    ADD FOREIGN KEY (id_cha_gordura) REFERENCES cha_gordura (id);
ALTER TABLE receita_cha_gordura
    ADD FOREIGN KEY (id_unidade_de_medida) REFERENCES unidade_de_medida (id);
ALTER TABLE receita_marmita_fit
    ADD FOREIGN KEY (id_marmita_fit) REFERENCES marmita_fit (id);
ALTER TABLE receita_marmita_fit
    ADD FOREIGN KEY (id_ingredientes) REFERENCES ingredientes (id);
ALTER TABLE receita_marmita_fit
    ADD FOREIGN KEY (id_unidade_de_medida) REFERENCES unidade_de_medida (id);
ALTER TABLE treino_completo
    ADD FOREIGN KEY (id_tipo_treino) REFERENCES tipo_treino (id);
ALTER TABLE treino_completo
    ADD FOREIGN KEY (id_exercicio) REFERENCES exercicio (id);
ALTER TABLE treino_completo
    ADD FOREIGN KEY (id_musculo) REFERENCES musculo (id);
ALTER TABLE treino_completo
    ADD FOREIGN KEY (id_treino_atualizado) REFERENCES treino_atualizado (id);



INSERT INTO `IOUONE`.`tb_atividade_fisica` (`id`, `atividade_fisica`)
VALUES (1, 'test1');
INSERT INTO `IOUONE`.`tb_atividade_fisica` (`id`, `atividade_fisica`)
VALUES (2, 'test2');
INSERT INTO `IOUONE`.`tb_atividade_fisica` (`id`, `atividade_fisica`)
VALUES (3, 'test3');
INSERT INTO `IOUONE`.`tb_atividade_fisica` (`id`, `atividade_fisica`)
VALUES (4, 'test4');

INSERT INTO iouone.tb_biotipo (id, biotipo)
VALUES (1, 'Ectomorfo');
INSERT INTO iouone.tb_biotipo (id, biotipo)
VALUES (2, 'Mesomorfo');
INSERT INTO iouone.tb_biotipo (id, biotipo)
VALUES (3, 'Endomorfo');

INSERT INTO iouone.tb_objetivo (id, objetivo)
VALUES (1, 'Perda de Peso');
INSERT INTO iouone.tb_objetivo (id, objetivo)
VALUES (2, 'Ganho de Massa Muscular');
INSERT INTO iouone.tb_objetivo (id, objetivo)
VALUES (3, 'Manutenção');



