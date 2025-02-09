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




