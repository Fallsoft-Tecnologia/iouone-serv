CREATE DATABASE IF NOT EXISTS iouone_hml;
CREATE DATABASE IF NOT EXISTS iouone_pagamento_hml;
CREATE DATABASE IF NOT EXISTS iouone_prd;
CREATE DATABASE IF NOT EXISTS iouone_pagamento_prd;


GRANT ALL PRIVILEGES ON iouone_hml.* TO 'iouone'@'%';
GRANT ALL PRIVILEGES ON iouone_pagamento_hml.* TO 'iouone'@'%';
GRANT ALL PRIVILEGES ON iouone_prd.* TO 'iouone'@'%';
GRANT ALL PRIVILEGES ON iouone_pagamento_prd.* TO 'iouone'@'%';

FLUSH PRIVILEGES;