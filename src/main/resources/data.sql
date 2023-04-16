INSERT INTO addresses (zip_code, street, district, city, number, state)
VALUES
    ('12345678', 'Rua das Flores', 'Centro', 'Sao Paulo', '123', 'Sao Paulo'),
    ('54321876', 'Avenida dos Bandeirantes', 'Vila Mariana', 'Sao Paulo', '456', 'Sao Paulo'),
    ('98765432', 'Rua do Bosque', 'Alto da Lapa', 'Sao Paulo', '789', 'Sao Paulo'),
    ('01234567', 'Avenida Paulista', 'Bela Vista', 'Sao Paulo', '1010', 'Sao Paulo'),
    ('45678901', 'Rua Oscar Freire', 'Jardim Paulista', 'Sao Paulo', '222', 'Sao Paulo'),
    ('23456789', 'Avenida Brasil', 'Jardim America', 'Sao Paulo', '333', 'Sao Paulo'),
    ('89012345', 'Rua Augusta', 'Consolacao', 'Sao Paulo', '444', 'Sao Paulo'),
    ('67890123', 'Avenida Faria Lima', 'Itaim Bibi', 'Sao Paulo', '555', 'Sao Paulo'),
    ('34567890', 'Rua dos Pinheiros', 'Pinheiros', 'Sao Paulo', '666', 'Sao Paulo'),
    ('90123456', 'Rua do Ouvidor', 'Sao Bento', 'Rio de Janeiro', '123', 'Sao Paulo'),
    ('76543210', 'Avenida Atlântica', 'Copacabana', 'Rio de Janeiro', '456', 'Sao Paulo'),
    ('32109876', 'Rua das Laranjeiras', 'Laranjeiras', 'Rio de Janeiro', '789', 'Sao Paulo'),
    ('65432109', 'Rua Nossa Senhora de Copacabana', 'Copacabana', 'Rio de Janeiro', '1010', 'Sao Paulo'),
    ('09876543', 'Avenida Presidente Vargas', 'Centro', 'Rio de Janeiro', '1111', 'Sao Paulo'),
    ('43210987', 'Rua Barao de Mesquita', 'Tijuca', 'Rio de Janeiro', '2222', 'Sao Paulo'),
    ('78901234', 'Rua da Praia', 'Jardim Oceânico', 'Rio de Janeiro', '3333', 'Sao Paulo'),
    ('56789012', 'Avenida Brasil Central', 'Centro', 'Goiânia', '123', 'Sao Paulo'),
    ('21098765', 'Rua Padre Rolim', 'Savassi', 'Belo Horizonte', '456', 'Sao Paulo'),
    ('54321098', 'Rua Padre Eustaquio', 'Padre Eustaquio', 'Belo Horizonte', '789', 'Sao Paulo'),
    ('45678123', 'Avenida Afonso Pena', 'Centro', 'Belo Horizonte', '1010', 'Sao Paulo'),
    ('98765210', 'Rua dos Aimores', 'Lourdes', 'Belo Horizonte', '1111', 'Sao Paulo'),
    ('01234567', 'Avenida das Americas', 'Barra da Tijuca', 'Rio de Janeiro', '2222', 'Sao Paulo'),
    ('76543210', 'Rua Oscar Niemeyer', 'Jardim Botânico', 'Rio de Janeiro', '3333', 'Sao Paulo'),
    ('45678901', 'Rua dos Inconfidentes', 'Savassi', 'Belo Horizonte', '4444', 'Sao Paulo'),
    ('23456789', 'Avenida Sete de Setembro', 'Centro', 'Curitiba', '123', 'Sao Paulo');

INSERT INTO schools (address_id, name)
VALUES
    (1, 'Escola Municipal Sao Paulo'),
    (2, 'Escola Estadual Rio de Janeiro'),
    (3, 'Escola Particular Brasilia'),
    (4, 'Escola Tecnica de Minas Gerais'),
    (5, 'Colegio Santa Catarina');

INSERT INTO schedules (school_id, entry, departure)
VALUES
    (1, '08:00:00', '14:00:00'),
    (1, '13:00:00', '18:00:00'),
    (1, '07:30:00', '13:30:00'),
    (2, '07:30:00', '12:30:00'),
    (2, '12:00:00', '17:00:00'),
    (2, '08:00:00', '14:00:00'),
    (3, '07:00:00', '12:00:00'),
    (3, '12:30:00', '17:30:00'),
    (3, '07:30:00', '12:30:00'),
    (4, '07:00:00', '12:00:00'),
    (4, '12:30:00', '17:30:00'),
    (4, '07:30:00', '12:30:00'),
    (5, '08:00:00', '13:00:00'),
    (5, '12:30:00', '17:30:00'),
    (5, '07:30:00', '12:30:00');

INSERT INTO health_conditions (sickness, allergies, medicines, remarks)
VALUES
    ('Asma', 'Polen', 'Inalador', 'Faz uso de inalador diariamente'),
    ('Gripe', 'Nenhum', 'Antibioticos', 'Recomendacao de repouso absoluto'),
    ('Diabetes', 'Lactose', 'Insulina', 'Precisa monitorar a glicemia constantemente'),
    ('Dor de cabeca', 'Nenhum', 'Analgesicos', 'Evitar exposicao prolongada a telas'),
    ('Enxaqueca', 'Luzes fortes', 'Triptanos', 'E importante manter uma rotina de sono'),
    ('Ansiedade', 'Nenhum', 'Ansioliticos', 'Recomendacao de terapia comportamental'),
    ('Hipertensao', 'Nenhum', 'Betabloqueadores', 'Recomendacao de reducao do consumo de sal'),
    ('Depressao', 'Nenhum', 'Antidepressivos', 'Recomendacao de terapia psicologica'),
    ('Alergia alimentar', 'Frutos do mar', 'Epinefrina', 'Evitar consumo de frutos do mar'),
    ('Hipercolesterolemia', 'Nenhum', 'Estatinas', 'Recomendacao de reducao do consumo de gorduras'),
    ('Artrite', 'Nenhum', 'Analgesicos', 'Recomendacao de pratica de exercicios fisicos leves'),
    ('Labirintite', 'Nenhum', 'Betahistina', 'Recomendacao de evitar movimentos bruscos'),
    ('Insonia', 'Nenhum', 'Hipnoticos', 'Recomendacao de manter rotina de sono'),
    ('Problemas de visao', 'Nenhum', 'Oculos', 'Recomendacao de fazer exame oftalmologico anualmente'),
    ('Problemas de audicao', 'Nenhum', 'Aparelho auditivo', 'Recomendacao de fazer exame de audiometria anualmente');

INSERT INTO responsibles (address_id, name, rg, cpf, date_of_birth, main_contact, secondary_contact, email, emergency_contact, relationship, remarks)
VALUES
    (6, 'Luciana Santos', '123456789', '987654321', '1985-10-01', '11987654321', '11987654322', 'luciana.santoss@example.com', '', 'Mae', ''),
    (6, 'Ricardo Oliveira', '987654321', '123456789', '1978-05-14', '11987654323', '11987654324', 'ricardo.oliveira@example.com', '', 'Pai', ''),
    (6, 'Fernanda Pereira', '654321789', '123456987', '1990-09-22', '11987654325', '11987654326', 'fernanda.pereira@example.com', '','Mae', ''),
    (7, 'Roberto Silva', '456789321', '987654123', '1982-02-17', '11987654327', '11987654328', 'roberto.silva@example.com', '', 'Pai', ''),
    (8, 'Maria Costa', '159753846', '654789321', '1975-12-30', '11987654329', '11987654330', 'maria.costa@example.com', '', 'Mae', ''),
    (9, 'Fabio Souza', '753159852', '951753684', '1987-06-05', '11987654331', '11987654332', 'fabio.souza@example.com', '', 'Pai', ''),
    (10, 'Carla Santos', '159753684', '753159852', '1980-03-20', '11987654333', '11987654334', 'carla.santos@example.com', '', 'Avo', ''),
    (11, 'Marcos Ferreira', '456789123', '987654456', '1973-11-11', '11987654335', '11987654336', 'marcos.ferreira@example.com', '', 'Pai', ''),
    (12, 'Aline Silva', '789456321', '321654987', '1995-07-02', '11987654337', '11987654338', 'aline.silva@example.com', '', 'Mae', ''),
    (13, 'Lucas Almeida', '123456789', '987654321', '1992-03-10', '11987654339', '11987654340', 'lucas.almeida@example.com', '', 'Pai', ''),
    (14, 'Gabriela Lima', '987654321', '123456789', '1989-11-25', '11987654341', '11987654342', 'gabriela.lima@example.com', '', 'Mae', ''),
    (15, 'Luiz Fernando', '753951846', '159753864', '1984-08-15', '11987654343', '11987654344', 'luiz.fernando@example.com', '', 'Avô', ''),
    (16, 'Isabela Oliveira', '456789123', '987654456', '1998-06-21', '11987654345', '11987654346', 'isabela.oliveira@example.com', '', 'Mae', '');

INSERT INTO students (responsible_id, schedule_id, health_condition_id, address_id, name, rg, cpf, date_of_birth, main_contact, secondary_contact, email)
VALUES
    (1, 1, 1, 6, 'Joao Silva', '123456789', '12345678901', '2009-02-15', '999999999', '888888888', 'joao.silva@gmail.com'),
    (1, 2, 2, 6, 'Maria Santos', '987654321', '98765432109', '2011-08-23', '777777777', '666666666', 'maria.santos@hotmail.com'),
    (1, 3, 3, 6, 'Pedro Souza', '456789123', '45678912345', '2010-05-10', '555555555', '444444444', 'pedro.souza@yahoo.com'),
    (2, 4, 4, 7, 'Ana Oliveira', '789456123', '78945612301', '2012-11-05', '333333333', '222222222', 'ana.oliveira@gmail.com'),
    (3, 5, 5, 8, 'Lucas Costa', '654987321', '65498732109', '2008-07-12', '111111111', '000000000', 'lucas.costa@hotmail.com'),
    (4, 6, 6, 9, 'Amanda Almeida', '321654987', '32165498709', '2011-03-29', '999999111', '888888000', 'amanda.almeida@yahoo.com'),
    (5, 7, 7, 10, 'Gabriel Pereira', '159357246', '15935724601', '2009-06-18', '777777111', '666666000', 'gabriel.pereira@gmail.com'),
    (6, 8, 8, 11, 'Julia Santos', '753951468', '75395146809', '2010-09-03', '555555111', '444444000', 'julia.santos@hotmail.com'),
    (7, 9, 9, 12, 'Rafael Lima', '147852369', '14785236901', '2012-01-22', '333333111', '222222000', 'rafael.lima@yahoo.com'),
    (8, 10, 10, 13, 'Bruna Castro', '369852147', '36985214709', '2008-04-07', '111111222', '000000111', 'bruna.castro@gmail.com'),
    (9, 11, 11, 14, 'Thiago Rodrigues', '258369147', '25836914701', '2011-12-16', '999999222', '888888111', 'thiago.rodrigues@hotmail.com'),
    (10, 12, 12, 15, 'Fernanda Silva', '147852369', '14785236909', '2010-02-25', '777777222', '666666111', 'fernanda.silva@yahoo.com'),
    (11, 13, 13, 16, 'Gustavo Oliveira', '753951468', '75395146801', '2009-11-01', '555555222', '444444111', 'gustavo.oliveira@gmail.com'),
    (12, 14, 14, 17, 'Juliana Silva', '123456789', '987654321', '2008-12-06', '1198765-4321', '1198765-4322', 'juliana.silva@example.com'),
    (13, 15, 15, 18, 'Marcos Oliveira', '987654321', '123456789', '2007-03-15', '1198765-4323', '1198765-4324', 'marcos.oliveira@example.com');

INSERT INTO persons (id, address_id, name, rg, cpf, date_of_birth, main_contact, secondary_contact, email)
VALUES (1, 1, 'Jose Santos', '987654', '765432', '2000-03-03', '555555', '666666', 'jose.santos@yahoo.com');

INSERT INTO service_providers (id, representative_id, cnpj, corporate_name)
VALUES (1, 1, '12345678000190', 'Empresa A');

INSERT INTO contracts (service_provider_id, responsible_id, student_id, amount, first_parcel, collection_day, number_of_parcels, parcel_value, year, start, end, expired, file_data, status, uuid) VALUES
    (1, 1, 1, 1000.00, '2023-01-20', 20, 12, 83.35, 2023, '2022-12-20', '2023-12-20', FALSE, null, 'ATIVO', null),
    (1, 1, 2, 1500.00, '2023-01-21', 20, 12, 125.0, 2023, '2022-12-21', '2023-12-21', FALSE, null, 'ATIVO', null),
    (1, 1, 3, 2000.00, '2023-01-22', 5, 12, 166.70, 2023, '2022-12-22', '2023-12-22', FALSE, null, 'ATIVO', null),
    (1, 2, 4, 2500.00, '2023-01-23', 20, 12, 208.35, 2023, '2022-12-23', '2023-12-23', FALSE, null, 'ATIVO', null),
    (1, 3, 5, 3000.00, '2023-01-24', 20, 12, 250.0, 2023, '2022-12-24', '2023-12-24', FALSE, null, 'ATIVO', null),
    (1, 4, 6, 3500.00, '2023-01-25', 5, 12, 291.70, 2023, '2022-12-25', '2023-12-25', FALSE, null, 'CANCELADO', null),
    (1, 5, 7, 4000.00, '2023-01-26', 20, 12, 333.35, 2023, '2022-12-26', '2023-12-26', FALSE, null, 'AGUARDANDO_ASSINATURAS', null),
    (1, 6, 8, 4500.00, '2023-01-27', 20, 12, 375.0, 2023, '2022-12-27', '2023-12-27', FALSE, null, 'AGUARDANDO_ASSINATURAS', null),
    (1, 7, 9, 5000.00, '2023-01-28', 5, 12, 416.70, 2023, '2022-12-28', '2023-12-28', FALSE, null, 'CANCELADO', null),
    (1, 8, 10, 5500.00, '2023-01-29', 5, 12, 458.35, 2023, '2022-12-29', '2023-12-29', FALSE, null, 'AGUARDANDO_ASSINATURAS', null),
    (1, 9, 11, 6000.00, '2023-01-30', 5, 12, 500.0, 2023, '2022-12-30', '2023-12-30', FALSE, null, 'CANCELADO', null),
    (1, 10, 12, 5500.00, '2023-01-20', 5, 12, 458.35, 2023, '2022-12-29', '2023-12-29', FALSE, null, 'CANCELADO', null),
    (1, 11, 13, 5500.00, '2023-01-29', 20, 12, 458.35, 2023, '2022-01-01', '2023-01-01', FALSE, null, 'EXPIRADO', null),
    (1, 12, 14, 5500.00, '2023-01-29', 20, 12, 458.35, 2023, '2022-12-29', '2023-12-29', FALSE, null, 'ATIVO', null),
    (1, 13, 15, 5500.00, '2023-01-29', 20, 12, 458.35, 2023, '2022-12-29', '2023-12-29', FALSE, null, 'AGUARDANDO_ASSINATURAS', null);
