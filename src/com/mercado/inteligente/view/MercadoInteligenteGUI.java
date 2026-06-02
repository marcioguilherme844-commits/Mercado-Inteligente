/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mercado.inteligente.view;

import com.mercado.inteligente.model.Delivery;
import com.mercado.inteligente.model.Pedido;
import com.mercado.inteligente.model.Produto;
import com.mercado.inteligente.controller.MercadoController;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class MercadoInteligenteGUI extends javax.swing.JFrame {
    private MercadoController controller;
    /**
     * Creates new form MercadoInteligenteGUI
     */
    public MercadoInteligenteGUI() {
        initComponents();
        MercadoController controller = new MercadoController(this);
        controller.carregarProdutos();
        
        btnNovoProduto.addActionListener(e -> controller.novoProduto());
        btnAtualizarEstoque.addActionListener(e -> controller.atualizarEstoque());
        btnCriarDelivery.addActionListener(e -> controller.criarDelivery());
        btnExcluirProduto.addActionListener(e -> controller.excluirProduto());
        btnVerProduto.addActionListener(e -> controller.verDetalhesProduto());
        btnExcluirDelivery.addActionListener(e -> controller.excluirDelivery());    
        btnListarDeliveries.addActionListener(e -> controller.listarTodosDeliveries());
        btnAplicarDecorator.addActionListener(e -> controller.aplicarDecoratorProduto());
    }
     public JTable getTabelaProdutos() {
        return tabelaProdutos;
    }

     public void atualizarTabelaDeliveries(List<Delivery> deliveries) {
        DefaultTableModel model = (DefaultTableModel) tabelaPedidos.getModel(); // reutilizando a tabela da aba
        model.setRowCount(0);
 
        for (Delivery d : deliveries) {
            model.addRow(new Object[]{
                d.getId(),
                d.getEnderecoEntrega(),
                
                String.format("R$ %.2f", d.getTaxaEntrega()),
            });
        }
    }
     
        public void atualizarTabelaProdutos(java.util.List<Produto> produtos) {
        javax.swing.table.DefaultTableModel model =(javax.swing.table.DefaultTableModel)
        tabelaProdutos.getModel();
        model.setRowCount(0);
        for(Produto p : produtos) {
            model.addRow(new Object[]{
                p.getId(),
                p.getCodigoBarras(),
                String.format("R$ %.2f", p.getPreco()),
                p.getQuantidadeEstoque()
            });
        }
    }
    



 public void atualizarTabelaPedido(java.util.List<Pedido> pedidos) {
        javax.swing.table.DefaultTableModel model =(javax.swing.table.DefaultTableModel)
        tabelaPedidos.getModel();
        model.setRowCount(0);
 for(Pedido p : pedidos) {
            model.addRow(new Object[]{
                p.getId(),
                p.getCliente().getNome(),
                String.format("R$ %.2f", p.getValorTotal()),
                p.getStatus()
                    });
        }
    }
    

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        btnNovoProduto = new javax.swing.JButton();
        btnAtualizarEstoque = new javax.swing.JButton();
        btnExcluirProduto = new javax.swing.JButton();
        btnVerProduto = new javax.swing.JButton();
        btnAplicarDecorator = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPedidos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        btnCriarDelivery = new javax.swing.JButton();
        btnExcluirDelivery = new javax.swing.JButton();
        btnListarDeliveries = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mercado.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id do Produto", "Id específico", "Preço", "Estoque"
            }
        ));
        jScrollPane2.setViewportView(tabelaProdutos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 10, 620, 222));

        btnNovoProduto.setText("Novo Produto");
        btnNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 258, -1, -1));

        btnAtualizarEstoque.setText("Atualizar Estoque");
        jPanel1.add(btnAtualizarEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 258, -1, -1));

        btnExcluirProduto.setText("Excluir Produto");
        jPanel1.add(btnExcluirProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 258, -1, -1));

        btnVerProduto.setText("Ver Detalhes");
        btnVerProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 258, -1, -1));

        btnAplicarDecorator.setText("Opções Bônus");
        jPanel1.add(btnAplicarDecorator, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        jTabbedPane1.addTab("Produtos", jPanel1);

        tabelaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id do Pedido", "Endereço", "Taxa"
            }
        ));
        jScrollPane1.setViewportView(tabelaPedidos);

        jButton2.setText("jButton2");

        btnCriarDelivery.setText("Criar Pedido");
        btnCriarDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarDeliveryActionPerformed(evt);
            }
        });

        btnExcluirDelivery.setText("Excluir pedido");

        btnListarDeliveries.setText("Mostrar Pedidos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnCriarDelivery)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirDelivery)
                        .addGap(18, 18, 18)
                        .addComponent(btnListarDeliveries)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarDelivery)
                    .addComponent(btnExcluirDelivery)
                    .addComponent(btnListarDeliveries))
                .addGap(0, 157, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pedidos", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 623, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerProdutoActionPerformed

    private void btnCriarDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarDeliveryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCriarDeliveryActionPerformed

    private void btnNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovoProdutoActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarDecorator;
    private javax.swing.JButton btnAtualizarEstoque;
    private javax.swing.JButton btnCriarDelivery;
    private javax.swing.JButton btnExcluirDelivery;
    private javax.swing.JButton btnExcluirProduto;
    private javax.swing.JButton btnListarDeliveries;
    private javax.swing.JButton btnNovoProduto;
    private javax.swing.JButton btnVerProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelaPedidos;
    private javax.swing.JTable tabelaProdutos;
    // End of variables declaration//GEN-END:variables

 public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MercadoInteligenteGUI().setVisible(true);
            }
        });
    }

    
}