/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mercado.inteligente.command;

/**
 *
 * @author Administrador
 */




import com.mercado.inteligente.dao.DeliveryDAO;

import com.mercado.inteligente.model.Delivery;

import com.mercado.inteligente.view.MercadoInteligenteGUI;

import java.util.List;



public class ListarDeliveriesCommand implements Command {



private final DeliveryDAO deliveryDAO;

private final MercadoInteligenteGUI view;



public ListarDeliveriesCommand(DeliveryDAO deliveryDAO, MercadoInteligenteGUI view) {

this.deliveryDAO = deliveryDAO;

this.view = view;

}


@Override

public void execute() {

List<Delivery> deliveries = deliveryDAO.listarTodos();

view.atualizarTabelaDeliveries(deliveries);

}

}