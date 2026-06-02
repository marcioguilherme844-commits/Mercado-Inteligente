package com.mercado.inteligente.model;

public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private String endereco;

    public Cliente() {}
    public Cliente(Long id, String nome, String cpf, String endereco) {
        this.id = id; this.nome = nome; this.cpf = cpf; this.endereco = endereco;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEndereco() { return endereco; }
}