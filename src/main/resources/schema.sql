CREATE DATABASE IF NOT EXISTS contracts_db;

CREATE TABLE IF NOT EXISTS addresses
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    zip_code VARCHAR(10),
    street   VARCHAR(200),
    district VARCHAR(200),
    city     VARCHAR(200),
    number   VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS persons
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    address_id        BIGINT,
    name              VARCHAR(200),
    rg                VARCHAR(15),
    cpf               VARCHAR(15),
    date_of_birth     DATE,
    main_contact      VARCHAR(15),
    secondary_contact VARCHAR(15),
    email             VARCHAR(200) UNIQUE,

    FOREIGN KEY (address_id) REFERENCES addresses (id)
);

CREATE TABLE IF NOT EXISTS schools
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    address_id BIGINT,
    name       VARCHAR(200),

    FOREIGN KEY (address_id) REFERENCES addresses (id)
);


CREATE TABLE IF NOT EXISTS schedules
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    school_id BIGINT,
    entry     TIME,
    departure TIME,

    FOREIGN KEY (school_id) REFERENCES schools (id)
);

CREATE TABLE IF NOT EXISTS health_conditions
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    sickness  VARCHAR(500),
    allergies VARCHAR(500),
    medicines VARCHAR(500),
    remarks   VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS responsibles
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    address_id        BIGINT,
    name              VARCHAR(200),
    rg                VARCHAR(15),
    cpf               VARCHAR(15),
    date_of_birth     DATE,
    main_contact      VARCHAR(15),
    secondary_contact VARCHAR(15),
    email             VARCHAR(200) UNIQUE,
    remarks           VARCHAR(500),

    FOREIGN KEY (address_id) REFERENCES addresses (id)
);

CREATE TABLE IF NOT EXISTS service_providers
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    representative_id BIGINT,
    cnpj              VARCHAR(20) UNIQUE,
    corporate_name    VARCHAR(200),

    FOREIGN KEY (representative_id) REFERENCES persons (id)
);

CREATE TABLE IF NOT EXISTS students
(
    id                  BIGINT PRIMARY KEY AUTO_INCREMENT,
    responsible_id      BIGINT,
    schedule_id         BIGINT,
    health_condition_id BIGINT,
    address_id          BIGINT,
    name                VARCHAR(200),
    rg                  VARCHAR(15),
    cpf                 VARCHAR(15),
    date_of_birth       DATE,
    main_contact        VARCHAR(15),
    secondary_contact   VARCHAR(15),
    email               VARCHAR(200) UNIQUE,

    FOREIGN KEY (schedule_id) REFERENCES schedules (id),
    FOREIGN KEY (health_condition_id) REFERENCES health_conditions (id),
    FOREIGN KEY (address_id) REFERENCES addresses (id),
    FOREIGN KEY (responsible_id) REFERENCES responsibles (id)
);

CREATE TABLE IF NOT EXISTS contracts
(
    id                  BIGINT PRIMARY KEY AUTO_INCREMENT,
    service_provider_id BIGINT,
    responsible_id      BIGINT,
    student_id          BIGINT,
    amount              REAL,
    year                INTEGER,
    start               DATE,
    end                 DATE,
    expired             BOOLEAN,

    FOREIGN KEY (service_provider_id) REFERENCES service_providers (id),
    FOREIGN KEY (responsible_id) REFERENCES responsibles (id),
    FOREIGN KEY (student_id) REFERENCES students (id)
);
