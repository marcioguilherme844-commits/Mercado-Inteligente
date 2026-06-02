package com.mercado.inteligente.controller;

import com.mercado.inteligente.command.*;
import com.mercado.inteligente.dao.*;
import com.mercado.inteligente.decorator.*;
import com.mercado.inteligente.command.CriarDeliveryCommand;
import com.mercado.inteligente.command.ExcluirDeliveryCommand;
import com.mercado.inteligente.command.ExcluirProdutoCommand;
import com.mercado.inteligente.command.ListarDeliveriesCommand;
import com.mercado.inteligente.command.NovoProdutoCommand;
import com.mercado.inteligente.dao.DeliveryDAO;
import com.mercado.inteligente.dao.ProdutoDAO;
import com.mercado.inteligente.model.Produto;
import com.mercado.inteligente.view.MercadoInteligenteGUI;
import javax.swing.JOptionPane;

public class MercadoController {

    private final MercadoInteligenteGUI view;

    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    private final DeliveryDAO deliveryDAO = new DeliveryDAO();

    public MercadoController(MercadoInteligenteGUI view) {

        this.view = view;

    }

    public void carregarProdutos() {

        view.atualizarTabelaProdutos(produtoDAO.listarTodos());

    }

    public void novoProduto() {

        new NovoProdutoCommand(produtoDAO).execute();

        carregarProdutos();

    }

    public void excluirProduto() {

        new ExcluirProdutoCommand(produtoDAO, view).execute();

        carregarProdutos();

    }

    public void verDetalhesProduto() {

        try {

            String input = JOptionPane.showInputDialog(null,
                    "Digite o ID do produto:",
                    "Ver Detalhes",
                    JOptionPane.QUESTION_MESSAGE);

            if (input == null || input.trim().isEmpty()) {
                return;
            }

            Long id = Long.parseLong(input.trim());

            Produto produto = produtoDAO.buscarPorId(id);

            if (produto != null) {

                String detalhes = """

                    === DETALHES DO PRODUTO ===

                    

                    ID: %d

                    Código de Barras: %s

                    Nome: %s

                    Preço: R$ %.2f

                    Estoque: %d unidades

                    """.formatted(
                        produto.getId(),
                        produto.getCodigoBarras(),
                        produto.getNome(),
                        produto.getPreco(),
                        produto.getQuantidadeEstoque()
                );

                JOptionPane.showMessageDialog(null, detalhes, "Detalhes do Produto", JOptionPane.INFORMATION_MESSAGE);

            } else {

                JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);

            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao buscar detalhes.", "Erro", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void atualizarEstoque() {

        try {

            Long id = Long.parseLong(JOptionPane.showInputDialog("ID do produto:"));

            int novoEstoque = Integer.parseInt(JOptionPane.showInputDialog("Nova quantidade em estoque:"));

            Produto p = produtoDAO.buscarPorId(id);

            if (p != null) {

                p.setQuantidadeEstoque(novoEstoque);

                produtoDAO.atualizar(p);

                carregarProdutos();

                JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso!");

            } else {

                JOptionPane.showMessageDialog(null, "Produto não encontrado!");

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque.");

        }

    }

    public void criarDelivery() {

        new CriarDeliveryCommand(deliveryDAO, produtoDAO).execute();

        carregarProdutos();

    }

    public void listarDeliveries() {

        new ListarDeliveriesCommand(deliveryDAO, view).execute();

    }

    public void excluirDelivery() {

        new ExcluirDeliveryCommand(deliveryDAO, view).execute();

        listarDeliveries();

    }

    public void listarTodosDeliveries() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void aplicarDecoratorProduto() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog("Digite o ID do Produto:"));
            Produto produto = produtoDAO.buscarPorId(id);
 
            if (produto == null) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                return;
            }
 
            ProdutoComponent p = new ProdutoBase(produto);
            double precoOriginal = produto.getPreco();
 
            // Aplicando decoradores
            if (JOptionPane.showConfirmDialog(null, "Aplicar Desconto de 10%?", "Decorator", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                p = new ProdutoComDesconto(p, 10);
            }
 
            if (JOptionPane.showConfirmDialog(null, "Tornar Produto Premium (+25%)?", "Decorator", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                p = new ProdutoPremium(p);
            }
 
            double precoFinal = p.getPrecoFinal();
 
            // Atualiza o preço no banco de dados
            int confirm = JOptionPane.showConfirmDialog(null, 
                "Aplicar o novo preço de R$ " + String.format("%.2f", precoFinal) + " no produto?", 
                "Confirmar Alteração", JOptionPane.YES_NO_OPTION);
 
            if (confirm == JOptionPane.YES_OPTION) {
                produto.setPreco(precoFinal);
                produtoDAO.atualizar(produto);
                carregarProdutos();   // Atualiza a tabela
                JOptionPane.showMessageDialog(null, "Preço atualizado com sucesso!");
            }
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao aplicar decorator: " + e.getMessage());
        }
    }
}
