ALTER TABLE dietas_atualizadas MODIFY COLUMN foto LONGBLOB;

ALTER TABLE treino_atualizado MODIFY COLUMN foto LONGBLOB;

ALTER TABLE exercicio_em_casa MODIFY COLUMN foto LONGBLOB;

ALTER TABLE fit_dance MODIFY COLUMN foto LONGBLOB;

ALTER TABLE cha_desinchar MODIFY COLUMN foto LONGBLOB;

ALTER TABLE marmita_fit MODIFY COLUMN foto LONGBLOB;

ALTER TABLE detox MODIFY COLUMN foto LONGBLOB;

ALTER TABLE cardapio_atualizados MODIFY COLUMN foto LONGBLOB;


ALTER TABLE tb_calculo_tdee
DROP PRIMARY KEY;

ALTER TABLE tb_calculo_tdee
    MODIFY COLUMN id INT AUTO_INCREMENT PRIMARY KEY;


ALTER TABLE dieta_detalhada DROP CONSTRAINT dieta_detalhada_ibfk_2;
ALTER TABLE dieta_detalhada DROP CONSTRAINT dieta_detalhada_ibfk_4;
ALTER TABLE dieta_detalhada DROP CONSTRAINT dieta_detalhada_ibfk_5;


ALTER TABLE dieta_detalhada
DROP COLUMN id_dia_semana,
DROP COLUMN id_ingredientes,
DROP COLUMN id_unidade_de_medida,
DROP COLUMN quantidade;


ALTER TABLE dieta_detalhada
    ADD COLUMN dietas TEXT;

ALTER TABLE pagamento
    MODIFY COLUMN payment_method INT;


ALTER TABLE pagamento
    ADD FOREIGN KEY (payment_method) REFERENCES meio_de_pagamento (id_ordenador_pagamento);


ALTER TABLE receitas_cha_desinchar DROP CONSTRAINT receitas_cha_desinchar_ibfk_1;
ALTER TABLE receitas_cha_desinchar DROP CONSTRAINT receitas_cha_desinchar_ibfk_3;

ALTER TABLE receitas_cha_desinchar
DROP COLUMN id_ingredientes,
DROP COLUMN id_unidade_de_medida,
DROP COLUMN quantidade;

ALTER TABLE receita_marmita_fit DROP CONSTRAINT receita_marmita_fit_ibfk_2;
ALTER TABLE receita_marmita_fit DROP CONSTRAINT receita_marmita_fit_ibfk_3;

ALTER TABLE receita_marmita_fit
DROP COLUMN id_ingredientes,
DROP COLUMN id_unidade_de_medida,
DROP COLUMN quantidade;

ALTER TABLE receita_detox DROP CONSTRAINT receita_detox_ibfk_1;
ALTER TABLE receita_detox DROP CONSTRAINT receita_detox_ibfk_3;

ALTER TABLE receita_detox
DROP COLUMN id_ingredientes,
DROP COLUMN id_unidade_de_medida,
DROP COLUMN quantidadade;


ALTER TABLE receitas_cha_desinchar
    ADD COLUMN ingredientes TEXT;

ALTER TABLE receita_marmita_fit
    ADD COLUMN ingredientes TEXT;

ALTER TABLE receita_detox
    ADD COLUMN ingredientes TEXT;

ALTER TABLE detox
DROP COLUMN modo_de_preparo;

ALTER TABLE marmita_fit
DROP COLUMN modo_de_preparo;

ALTER TABLE cha_desinchar
DROP COLUMN modo_de_preparo;

ALTER TABLE receitas_cha_desinchar
    ADD COLUMN modo_de_preparo TEXT;

ALTER TABLE receita_marmita_fit
    ADD COLUMN modo_de_preparo TEXT;

ALTER TABLE receita_detox
    ADD COLUMN modo_de_preparo TEXT;



ALTER TABLE cardapio_detalhado DROP CONSTRAINT cardapio_detalhado_ibfk_3;
ALTER TABLE cardapio_detalhado DROP CONSTRAINT cardapio_detalhado_ibfk_4;
ALTER TABLE cardapio_detalhado DROP CONSTRAINT cardapio_detalhado_ibfk_5;

-- Remover as colunas
ALTER TABLE cardapio_detalhado
DROP COLUMN id_dia_semana,
DROP COLUMN id_ingredientes,
DROP COLUMN id_unidade_de_medida,
DROP COLUMN quantidade;

-- Adicionar a nova coluna dietas do tipo TEXT
ALTER TABLE cardapio_detalhado
    ADD COLUMN cardapios TEXT;

ALTER TABLE cardapio_detalhado
    ADD COLUMN modo_de_preparo TEXT;

ALTER TABLE cardapio_detalhado
    ADD COLUMN descricao_alimentacao_diaria TEXT;


INSERT INTO `tb_atividade_fisica`
(`atividade_fisica`)
VALUES
    ('Nenhum'),
    ('Baixo'),
    ('Moderado'),
    ('Frequente');


INSERT INTO `tb_objetivo`
(`id`, `objetivo`)
VALUES
    (1, 'Emagrecer'),
    (2, 'Emagrecer agressivo'),
    (3, 'Manter'),
    (4, 'Ganhos secos'),
    (5, 'Ganhar agressivo');

INSERT INTO `alimentacoes_diarias`
(`id`, `alimentacao_diaria`)
VALUES
    (1, 'Café da manhã'),
    (2, 'Lanche da manhã'),
    (3, 'Almoço'),
    (4, 'Lanche da tarde'),
    (5, 'Jantar'),
    (6, 'Ceia');