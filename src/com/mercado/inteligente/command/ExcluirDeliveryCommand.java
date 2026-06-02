/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mercado.inteligente.command;



import com.mercado.inteligente.dao.DeliveryDAO;
import com.mercado.inteligente.model.Delivery;

import com.mercado.inteligente.view.MercadoInteligenteGUI;

import javax.swing.JOptionPane;



public class ExcluirDeliveryCommand implements Command {



private final DeliveryDAO deliveryDAO;

private final MercadoInteligenteGUI view;



public ExcluirDeliveryCommand(DeliveryDAO deliveryDAO, MercadoInteligenteGUI view) {

this.deliveryDAO = deliveryDAO;

this.view = view;
}



@Override

public void execute() {

try {

String input = JOptionPane.showInputDialog("Digite o ID do Delivery para excluir:");

if (input == null || input.trim().isEmpty()) return;



Long id = Long.parseLong(input.trim());



int confirm = JOptionPane.showConfirmDialog(null,

        "Excluir Delivery ID " + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);



if (confirm == JOptionPane.YES_OPTION) {

deliveryDAO.deletar(id);

JOptionPane.showMessageDialog(null, "Delivery excluído com sucesso!");

}
} catch (Exception e) {

JOptionPane.showMessageDialog(null, "Erro ao excluir Delivery.");

}

}

}