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


ALTER TABLE treino_completo DROP CONSTRAINT treino_completo_ibfk_2;
ALTER TABLE treino_completo DROP CONSTRAINT treino_completo_ibfk_3;

ALTER TABLE treino_completo
DROP COLUMN id_exercicio,
DROP COLUMN id_musculo;

ALTER TABLE treino_completo
    ADD COLUMN treinos TEXT;


INSERT INTO `iouone`.`tipo_treino`
(`id`,
 `tipo_treino`)
VALUES
    (1, 'Aquecimento'),
    (2, 'Treino Principal'),
    (3, 'Finalização');



INSERT INTO `iouone`.`treino_completo`
(`id`, `id_tipo_treino`, `id_treino_atualizado`, `treinos`)
VALUES
    (1, 1, 1, 'Polichinelos (2 min), Corrida estacionária (3 min), Skipping alto e deslocamento lateral (5 min)'),
    (2, 2, 1, 'Burpees (3 x 15), Agachamento com salto (3 x 12), Kettlebell swing (3 x 15), Corrida de 40 metros (4 repetições), Prancha com toque no ombro (3 x 30 seg)'),
    (3, 3, 1, 'Alongamento dinâmico e respiração profunda'),

    (4, 1, 2, 'Mobilidade articular, Ativação muscular com resistência leve'),
    (5, 2, 2, 'Agachamento livre (4 x 10), Supino reto (4 x 8), Levantamento terra (4 x 8), Desenvolvimento com halteres (3 x 12), Barra fixa (3 x 8)'),
    (6, 3, 2, 'Alongamento para recuperação muscular'),

    (7, 1, 3, 'Mobilidade ativa, Ativação com elástico'),
    (8, 2, 3, 'Agachamento com carga máxima (5 x 5), Levantamento terra (5 x 5), Remada curvada (4 x 8), Sprint de 40m (4 repetições), Prancha isométrica (3 x 40 seg)'),
    (9, 3, 3, 'Liberação miofascial e alongamento'),

    (10, 1, 4, 'Mobilidade articular e ativação leve'),
    (11, 2, 4, 'Circuito funcional: Agachamento, burpee, corrida estacionária (3 rodadas), Sprint 30m (4 repetições), Saltos pliométricos (3 x 12)'),
    (12, 3, 4, 'Alongamento e técnicas de respiração profunda'),

    (13, 1, 5, 'Polichinelos e corrida estacionária (5 min), Exercícios dinâmicos com resistência leve'),
    (14, 2, 5, 'Circuito: Agachamento, flexão, barra fixa, remada, desenvolvimento (3 rodadas), Sprint 50m (4 repetições), Saltos em caixa (3 x 12), Medicine ball slam (3 x 15)'),
    (15, 3, 5, 'Alongamento ativo'),

    (16, 1, 6, 'Rolamento articular e exercícios de ativação leve'),
    (17, 2, 6, 'Alongamentos dinâmicos para quadril, ombros e coluna, Exercícios de mobilidade como "world’s greatest stretch", Pistol squat assistido (3 x 8), Ponte de glúteo (3 x 12), Alongamento estático final'),
    (18, 3, 6, 'Respiração profunda e relaxamento'),

    (19, 1, 7, 'Corrida leve + movimentos dinâmicos'),
    (20, 2, 7, 'Burpees, Agachamento com salto, Mountain climbers, Sprint de 20m, Prancha dinâmica'),
    (21, 3, 7, 'Alongamento e liberação muscular'),

    (22, 1, 8, 'Exercícios de ativação leve e mobilidade'),
    (23, 2, 8, 'Ponte de glúteo (3 x 15), Agachamento sem carga (3 x 12), Exercícios com elástico (ombros e joelhos), Marcha estacionária controlada (3 x 30s)'),
    (24, 3, 8, 'Alongamento e mobilização articular'),

    (25, 1, 9, 'Mobilidade e ativação muscular'),
    (26, 2, 9, 'Agachamento livre (4 x 12), Supino inclinado (4 x 10), Levantamento terra romeno (3 x 12), Remada curvada (3 x 10), Desenvolvimento com halteres (3 x 12)'),
    (27, 3, 9, 'Alongamento e respiração'),

    (28, 1, 10, 'Saltos laterais e corrida estacionária'),
    (29, 2, 10, 'Circuito: 30s cada exercício, 10s descanso (3 rodadas) - Burpees, Agachamento, Flexão de braço, Corrida de 30m, Prancha dinâmica'),
    (30, 3, 10, 'Alongamento e recuperação ativa');