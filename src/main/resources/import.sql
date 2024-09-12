DROP TABLE IF EXISTS Email;
-- DROP SEQUENCE IF EXISTS Email_SEQ;
DROP TABLE IF EXISTS Cliente;
-- DROP SEQUENCE IF EXISTS Cliente_SEQ;

-- CREATE SEQUENCE Email_SEQ START WITH 1 INCREMENT BY 1;
-- CREATE SEQUENCE Cliente_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE Email (
    ID BIGINT PRIMARY KEY,-- DEFAULT NEXTVAL('Email_SEQ'),
    ID_DES BIGINT NOT NULL,
    ID_REM BIGINT NOT NULL,
    CORPO VARCHAR(500),
    TITULO VARCHAR(50),
    DT_CRI DATE NOT NULL
);

CREATE TABLE Cliente (
    ID BIGINT PRIMARY KEY,-- DEFAULT NEXTVAL('Usuario_SEQ'),
    USERNAME VARCHAR(50) NOT NULL UNIQUE,
    SENHA VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    DT_NSC DATE
);

INSERT INTO Email (ID, ID_DES, ID_REM, CORPO, TITULO, DT_CRI) VALUES 
(1, 1, 2, 'Este é um corpo de e-mail fictício para testar a tabela. Inclui informações aleatórias para verificar o funcionamento.', 'Título do Primeiro E-mail', '2024-09-01'),
(2, 2, 3, 'Outro corpo de e-mail fictício. Os dados são apenas para fins de teste e não têm relevância real.', 'Título do Segundo E-mail', '2024-09-02'),
(3, 3, 1, 'Mais um e-mail fictício. O corpo do e-mail contém texto aleatório para preencher a tabela.', 'Título do Terceiro E-mail', '2024-09-03'),
(4, 4, 2, 'Texto aleatório para o corpo do e-mail. Serve apenas para criar alguns dados de teste.', 'Título do Quarto E-mail', '2024-09-04'),
(5, 5, 3, 'Este e-mail fictício possui um corpo de texto aleatório para validar a inserção na tabela.', 'Título do Quinto E-mail', '2024-09-05');

INSERT INTO Cliente (ID, USERNAME, SENHA, EMAIL, DT_NSC) VALUES 
(1, 'cliente1', 'senha1', 'cliente1@email.com', '1990-01-01'),
(2, 'cliente2', 'senha2', 'cliente2@email.com', '1985-05-15'),
(3, 'cliente3', 'senha3', 'cliente3@email.com', '1995-09-10');