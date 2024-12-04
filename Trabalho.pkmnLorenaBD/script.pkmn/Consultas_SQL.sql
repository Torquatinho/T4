--Exemplo de Consultas comuns:
--Listar todos os pokemons de um time específico:
SELECT p.nome, p.tipagem_1, p.tipagem_2
FROM pokemon p
JOIN  equipe_pokemon tp ON P.id = id_pokemon
WHERE tp.id_equipe = 1;

--Consultar o treinador e os times que ele possui:
SELECT p.nome_equipe
FROM equipe t
JOIN treinador tr ON t.id_treinador = tr.id
WHERE tr.nome = 'Henelo Bunior';

--Buscar Pokémons de uma espécie específica em todos os times:
SELECT p.nome, t.nome_equipe
FROM pokemon p
JOIN equipe_pokemon tp ON p.id = tp.id_pokemon
JOIN equipe t ON tp.id_equipe = t.id
WHERE p.especie = 'Lendário';