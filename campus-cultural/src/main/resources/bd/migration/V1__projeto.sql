-- Create ulid functions -------------------------------------------------

CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE OR REPLACE FUNCTION ulid() RETURNS uuid
    AS $$
SELECT (lpad(to_hex(floor(extract(epoch FROM clock_timestamp()) * 1000)::bigint), 12, '0') || encode(gen_random_bytes(10), 'hex'))::uuid;
$$ LANGUAGE SQL;
;

-- Create tables section -------------------------------------------------

-- Table usuario

CREATE TABLE "usuario"
(
 	"id_usuario" UUID NOT NULL,
  	"ds_nome" Character varying(50) NOT NULL,
  	"ds_sobrenome" Character varying(50) NOT NULL,
  	"ds_email" Character varying(50) NOT NULL,
  	"senha" Character varying(50) NOT NULL,
  	"tp_usuario" Integer NOT NULL,
  	"ds_imagem" Text NOT NULL,
  	"ds_usuario" Character varying(50) NOT NULL
)
WITH (
  autovacuum_enabled=true)
;

ALTER TABLE "usuario" ADD CONSTRAINT "pk_usuario" PRIMARY KEY ("id_usuario")
;

-- Table evento

CREATE TABLE "evento"
(
  	"id_evento" UUID NOT NULL,
	"id_usuario" UUID NOT NULL,
	"ds_titulo" Character varying(80) NOT NULL,
	"ds_imagem" Text NOT NULL,
	"sn_publicado" Integer NOT NULL,
	"dt_evento" Date NOT NULL
)
WITH (
  autovacuum_enabled=true)
;

ALTER TABLE "evento" ADD CONSTRAINT "pk_evento" PRIMARY KEY ("id_evento")
;

-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE "evento"
  ADD CONSTRAINT "rel_usuario_evento"
    FOREIGN KEY ("id_usuario")
    REFERENCES "usuario" ("id_usuario")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;