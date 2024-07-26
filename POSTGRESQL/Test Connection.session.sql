-- SIRVE PARA OBTENER TODOS LOS DATOS DE UNA TABLA
SELECT * FROM person;

-- 'AS'
-- PONER ALIAS
SELECT email AS e;

-- 'CREATE DATABASE'
-- CREAR BASES DE DATOS
CREATE DATABASE foo;

-- 'DROP TABLE'
-- ELIMINAR BASE DE DATOS
DROP TABLE foo;

-- 'CREATE TABLE'
-- CREAR TABLA
CREATE TABLE foo (
    id BIGSERIAL NOT NULL,          -- 'BIGSERIAL' HACE QUE EL VALOR SEA AUTOINCREMENTAL
    name VARCHAR(50) NOT NULL,      -- 'NOT NULL' HACE QUE EL CAMPO SEA OBLIGATORIO
    email VARCHAR(150)
);

-- 'DROP TABLES'
-- ELIMINAR TABLAS
DROP TABLE foo;

-- 'ALTER TABLE'
-- MODIFICA VALORES DE LA TABLA
ALTER TABLE person 
ADD COLUMN some_column;
DROP COLUMN some_column;
RENAME COLUM some_column;

-- 'DELETE'
-- ELIMINA UNA COLUMNA CON DATOS
-- DEACUERDO A CIERTOS PARAMETROS
DELETE FROM person WHERE id=1;

-- 'LIMIT'
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

-- 'NOW'
-- FUNCION PARA MOSTRAR LA FECHA Y HORA ACTUAL DEL SERVIDOR
SELECT NOW()                                                -- MOSTRARA FECHA Y HORA
SELECT NOW::DATE;                                           -- MOSTRARA SOLO LA FECHA
SELECT NOW()::TIME;                                         -- MOSTRARA SOLO LA HORA

-- 'INTERVAL'
-- SIRVE PARA SUSTRAER O AÑADIR
-- A UN DATO DE TIPO FECHA
SELECT NOW() - INTERVAL '1 YEAR';
SELECT NOW() + INTERVAL '10 MONTHS';
SELECT NOW() - INTERVAL '10 DAYS';

SELECT (NOW() + INTERVAL '2 YEARS)')::DATE;

-- 'EXTRACT'
-- SIRVE PARA EXTRAER VALORES ESPECIFICADOS COMO PRIMER PARAMETRO
SELECT EXTRACT( YEAR FROM NOW() );
SELECT EXTRACT( MONTH FROM NOW() );
SELECT EXTRACT( DAY FROM NOW() );
SELECT EXTRACT( DOW FROM NOW() );
SELECT EXTRACT( CENTURY FROM NOW() );

-- 'AGE'
-- FUNCION QUE TOMA DOS DATE: TIEMPO ACTUAL Y TIEMPO DE NACIMIENTO
-- REGRESA: AÑO, MES, DIA Y TIEMPO (LA EDAD)
SELECT 
	first_name,
	last_name, gender,
	country_of_birth,
	date_of_birth,
	AGE( NOW(), date_of_birth )                               -- <-- AQUI
AS age  
FROM person;

-- 'ELIMINAR Y AÑADIR LLAVE PRIMARIA DE VALOR YA CREADO'
ALTER TABLE person DROP CONSTRAINT person_pkey;					-- ELIMINAR
ALTER TABLE person ADD PRIMARY KEY (id);						-- AÑADIR

-- 'UNIQUE'
-- PARA AÑADIR CONSTRAINT UNIQUE A UN CAMPO
ALTER TABLE person ADD CONSTRAINT unique_email_address UNIQUE (email);	-- HACE QUE EL 'email' NO PUEDA SER REPETIDO

-- 'CHECK'
-- SIRVE PARA PONER CONSTRAINTS
-- Y PONER RESTRICCIONES
ALTER TABLE person ADD CONSTRAINT gender_constraint CHECK(gender = 'Female' OR gender = 'Male');	-- SE ESPECIFICA QUE 'gender' SOLO PUEDE SER 'Male' o 'Female'

-- 'UPDATE'
-- ACTUALIZA LOS VALORES DE UNA ENTRADA
UPDATE person SET email='andrecked507@gmail.com@answers.com' WHERE id=1;

-- 'ON CONFLICT () DO {SOMETHING}'
-- EN CASO DE CONFLICTO HAZ 'XYZ'
INSERT INTO person(id,first_name,last_name,gender,email,date_of_birth,country_of_birth)
VALUES(5,'Lorem','Ipsum','Male','something@gmail.com',DATE '2021-06-01','France')			-- 		EN ESTE CASO, EL ID ESTA REPETIDO
ON CONFLICT(id) DO NOTHING;																	-- <-- 	POR LO QUE NO SE HARA NADA

-- 'DO UPDATE SET'
-- EN CASO DE CONFLICTO, SE LE DICE QUE ACTUALICE AQUEL(AQUELLOS)
-- CAMPOS QUE TENGAN CONFLICTO CON NUEVA INFORMACION
INSERT INTO person (id, first_name, last_name, gender, email, date_of_birth, country_of_birth)
VALUES (5,'Kilian', 'Lorking', 'Male', 'something@zdnet.com', DATE '2022-12-02', 'United States')
ON CONFLICT (id) DO UPDATE SET email=EXCLUDED.email;										-- EN CONFLICTO, CAMBIA EL EMAIL

-- 'FOREIGN KEY'
-- AÑADIMOS LLAVES FORANEAS PARA RELACIONAR TABLAS
CREATE TABLE person(
	id BIGSERIAL NOT NULL PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	gender VARCHAR(7) NOT NULL,
	email VARCHAR(100),
	date_of_birth DATE NOT NULL,
	country_of_birth VARCHAR(50) NOT NULL,
	car_id BIGINT REFERENCES car (id) UNIQUE 												-- <-- UNA PERSONA TIENE CERO O MAS DE UN AUTO
);

-- 'UPDATE'
-- ACTUALIZA INFORMACION DE CAMPOS EN ESPECIFICO
UPDATE person SET car_id=1 WHERE id=2;

-- 'INNER JOINS'
-- COMBINA TABLAS QUE CUMPLAN LOS REQUISITSO
SELECT first_name, car.make FROM person
JOIN car ON person.car_id = car.id;

-- 'LEFT JOINS'
-- COMBINA CUALQUIER TABLA
-- CUMPLA LOS REQUISITOS O NO
SELECT first_name, car.make FROM person
LEFT JOIN car ON person.car_id = car.id;

-- DELETE RECORDS WITH FOREIGN KEYS
-- { UPDATE person.car_id TO NULL, AND THEN DELETE THE FOREIGN KEY TABLE COLUMN (OR YOU CAN UPDATE THE person.fkey TO OTHER CAR OR null) }

-- EXPORT TO CSV
\copy ( SELECT * FROM person ) TO '{ RUTA DONDE GUARDAR }' DELIMITER ',' CSV HEADER;

-- 'RESTART WITH'
-- "RESETEAR" LA SECUENCIA (USUALMENTE USADA PARA IDENTIFICADORES)
-- A UN NUMERO EN ESPECIFICO
ALTER SEQUENCE person_id_seq RESTART WITH 10;

-- 'INSTALL EXTENSION'
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- 'CALL FUNCTIONS'
SELECT uuid_generate_v4();

-- BIGSERIAL y SEQUENCES
-- Esto muestra la secuencia actual del 'ID'
SELECT * FROM person_id_seq;
-- El llamar a esta funcion hace que el 'ID' avance +1
SELECT nextval('person_id_seq'::regclass);