-- Script de criação do banco
-- Autor. Wagner Yohan

--========== v.0.0.1
CREATE SEQUENCE "formcontact"."public"."contato_id_seq";

CREATE TABLE "formcontact"."public"."contato" (
                "id_contato" BIGINT NOT NULL DEFAULT nextval('"formcontact"."public"."contato_id_seq"'),
                "moeda" VARCHAR NOT NULL,
                "tipo" VARCHAR NOT NULL,
                "valor" INTEGER NOT NULL,
                "nome" VARCHAR NOT NULL,
                "email" VARCHAR NOT NULL,
                "telefone" VARCHAR NOT NULL,
                CONSTRAINT "id_contato" PRIMARY KEY ("id_contato")
);

ALTER SEQUENCE "formcontact"."public"."contato_id_seq" OWNED BY "formcontact"."public"."contato"."id_contato";