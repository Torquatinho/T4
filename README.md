Segue o a parte 1 do projeto de Banco de Dados de Pokemon, feito por Arthur Torquato:
Codigo SQL:[Uploading Codigo SQL Pokemon.txt…]()
USE POKEMON;
CREATE TABLE treinador (
id INT PRIMARY KEY,
nome VARCHAR(30) NOT NULL,
regiao VARCHAR(50) 
);

CREATE TABLE Pokemon (
id INT PRIMARY KEY,
nome VARCHAR(30) NOT NULL,
tipagem_1 VARCHAR(15) NOT NULL,
tipagem_2 VARCHAR(15),
hp INT NOT NULL,
ataque INT NOT NULL,
defesa INT NOT NULL,
ataque_especial INT NOT NULL,
defesa_especial INT NOT NULL,
velocidade INT NOT NULL,
habilidades TEXT NOT NULL,
especie ENUM('Comum', 'Lendário'),
peso FLOAT NOT NULL
);

CREATE TABLE equipe (
id INT PRIMARY KEY,
nome_equipe VARCHAR(50) NOT NULL,
id_treinador INT,
FOREIGN KEY (id_treinador) REFERENCES treinador(id)
);

CREATE TABLE equipe_pokemon (
    id_equipe INT,
    id_pokemon INT,
    posicao INT CHECK (posicao BETWEEN 1 AND 6),
    PRIMARY KEY (id_equipe, posicao),
    FOREIGN KEY (id_equipe) REFERENCES equipe(id),
    FOREIGN KEY (id_pokemon) REFERENCES pokemon(id)
);
Descrição do trabalho:
[Banco de dados Pkmn.pdf](https://github.com/user-attachments/files/17757187/Banco.de.dados.Pkmn.pdf)
[Tabelas pkmn.pdf](https://github.com/user-attachments/files/17757365/Tabelas.pkmn.pdf)

