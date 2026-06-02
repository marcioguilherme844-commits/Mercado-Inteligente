/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mercado.inteligente.command;



import com.mercado.inteligente.dao.ProdutoDAO;

import com.mercado.inteligente.model.Produto;

import javax.swing.JOptionPane;



public class NovoProdutoCommand implements Command {



private final ProdutoDAO produtoDAO;



public NovoProdutoCommand(ProdutoDAO produtoDAO) {

this.produtoDAO = produtoDAO;

}



@Override

public void execute() {

try {

String codigo = JOptionPane.showInputDialog("Código de barras:");

if (codigo == null || codigo.trim().isEmpty()) return;



String nome = JOptionPane.showInputDialog("Nome do produto:");
if (nome == null || nome.trim().isEmpty()) return;



String precoStr = JOptionPane.showInputDialog("Preço (R$):");

String estoqueStr = JOptionPane.showInputDialog("Estoque inicial:");



double preco = Double.parseDouble(precoStr.replace(",", "."));

int estoque = Integer.parseInt(estoqueStr);




Produto produto = new Produto();

produto.setCodigoBarras(codigo.trim());

produto.setNome(nome.trim());

produto.setPreco(preco);

produto.setQuantidadeEstoque(estoque);



produtoDAO.salvar(produto);


JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);



} catch (NumberFormatException e) {

JOptionPane.showMessageDialog(null, "Por favor, digite números válidos para preço e estoque.", "Erro", JOptionPane.ERROR_MESSAGE);

} catch (Exception e) {

JOptionPane.showMessageDialog(null, "Erro ao criar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

}

}

}