Create SCHEMA IOUONE;
USE
IOUONE;

-- TABELA ATIVIDADE FISICA --
CREATE TABLE tb_atividade_fisica
(
    id               int PRIMARY KEY auto_increment,
    atividade_fisica varchar(50)
);

-- TABELA PESSOA --
CREATE TABLE tb_pessoa
(
    id                  INT AUTO_INCREMENT,
    cpf                 VARCHAR(11)  NOT NULL UNIQUE,
    nome                VARCHAR(255) NOT NULL,
    email               VARCHAR(255) NOT NULL UNIQUE,
    senha               VARCHAR(32)  NOT NULL,
    celular             VARCHAR(15),
    dt_nascimento       DATE         NOT NULL,
    fk_atividade_fisica int UNIQUE,

    CONSTRAINT fk_atividadade_pessoa_id FOREIGN KEY (fk_atividade_fisica) REFERENCES tb_atividade_fisica (id),
    PRIMARY KEY (id)
);

-- TABELA MENSAGEM --
CREATE TABLE tb_mensagens
(
    id             int PRIMARY KEY auto_increment,
    mensagem       TEXT      NOT NULL,
    data_envio     TIMESTAMP NOT NULL,
    fk_enviado_por INT       NOT NULL,

    CONSTRAINT fk_mensagem_pessoa_id FOREIGN KEY (fk_enviado_por) REFERENCES tb_pessoa (id)
);

-- TABELA COMENTARIO_MENSAGEM --
CREATE TABLE tb_comentario_mensagem
(
    id                     int PRIMARY KEY auto_increment,
    fk_mensagem_inicial    int not null,
    fk_mensagem_comentario int not null,

    CONSTRAINT fk_mensagem_inicial_id FOREIGN KEY (fk_mensagem_inicial) REFERENCES tb_mensagens (id),
    CONSTRAINT fk_mensagem_comentario_id FOREIGN KEY (fk_mensagem_comentario) REFERENCES tb_mensagens (id)
);

-- TABELA DADOS CORPORAIS --
CREATE TABLE tb_dados_corporais
(
    id         int PRIMARY KEY auto_increment,
    altura     int(3) NOT NULL,
    peso_atual int(6) NOT NULL,
    peso_ideal int(6) NOT NULL,
    fk_pessoa  int NOT NULL UNIQUE,

    CONSTRAINT fk_dados_corporais_pessoa_id FOREIGN KEY (fk_pessoa) REFERENCES tb_pessoa (id)
);


INSERT INTO `IOUONE`.`tb_atividade_fisica` (`id`, `atividade_fisica`)
VALUES (1, 'test1');
INSERT INTO `IOUONE`.`tb_atividade_fisica` (`id`, `atividade_fisica`)
VALUES (2, 'test2');
INSERT INTO `IOUONE`.`tb_atividade_fisica` (`id`, `atividade_fisica`)
VALUES (3, 'test3');
INSERT INTO `IOUONE`.`tb_atividade_fisica` (`id`, `atividade_fisica`)
VALUES (4, 'test4');

