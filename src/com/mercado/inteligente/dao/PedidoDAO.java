package com.mercado.inteligente.dao;

import com.mercado.inteligente.model.Cliente;
import com.mercado.inteligente.model.Pedido;
import com.mercado.inteligente.util.ConexaoUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements GenericDAO<Pedido> {

    @Override
    public void salvar(Pedido pedido) {
        String sql = "INSERT INTO pedido (cliente_id, valor_total, status) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, pedido.getCliente().getId());
            stmt.setDouble(2, pedido.getValorTotal());
            stmt.setString(3, pedido.getStatus());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) pedido.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Pedido pedido) {
        String sql = "UPDATE pedido SET status = ? WHERE id = ?";
        try (Connection conn = ConexaoUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pedido.getStatus());
            stmt.setLong(2, pedido.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM pedido WHERE id = ?";
        try (Connection conn = ConexaoUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido buscarPorId(Long id) {
        // Implementação simplificada - pode expandir para carregar itens também
        return null; // complete conforme necessidade
    }

    @Override
    public List<Pedido> listarTodos() {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT p.*, c.nome as cliente_nome FROM pedido p JOIN cliente c ON p.cliente_id = c.id";
        try (Connection conn = ConexaoUtil.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getLong("cliente_id"), rs.getString("cliente_nome"), "", "");
                Pedido pedido = new Pedido.PedidoBuilder()
                        .cliente(cliente)
                        .build(); // ajuste conforme seu Builder
                pedido.setId(rs.getLong("id"));
                pedido.setStatus(rs.getString("status"));
                lista.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}