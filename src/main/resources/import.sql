DROP TABLE IF EXISTS Email;
DROP SEQUENCE IF EXISTS EMAIL_SEQ;
DROP TABLE IF EXISTS Cliente;
DROP SEQUENCE IF EXISTS CLIENTE_SEQ;

CREATE SEQUENCE IF NOT EXISTS EMAIL_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS CLIENTE_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE Email (
    ID BIGINT PRIMARY KEY AUTO_INCREMENT , -- DEFAULT (NEXT VALUE FOR EMAIL_SEQ),
    ID_DES BIGINT NOT NULL,
    ID_REM BIGINT NOT NULL,
    CORPO VARCHAR(500),
    TITULO VARCHAR(50),
    DT_CRI DATE NOT NULL,
    FAVORITO BOOLEAN DEFAULT FALSE
);

CREATE TABLE Cliente (
    ID BIGINT PRIMARY KEY AUTO_INCREMENT, -- DEFAULT (NEXT VALUE FOR CLIENTE_SEQ),
    USERNAME VARCHAR(50) NOT NULL UNIQUE,
    SENHA VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    DT_CRI DATE NOT NULL,
    PAPEL VARCHAR(3) NOT NULL,
    TEMA VARCHAR(6) NOT NULL
);

INSERT INTO Email (ID_DES, ID_REM, CORPO, TITULO, DT_CRI, FAVORITO) VALUES 
(1, 2, 'Este é um corpo de e-mail fictício para testar a tabela. Inclui informações aleatórias para verificar o funcionamento.', 'Título do Primeiro E-mail', '2024-09-01', FALSE),
(2, 3, 'Outro corpo de e-mail fictício. Os dados são apenas para fins de teste e não têm relevância real.', 'Título do Segundo E-mail', '2024-09-02', FALSE),
(3, 1, 'Mais um e-mail fictício. O corpo do e-mail contém texto aleatório para preencher a tabela.', 'Título do Terceiro E-mail', '2024-09-03', FALSE),
(4, 2, 'Texto aleatório para o corpo do e-mail. Serve apenas para criar alguns dados de teste.', 'Título do Quarto E-mail', '2024-09-04', FALSE),
(5, 3, 'Este e-mail fictício possui um corpo de texto aleatório para validar a inserção na tabela.', 'Título do Quinto E-mail', '2024-09-05', FALSE);

INSERT INTO Cliente (USERNAME, SENHA, EMAIL, DT_CRI, PAPEL, TEMA) VALUES 
('cliente1', 'senha1', 'cliente1@email.com', '2024-01-01', 'ADM', 'CLARO'),
('cliente2', 'senha2', 'cliente2@email.com', '2024-05-15', 'USR', 'ESCURO'),
('cliente3', 'senha3', 'cliente3@email.com', '2024-09-10', 'USR', 'CLARO');
