package com.mercado.inteligente.dao;

import com.mercado.inteligente.model.Delivery;
import com.mercado.inteligente.util.ConexaoUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO implements GenericDAO<Delivery> {

   @Override
    public void salvar(Delivery d) {
        String sql = "INSERT INTO delivery (endereco_entrega, taxa_entrega) VALUES (?, ?)";
        try (Connection conn = ConexaoUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
 
            stmt.setString(1, d.getEnderecoEntrega());
            stmt.setDouble(2, d.getTaxaEntrega());
            stmt.executeUpdate();
 
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    d.setId(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar Delivery", e);
        }
    }

    @Override
    public void atualizar(Delivery d) {
        String sql = "UPDATE delivery SET status_entrega = ? WHERE id = ?";
        try (Connection conn = ConexaoUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(2, d.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM delivery WHERE id = ?";
        try (Connection conn = ConexaoUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Delivery buscarPorId(Long id) {
        return null; // implemente se necessário
    }

    @Override
    public List<Delivery> listarTodos() {
        List<Delivery> lista = new ArrayList<>();
        String sql = "SELECT * FROM delivery";
        
        try (Connection conn = ConexaoUtil.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Delivery delivery = new Delivery.DeliveryBuilder()
                        .enderecoEntrega(rs.getString("endereco_entrega"))
                        .taxaEntrega(rs.getDouble("taxa_entrega"))
                        .build();
                
                delivery.setId(rs.getLong("id"));
                
                lista.add(delivery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}