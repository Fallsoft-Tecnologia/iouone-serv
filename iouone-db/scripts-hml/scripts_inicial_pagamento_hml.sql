CREATE DATABASE IF NOT EXISTS iouone_pagamento_hml;

USE iouone_pagamento_hml;

CREATE TABLE pagamento
(
    id_pagamento     INT PRIMARY KEY AUTO_INCREMENT,
    payment_method   VARCHAR(255),
    amount           DECIMAL(12, 2),
    payment_date     DATETIME,
    status_pagamento VARCHAR(255),
    assinatura       INT
);

CREATE TABLE assinatura
(
    id_assinatura       INT PRIMARY KEY AUTO_INCREMENT,
    customer_id         VARCHAR(255),
    code_assinatura     VARCHAR(255),
    payment_method      VARCHAR(255),
    interval_assinatura VARCHAR(255),
    interval_count      INT,
    billing_type        VARCHAR(255),
    start_at            DATETIME,
    installments        INT,
    status_assinatura   VARCHAR(255),
    item_assinatura     INT
);

CREATE TABLE item_assinatura
(
    id_item_assinatura          INT PRIMARY KEY AUTO_INCREMENT,
    subscription_id             VARCHAR(255),
    name_item_assinatura        VARCHAR(255),
    description_item_assinatura VARCHAR(255),
    quantity                    INT,
    unit_price                  DECIMAL(12, 2)
);

CREATE TABLE meio_de_pagamento
(
    id_ordenador_pagamento INT PRIMARY KEY AUTO_INCREMENT,
    meio_de_pagamento      ENUM('CREDIT_CARD', 'DEBIT_CARD', 'PIX') NOT NULL
);

ALTER TABLE pagamento
    ADD FOREIGN KEY (assinatura) REFERENCES assinatura (id_assinatura);
ALTER TABLE assinatura
    ADD FOREIGN KEY (item_assinatura) REFERENCES item_assinatura (id_item_assinatura) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO meio_de_pagamento (meio_de_pagamento) VALUES ('CREDIT_CARD');
INSERT INTO meio_de_pagamento (meio_de_pagamento) VALUES ('PIX');
INSERT INTO meio_de_pagamento (meio_de_pagamento) VALUES ('DEBIT_CARD');

ALTER TABLE pagamento
    MODIFY COLUMN payment_method INT;


ALTER TABLE pagamento
    ADD FOREIGN KEY (payment_method) REFERENCES meio_de_pagamento (id_ordenador_pagamento);

ALTER TABLE assinatura
DROP COLUMN payment_method,
DROP COLUMN interval_count,
DROP COLUMN billing_type,
DROP COLUMN installments;

INSERT INTO item_assinatura (subscription_id, name_item_assinatura, description_item_assinatura, quantity, unit_price)
VALUES ('IouOne_Pagamento_Assinatura', 'Assinatura_Iouone', 'Unit', 1, 500.00);


ALTER TABLE assinatura DROP FOREIGN KEY assinatura_ibfk_1;

ALTER TABLE assinatura
    ADD FOREIGN KEY (item_assinatura) REFERENCES item_assinatura (id_item_assinatura);