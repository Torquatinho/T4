import streamlit as st
import mysql.connector

#rodar = python -m streamlit run app.py

# Função para conectar ao banco de dados
def connect_to_database():
    return mysql.connector.connect(
        host="localhost",  # Altere se necessário
        user="Pipis",  # Substitua pelo seu usuário MySQL
        password="12345",  # Substitua pela sua senha MySQL
        database="POKEMON"  # Nome do banco de dados criado
    )

# Função para buscar dados de qualquer tabela
def fetch_data(query, params=None):
    connection = connect_to_database()
    cursor = connection.cursor(dictionary=True)
    cursor.execute(query, params or ())
    results = cursor.fetchall()
    cursor.close()
    connection.close()
    return results

# Função para inserir ou excluir dados
def insert_data(query, data):
    connection = connect_to_database()
    cursor = connection.cursor()
    try:
        cursor.execute(query, data)
        connection.commit()
        st.success("Operação realizada com sucesso! :D")
    except mysql.connector.Error as e:
        st.error(f"Erro ao executar a operação >:C: {e}")
    finally:
        cursor.close()
        connection.close()

# Configuração principal do Streamlit
st.title("Pokedex")

# Menu lateral
menu = st.sidebar.selectbox("Menu", ["Visualizar Dados", "Inserir Pokémon", "Inserir Treinador", "Inserir Equipe", "Inserir Pokemon na Equipe", "Excluir Dados", "Consultar Equipe e Treinador"])

# Seção para Visualizar Dados
# Seção para Visualizar Dados
if menu == "Visualizar Dados":
    st.header("Dados no BD")
    
    # Selecionar a tabela para exibição
    tabela = st.selectbox("Selecione uma tabela", ["treinador", "pokemon", "equipe", "equipe_pokemon"])
    
    if st.button("Carregar Dados"):
        try:
            # Buscar os dados da tabela selecionada
            data = fetch_data(f"SELECT * FROM {tabela}")

            # Formatando o peso, se for a tabela 'pokemon'
            if tabela == "pokemon":
                for row in data:
                    row['peso'] = f"{row['peso']:.1f}"  # Formatar peso para uma casa decimal
            
            # Exibir os dados na interface
            if data:
                st.table(data)
            else:
                st.write(f"Nenhum registro encontrado na tabela {tabela}.")
        except Exception as e:
            st.error(f"Erro ao buscar dados: {e}")

# Seção para Adicionar um Pokémon
elif menu == "Inserir Pokémon":
    st.header("Adicionar novo Pokémon")
    with st.form(key="inserir_pokemon"):
        id = st.number_input("ID (N pokedex)", min_value=1, max_value=2000, step=1)
        nome = st.text_input("Nome do Pokémon")
        tipagem_1 = st.selectbox(
            "Tipagem 1",
            ["Grama", "Fogo", "Água", "Elétrico", "Normal", "Voador", "Inseto", "Veneno", "Pedra", "Terra", "Metal",
             "Lutador", "Psíquico", "Sombrio", "Fada", "Fantasma", "Gelo", "Dragão"]
        )
        tipagem_2 = st.selectbox(
            "Tipagem 2 (opcional)",
            ["--", "Grama", "Fogo", "Água", "Elétrico", "Normal", "Voador", "Inseto", "Veneno", "Pedra", "Terra", "Metal",
             "Lutador", "Psíquico", "Sombrio", "Fada", "Fantasma", "Gelo", "Dragão"]
        )
        tipagem_2 = None if tipagem_2 == "--" else tipagem_2
        hp = st.number_input("HP", min_value=1, max_value=255, step=1)
        ataque = st.number_input("Ataque", min_value=1, max_value=255, step=1)
        defesa = st.number_input("Defesa", min_value=1, max_value=255, step=1)
        ataque_especial = st.number_input("Ataque Especial", min_value=1, max_value=255, step=1)
        defesa_especial = st.number_input("Defesa Especial", min_value=1, max_value=255, step=1)
        velocidade = st.number_input("Velocidade", min_value=1, max_value=255, step=1)
        habilidades = st.text_area("Habilidades (separadas por vírgulas)")
        especie = st.selectbox("Espécie", ["Comum", "Lendário"])
        peso = st.number_input("Peso (kg)", min_value=0.1, step=0.1)

        submit = st.form_submit_button("Adicionar Pokémon")
        if submit:
            query = """
                INSERT INTO pokemon 
                (id, nome, tipagem_1, tipagem_2, hp, ataque, defesa, ataque_especial, defesa_especial, velocidade, habilidades, especie, peso)
                VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
            """
            data = (id, nome, tipagem_1, tipagem_2, hp, ataque, defesa, ataque_especial, defesa_especial, velocidade, habilidades, especie, peso)
            insert_data(query, data)

# Inserir Treinador
elif menu == "Inserir Treinador":
    st.header("Adicionar Novo Treinador")
    with st.form(key="inserir_treinador"):
        id = st.number_input("ID do Treinador", min_value=1, step=1)
        nome = st.text_input("Nome do Treinador")
        idade = st.number_input("Idade", min_value=10, max_value=100, step=1)
        regiao = st.text_input("Região")

        submit = st.form_submit_button("Adicionar Treinador")
        if submit:
            query = "INSERT INTO treinador (id, nome, idade, regiao) VALUES (%s, %s, %s, %s)"
            data = (id, nome, idade, regiao)
            insert_data(query, data)

# Inserir Equipe
elif menu == "Inserir Equipe":
    st.header("Adicionar Nova Equipe")
    with st.form(key="inserir_equipe"):
        id = st.number_input("TimeID", min_value=1, step=1)
        nome_equipe = st.text_input("Nome da Equipe")
        id_treinador = st.number_input("ID do Treinador", min_value=1, step=1)
        submit = st.form_submit_button("Adicionar Equipe")
        if submit:
            query = "INSERT INTO equipe (id, nome_equipe, id_treinador) VALUES (%s, %s, %s)"
            data = (id, nome_equipe, id_treinador)
            insert_data(query, data)

elif menu == "Inserir Pokemon na Equipe":
    st.header("Adicionar Pokémon à Equipe")
    with st.form(key="inserir_equipe_pokemon"):
        id_equipe = st.number_input("ID da Equipe", min_value=1, step=1)
        nome_pokemon = st.text_input("Nome do Pokémon")
        posicao = st.number_input("Posição na Equipe (1 a 6)", min_value=1, max_value=6, step=1)

        submit = st.form_submit_button("Adicionar Pokémon")
        if submit:
            try:
                query_count = "SELECT COUNT(*) AS total FROM equipe_pokemon WHERE id_equipe = %s"
                total_pokemons = fetch_data(query_count, (id_equipe,))[0]["total"]
                
                if total_pokemons >= 6:
                    st.error("A equipe já possui 6 Pokémons. Não é possível adicionar mais.")
                else:
                    query_pokemon = "SELECT id FROM pokemon WHERE nome = %s"
                    result = fetch_data(query_pokemon, (nome_pokemon,))
                    
                    if not result:
                        st.error(f"Pokémon '{nome_pokemon}' não encontrado no banco de dados.")
                    else:
                        id_pokemon = result[0]["id"]
                        query_insert = """
                            INSERT INTO equipe_pokemon (id_equipe, id_pokemon, posicao)
                            VALUES (%s, %s, %s)
                        """
                        insert_data(query_insert, (id_equipe, id_pokemon, posicao))
            except Exception as e:
                st.error(f"Erro ao adicionar Pokémon à equipe: {e}")

# Excluir Registros
elif menu == "Excluir Dados":
    st.header("Excluir Registros")
    tabela = st.selectbox("Selecione a tabela", ["treinador", "pokemon", "equipe", "equipe_pokemon"])
    id_registro = st.number_input(f"ID do registro na tabela {tabela}", min_value=1, step=1)
    if st.button("Excluir Registro"):
        try:
            # Se a tabela for 'pokemon' ou 'treinador', exclua primeiro as dependências
            if tabela == "pokemon":
                query_dependencias = "DELETE FROM equipe_pokemon WHERE id_pokemon = %s"
                insert_data(query_dependencias, (id_registro,))
            elif tabela == "treinador":
                query_dependencias = "DELETE FROM equipe WHERE id_treinador = %s"
                insert_data(query_dependencias, (id_registro,))

            # Excluir o registro principal
            query = f"DELETE FROM {tabela} WHERE id = %s"
            insert_data(query, (id_registro,))
        except Exception as e:
            st.error(f"Erro ao excluir registro: {e}")

#consultar equipe e treibador
elif menu == "Consultar Equipe e Treinador":
    st.header("Consultar Treinador e Time de uma Equipe")
    id_equipe = st.number_input("ID da Equipe", min_value=1, step=1)
    if st.button("Buscar Informações da Equipe"):
        try:
            # Buscar informações do treinador e nome da equipe
            query_info = """
                SELECT e.nome_equipe, t.nome AS treinador
                FROM equipe e
                JOIN treinador t ON e.id_treinador = t.id
                WHERE e.id = %s
            """
            info = fetch_data(query_info, (id_equipe,))
            
            if not info:
                st.warning("Nenhuma equipe ou treinador encontrado para o ID fornecido.")
            else:
                nome_equipe = info[0]['nome_equipe']
                treinador = info[0]['treinador']
                st.write(f"**Equipe:** {nome_equipe}")
                st.write(f"**Treinador:** {treinador}")

                # Buscar Pokémons na equipe
                query_pokemons = """
                    SELECT ep.posicao, p.nome AS pokemon
                    FROM equipe_pokemon ep
                    LEFT JOIN pokemon p ON ep.id_pokemon = p.id
                    WHERE ep.id_equipe = %s
                    ORDER BY ep.posicao
                """
                pokemons = fetch_data(query_pokemons, (id_equipe,))
                
                # Criar tabela com posições de 1 a 6, preenchendo com "NULL" onde não houver Pokémon
                tabela_time = {pos: "NULL" for pos in range(1, 7)}
                for pokemon in pokemons:
                    tabela_time[pokemon["posicao"]] = pokemon["pokemon"]

                # Mostrar tabela do time
                st.table([
                    {"Posição": pos, "Pokémon": tabela_time[pos]}
                    for pos in range(1, 7)
                ])
        except Exception as e:
            st.error(f"Erro ao buscar informações: {e}")

            