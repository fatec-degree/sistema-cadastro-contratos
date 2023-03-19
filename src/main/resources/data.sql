INSERT INTO addresses (id, zip_code, street, district, city, number)
VALUES (1, '12345-678', 'Rua dos Bobos', 'Bairro Feliz', 'São Paulo', '123');

INSERT INTO persons (id, address_id, name, rg, cpf, date_of_birth, main_contact, secondary_contact, email)
VALUES (1, 1, 'José Santos', '987654', '765432', '2000-03-03', '555555', '666666', 'jose.santos@yahoo.com');

INSERT INTO service_providers (id, representative_id, cnpj, corporate_name)
VALUES (1, 1, '12.345.678/0001-90', 'Empresa A');