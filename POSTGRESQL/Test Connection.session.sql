-- SIRVE PARA OBTENER TODOS LOS DATOS DE UNA TABLA
SELECT * FROM person;

-- PONER ALIAS
SELECT email AS e;

-- CREAR BASES DE DATOS
CREATE DATABASE foo;

-- ELIMINAR BASE DE DATOS
DROP TABLE foo;

-- CREAR TABLA
CREATE TABLE foo (
    id BIGSERIAL NOT NULL,          -- 'BIGSERIAL' HACE QUE EL VALOR SEA AUTOINCREMENTAL
    name VARCHAR(50) NOT NULL,      -- 'NOT NULL' HACE QUE EL CAMPO SEA OBLIGATORIO
    email VARCHAR(150)
);

-- ELIMINAR TABLAS
DROP TABLE foo;

-- 'ALTER TABLE'
-- MODIFICA VALORES DE LA TABLA
ALTER TABLE person 
ADD COLUMN some_column;
DROP COLUMN some_column;
RENAME COLUM some_column;

-- LIMITAR EL NUMERO DE RESULTADOS
-- A UN NUMERO ESPECIFICADO
SELECT * FROM person LIMIT 10;

-- SELECCIONA TODOS LOS CAMPOS
-- PERO SIN REPETIR VALORES IGUALES
SELECT DISTINCT coutry_of_birth FROM person;

-- 'WHERE'
-- SELECCIONA TODOS LOS CAMPOS
-- DEACUERDO A UNA ESPECIFICACION
SELECT * FROM person WHERE id > 5;

-- 'IN'
-- PARA CHECAR DISTINTOS VALORES
-- SIN PONER TANTO 'WHERE/AND'
SELECT * FROM person WHERE country_of_birth IN ('China', 'Mexico', 'France');

-- 'BETWEEN'
-- PARA SELECCIONAR DENTRO DE UN RANGO
SELECT * FROM person WHERE date_of_birth BETWEEN DATE '2022-01-01' AND '2023-01-01';

-- 'GROUP BY'
-- AGRUPA VALORES SIMILARES PARA PODER
-- HACER OPERACIONES CON LOS MISMOS DATOS
SELECT country_of_birth, COUNT(*) FROM person GROUP BY country_of_birth;

-- 'GROUP BY HAVING'
-- AGRUPA SI CIERTA CONDICION ES VERDADERA
SELECT country_of_birth, COUNT(*) FROM person GROUP BY country_of_birth HAVING COUNT(*) > 5;

-- 'LIKE' e 'ILIKE'
-- BUSCA DEACUERDO A PARAMETROS
SELECT * FROM person WHERE email LIKE '%@google%';
SELECT * FROM person WHERE email LIKE '_____d%@gmail%';      -- '_' ES PARA CONTAR ESPACIOS
SELECT * FROM person WHERE email ILIKE '%@google%';          -- 'ILIKE' FUNCIONA IGUAL, PERO IGNORA 'CASES'

-- AVG, MIN, MAX, COUNT
-- SON PARA OBTENER EL VALOR MINIMO O MAXIMO, MEDIA Y LA CANTIDAD DE UN CIERTO GRUPO
-- DE CIERTOS NUMEROS
SELECT model, make, MAX(price) FROM car GROUP BY model,make;

-- 'COALESCE'
-- ES UNA FUNCION QUE DA UN X NUMERO POR DEFECTO
-- SI EL PRIMERO, SEGUNDO... ES null, ENTONCES
-- SE PONDRA EL NUMERO POR DEFECTO
SELECT COALESCE(null, 1);                                   -- EN ESTE CASO, EL RESULTADO SERA: '1'
SELECT COALESCE(null, null, 1);                             -- EN ESTE CASO, EL RESULTADO SERA: '1'
SELECT id,first_name,last_name,gender,COALESCE(email,'NOT PROVIDED') AS email,date_of_birth,country_of_birth
FROM person;                                                -- EN ESTE CASO, AL NO VER EMAIL, SE MOSTRARA: 'NOT PROVIDED'

-- 'NULLIF'
-- FUNCION QUE REGRESA 'null'
-- SI EL PRIMER PARAMETRO ES IGUAL AL SEGUNDO
SELECT 10 / NULLIF(2,9);                                    -- 'NULLIF' RETORNA 2, PUES EL SEGUNDO NUMERO NO ES IGUAL AL PRIMERO
SELECT COALESCE(10 / NULLIF(0,0), 1);                       -- COMO EL RESULTADO ES NULL, COALESCE DA UN NUMERO POR DEFECTO