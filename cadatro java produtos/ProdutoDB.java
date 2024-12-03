package com.CadastroProdutos;

import java.sql.*;

public class ProdutoDB {


    private static final String URL = "jdbc:mysql://localhost:3306/POO_CadastroProdutos";
    private static final String USER = "ProductManager";
    private static final String PASSWORD = "1234";


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do MySQL não encontrado", e);
        }
    }
    public static void testarConexao() {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Conexão bem-sucedida!");
            } else {
                System.out.println("Falha na conexão.");
            }
        } catch (SQLException e) {
            System.err.println("Erro de conexão: " + e.getMessage());
        }
    }

    public static void inserirProduto(Produto produto) {
        String sql = "INSERT INTO Produto (TipoProduto, DescricaoProduto, PesoProduto, QuantidadeProduto, UnidadeMedidaProduto) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getTipoProduto());
            stmt.setString(2, produto.getDescricaoProduto());
            stmt.setFloat(3, produto.getPesoProduto());
            stmt.setInt(4, produto.getQuantidadeProduto());
            stmt.setString(5, produto.getUnidadeMedidaProduto());

            stmt.executeUpdate();
            System.out.println("Produto inserido com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

  
    public static void listarProdutos() {
        String sql = "SELECT * FROM Produto";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("CodigoProduto") + ", Tipo: " + rs.getString("TipoProduto") +
                        ", Descrição: " + rs.getString("DescricaoProduto") +
                        ", Peso: " + rs.getFloat("PesoProduto") +
                        ", Quantidade: " + rs.getInt("QuantidadeProduto") +
                        ", Unidade: " + rs.getString("UnidadeMedidaProduto"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produto: " + e.getMessage());
        }
    }

   
    public static void atualizarProduto(Produto produto, int id) {
        String sql = "UPDATE Produto SET TipoProduto = ?, DescricaoProduto = ?, PesoProduto = ?, QuantidadeProduto = ?, UnidadeMedidaProduto = ? WHERE CodigoProduto = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getTipoProduto());
            stmt.setString(2, produto.getDescricaoProduto());
            stmt.setFloat(3, produto.getPesoProduto());
            stmt.setInt(4, produto.getQuantidadeProduto());
            stmt.setString(5, produto.getUnidadeMedidaProduto());
            stmt.setInt(6, id);

            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    // DELETE
    public static void excluirProduto(int id) {
        String sql = "DELETE FROM Produto WHERE CodigoProduto = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Produto excluído com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao excluir produto: " + e.getMessage());
        }
    }
}