CREATE DATABASE IF NOT EXISTS iouone_hml;
CREATE DATABASE IF NOT EXISTS iouone_pagamento_hml;

GRANT ALL PRIVILEGES ON iouone_hml.* TO 'iouone'@'%';
GRANT ALL PRIVILEGES ON iouone_pagamento_hml.* TO 'iouone'@'%';

FLUSH PRIVILEGES;