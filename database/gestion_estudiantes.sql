-- Creamos la base de datos solamente si todavía no existe.
CREATE DATABASE IF NOT EXISTS gestion_estudiantes;

-- Seleccionamos la base de datos sobre la cual vamos a trabajar.
USE gestion_estudiantes;

-- Creamos la tabla donde almacenaremos los estudiantes.
CREATE TABLE IF NOT EXISTS estudiantes (

    -- Creamos el identificador único del estudiante.
    id INT AUTO_INCREMENT PRIMARY KEY,

    -- Guardamos el número de documento.
    -- UNIQUE evita que dos estudiantes tengan el mismo documento.
    documento VARCHAR(20) NOT NULL UNIQUE,

    -- Guardamos el nombre del estudiante.
    nombre VARCHAR(100) NOT NULL,

    -- Guardamos el apellido del estudiante.
    apellido VARCHAR(100) NOT NULL,

    -- Guardamos el correo electrónico.
    correo VARCHAR(150) NOT NULL,

    -- Guardamos el programa académico.
    programa VARCHAR(150) NOT NULL,

    -- Guardamos el semestre actual.
    semestre INT NOT NULL,

    -- MySQL asignará automáticamente la fecha de creación del registro.
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);