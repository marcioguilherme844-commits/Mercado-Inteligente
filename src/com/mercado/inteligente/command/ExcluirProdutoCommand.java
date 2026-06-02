/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mercado.inteligente.command;



import com.mercado.inteligente.dao.ProdutoDAO;

import com.mercado.inteligente.view.MercadoInteligenteGUI;

import javax.swing.JOptionPane;


public class ExcluirProdutoCommand implements Command {

private final ProdutoDAO produtoDAO;

private final MercadoInteligenteGUI view;


public ExcluirProdutoCommand(ProdutoDAO produtoDAO, MercadoInteligenteGUI view) {

this.produtoDAO = produtoDAO;

this.view = view;

}


@Override

public void execute() {

try {

int linha = view.getTabelaProdutos().getSelectedRow();

if (linha == -1) {

JOptionPane.showMessageDialog(null, "Selecione um produto!");

return;

}



Long id = (Long) view.getTabelaProdutos().getValueAt(linha, 0);

int confirm = JOptionPane.showConfirmDialog(null, "Excluir este produto?", "Confirmar", JOptionPane.YES_NO_OPTION);



if (confirm == JOptionPane.YES_OPTION) {

produtoDAO.deletar(id);

JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");

}

} catch (Exception e) {

JOptionPane.showMessageDialog(null, "Erro ao excluir produto.");

}

}

}