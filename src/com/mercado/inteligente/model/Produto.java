package com.mercado.inteligente.model;

public class Produto {
    private Long id;
    private String codigoBarras;
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto() {}
    public Produto(Long id, String codigoBarras, String nome, double preco, int quantidadeEstoque) {
        this.id = id; this.codigoBarras = codigoBarras; this.nome = nome; this.preco = preco; this.quantidadeEstoque = quantidadeEstoque;
    }

    public void reduzirEstoque(int qtd) {
        if (qtd > quantidadeEstoque) throw new IllegalArgumentException("Estoque insuficiente para " + nome);
        quantidadeEstoque -= qtd;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigoBarras() { return codigoBarras; }
    public void setCodigoBarras(String codigoBarras) { this.codigoBarras = codigoBarras; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }
}