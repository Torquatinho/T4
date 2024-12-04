USE Pokemon;

-- Inserir dados na tabela Treinador
INSERT INTO Treinador (nome, cidade, idade) VALUES
('Kiki', 'Pallet', 21),
('Henelo Bunior', 'Cerulean', 18),
('Tor4', 'Pewter', 19),
('Pipis', 'Vaniville', 17);

-- Inserir dados na tabela Pokemon
INSERT INTO pokemon (id, nome, tipagem_1, tipagem_2, hp, ataque, defesa, velocidade, ataque_especial, defesa_especial, habilidades, especie)
VALUES 
    (1, 'Pikachu', 'Elétrico', NULL, 35, 55, 40, 90, 50, 50, 'Static, Lightning Rod', 'Comum'),
    (2, 'Charizard', 'Fogo', 'Voador', 78, 84, 78, 100, 109, 85, 'Blaze, Solar Power', 'Comum'),
    (3, 'Bulbasaur', 'Grama', 'Venenoso', 45, 49, 49, 45, 65, 65, 'Overgrow, Chlorophyll', 'Comum'),
    (4, 'Mewtwo', 'Psíquico', NULL, 106, 110, 90, 130, 154, 90, 'Pressure, Unnerve', 'Lendário'),
    (5, 'Dragonite', 'Dragão', 'Voador', 91, 134, 95, 80, 100, 100, 'Inner Focus, Multiscale', 'Pseudo Lendário');

-- Inserir dados na tabela Equipe
INSERT INTO Equipe (id_treinador, nome) VALUES
(1, 'Equipe do Balacobaco'),
(2, 'Equipe Morbius'),
(3, 'Paysandu'),
(4, 'Clube de Regatas Flamengo');

-- Inserir dados na tabela Equipe_Pokemon
INSERT INTO Equipe_Pokemon (id_equipe, id_pokemon, posicao) VALUES
(1, 1, 1), -- Pikachu na posição 1 da equipe de Kiki
(2, 4, 1), -- Squirtle na posição 1 da equipe de Heleno
(2, 2, 2), -- Bulbasaur na posição 2 da equipe de Heleno
(3, 3, 1), -- Charmander na posição 1 da equipe de Tor4
(3, 5, 2), -- Butterfree na posição 2 da equipe de Tor4
(4, 6, 1); -- Pidgeotto na posição 1 da equipe de Pipis

-- Inserir dados na tabela Tipo (caso exista, para registro de tipos Pokémon)
INSERT INTO Tipo (nome) VALUES
('Elétrico'),
('Grama'),
('Fogo'),
('Água'),
('Inseto'),
('Normal'),
('Voador'),
('Venenoso');

-- Consultar as tabelas para verificar os dados
-- SELECT * FROM Treinador;
-- SELECT * FROM Pokemon;
-- SELECT * FROM Equipe;
-- SELECT * FROM Equipe_Pokemon;
-- SELECT * FROM Tipo;
