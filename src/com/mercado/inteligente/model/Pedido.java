package com.mercado.inteligente.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Long id;
    private Cliente cliente;
    private LocalDateTime dataPedido;
    private List<ItemPedido> itens = new ArrayList<>();
    private double valorTotal;
    private String status = "PENDENTE";

    private Pedido(PedidoBuilder builder) {
        this.id = builder.id;
        this.cliente = builder.cliente;
        this.dataPedido = LocalDateTime.now();
        this.itens = builder.itens;
        this.valorTotal = builder.itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }

    public static class PedidoBuilder {
        private Long id;
        private Cliente cliente;
        private List<ItemPedido> itens = new ArrayList<>();

        public PedidoBuilder cliente(Cliente c) { this.cliente = c; return this; }
        public PedidoBuilder adicionarItem(Produto p, int qtd) {
            this.itens.add(new ItemPedido(p, qtd));
            return this;
        }
        public Pedido build() {
            if (cliente == null || itens.isEmpty()) throw new IllegalStateException("Pedido inválido");
            return new Pedido(this);
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public List<ItemPedido> getItens() { return itens; }
    public double getValorTotal() { return valorTotal; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}