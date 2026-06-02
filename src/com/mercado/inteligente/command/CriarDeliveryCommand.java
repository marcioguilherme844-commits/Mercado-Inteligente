/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mercado.inteligente.command;



import com.mercado.inteligente.dao.DeliveryDAO;

import com.mercado.inteligente.dao.ProdutoDAO;

import com.mercado.inteligente.model.Delivery;

import com.mercado.inteligente.model.Produto;

import javax.swing.JOptionPane;



public class CriarDeliveryCommand implements Command {

private final DeliveryDAO deliveryDAO;

private final ProdutoDAO produtoDAO;

    

public CriarDeliveryCommand(DeliveryDAO deliveryDAO, ProdutoDAO produtoDAO) {
        this.deliveryDAO = deliveryDAO;
        this.produtoDAO = produtoDAO;
    
    }


@Override

    public void execute() {
        try {
            String idStr = JOptionPane.showInputDialog("ID do Produto:");
            if (idStr == null || idStr.trim().isEmpty()) {
                return;
            }
            

Long produtoId = Long.parseLong(idStr.trim());
            Produto produto = produtoDAO.buscarPorId(produtoId);
            

if (produto == null) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                return;
            }


            
            
            if (produto.getQuantidadeEstoque() <= 0) {
                JOptionPane.showMessageDialog(null, "Estoque insuficiente!");
                return;
        }


            
            
            

String endereco = JOptionPane.showInputDialog("Endereço completo de entrega:");
            if (endereco == null || endereco.trim().isEmpty()) {
                return;
            }
            

String taxaStr = JOptionPane.showInputDialog("Taxa de entrega (padrão 8,90):");
            double taxa = (taxaStr != null && !taxaStr.trim().isEmpty()) ? Double.parseDouble(taxaStr.trim()) : 8.90;
            

Delivery delivery = new Delivery.DeliveryBuilder()

           .enderecoEntrega(endereco.trim())

            .taxaEntrega(taxa)

            .build();
            

deliveryDAO.salvar(delivery);
            produto.reduzirEstoque(1);
            produtoDAO.atualizar(produto);
            

JOptionPane.showMessageDialog(null, "Delivery criado com sucesso! ID: " + delivery.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar Delivery: " + e.getMessage());
        }


    


    


    

}

}
