FROM mysql:8.0.26
COPY scripts/create_scripts.sql /docker-entrypoint-initdb.d/
COPY scripts/scripts_inicial_plataforma.sql /docker-entrypoint-initdb.d/
COPY scripts/scripts_inicial_pagamento.sql /docker-entrypoint-initdb.d/
