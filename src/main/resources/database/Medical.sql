CREATE DATABASE Medical;
USE Medical;

CREATE TABLE pacientes (
    id INT AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    contacto BIGINT,
    pass VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO pacientes (nome, idade, contacto, pass) VALUES ('Marcos', 25, 912345678, '12345');
INSERT INTO pacientes (nome, idade, contacto, pass) VALUES ('Maria', 22, 912345678, '12345');

CREATE TABLE medicos (
    id INT AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    especialidade VARCHAR(255) NOT NULL,
    horario VARCHAR(255) NOT NULL,
    pass VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO medicos (nome, especialidade, horario, pass) VALUES ('Flavia', 'Cardiologista', '08:00-18:00', '12345');

CREATE TABLE consultas (
    paciente_id INT NOT NULL,
    medico_id INT NOT NULL,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    PRIMARY KEY (paciente_id, medico_id, data, hora),
    FOREIGN KEY (paciente_id) REFERENCES pacientes(id),
    FOREIGN KEY (medico_id) REFERENCES medicos(id)
);

INSERT INTO consultas (paciente_id, medico_id, data, hora, descricao, status)
VALUES (1, 1, '2021-01-01', '08:00:00', 'Consulta de Cardiologia', 'Realizada');

INSERT INTO consultas (paciente_id, medico_id, data, hora, descricao, status)
VALUES (2, 1, '2021-01-01', '09:00:00', 'Consulta de Cardiologia', 'Realizada');
