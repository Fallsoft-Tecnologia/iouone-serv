FROM mysql:8.0.26
COPY scripts/create_scripts.sql /docker-entrypoint-initdb.d/
COPY scripts-prd/scripts_inicial_plataforma_prd.sql /docker-entrypoint-initdb.d/
COPY scripts-prd/scripts_inicial_pagamento_prd.sql /docker-entrypoint-initdb.d/
COPY scripts-hml/scripts_inicial_plataforma_hml.sql /docker-entrypoint-initdb.d/
COPY scripts-hml/scripts_inicial_pagamento_hml.sql /docker-entrypoint-initdb.d/

