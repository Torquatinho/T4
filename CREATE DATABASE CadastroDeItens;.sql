CREATE DATABASE CadastroDeItens;

USE CadastroDeItens;

DROP TABLE Item;

SHOW TABLES;

CREATE TABLE Item(
    CodigoItem INT AUTO_INCREMENT,
    TipoItem VARCHAR(255),
    DescricaoItem VARCHAR(255),
    PesoItem DECIMAL(5,2),
    QuantidadeItem INT,
    UnidadeMedidaItem VARCHAR(255),
    PRIMARY KEY (CodigoItem)
);

SHOW TABLES;

SELECT * FROM Item;
