package com.mercado.inteligente.dao;

import com.mercado.inteligente.model.Produto;
import com.mercado.inteligente.util.ConexaoUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements GenericDAO<Produto> {

    @Override
    public void salvar(Produto p) {
        String sql = "INSERT INTO produto (codigo_barras, nome, preco, quantidade_estoque) VALUES (?,?,?,?)";
        try (Connection conn = ConexaoUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, p.getCodigoBarras());
            stmt.setString(2, p.getNome());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getQuantidadeEstoque());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) p.setId(rs.getLong(1));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void atualizar(Produto p) {
        String sql = "UPDATE produto SET nome=?, preco=?, quantidade_estoque=? WHERE id=?";
        try (Connection conn = ConexaoUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getQuantidadeEstoque());
            stmt.setLong(4, p.getId());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (Connection conn = ConexaoUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public Produto buscarPorId(Long id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        try (Connection conn = ConexaoUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Produto(rs.getLong("id"), rs.getString("codigo_barras"),
                            rs.getString("nome"), rs.getDouble("preco"), rs.getInt("quantidade_estoque"));
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public List<Produto> listarTodos() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        try (Connection conn = ConexaoUtil.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Produto(rs.getLong("id"), rs.getString("codigo_barras"),
                        rs.getString("nome"), rs.getDouble("preco"), rs.getInt("quantidade_estoque")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public Produto buscarPorCodigoBarras(String codigo) {
        String sql = "SELECT * FROM produto WHERE codigo_barras = ?";
        try (Connection conn = ConexaoUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Produto(rs.getLong("id"), rs.getString("codigo_barras"),
                            rs.getString("nome"), rs.getDouble("preco"), rs.getInt("quantidade_estoque"));
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}