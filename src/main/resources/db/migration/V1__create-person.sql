-- CREATE TEXT SEARCH CONFIGURATION BUSCA (COPY = portuguese);
-- ALTER TEXT SEARCH CONFIGURATION BUSCA ALTER MAPPING FOR hword, hword_part, word WITH portuguese_stem;

CREATE TABLE IF NOT EXISTS PESSOAS (
    ID VARCHAR(36),
    APELIDO VARCHAR(100) CONSTRAINT ID_PK PRIMARY KEY NOT NULL,
    NOME VARCHAR(200) NOT NULL,
    NASCIMENTO DATE,
    STACK VARCHAR(1024)
--     TERMO TEXT GENERATED ALWAYS AS (
--     LOWER(NOME) || LOWER(APELIDO) || LOWER(STACK)
--     ) STORED
);

-- create extension if not exists pg_trgm;

-- create index if not exists idx_gin_persons_on_names on PESSOAS using gin (TERMO gin_trgm_ops)
-- create index if not exists idx_gin_persons_on_names on PESSOAS using gin (STACK gin_trgm_ops, APELIDO gin_trgm_ops, NOME gin_trgm_ops)

-- CREATE EXTENSION PG_TRGM;
--
-- CREATE INDEX CONCURRENTLY IF NOT EXISTS IDX_PESSOAS_BUSCA_TERMO ON PESSOAS USING GIST (TERMO GIST_TRGM_OPS);

-- CREATE INDEX idxid ON PESSOAS (ID);
-- CREATE INDEX idxnome ON PESSOAS (NOME);
-- CREATE INDEX idxapelido ON PESSOAS (APELIDO);
-- CREATE INDEX idxstack ON PESSOAS (STACK);