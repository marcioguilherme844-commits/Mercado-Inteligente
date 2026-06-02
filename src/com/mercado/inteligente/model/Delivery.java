package com.mercado.inteligente.model;

import java.time.LocalDateTime;

public class Delivery {
    private Long id;
    
    private String enderecoEntrega;
    private LocalDateTime dataSolicitacao;
    private LocalDateTime dataEntregaPrevista;
    private String statusEntrega = "PENDENTE";
    private double taxaEntrega = 8.90;

  private Delivery(DeliveryBuilder builder) {
        this.id = builder.id;
        this.enderecoEntrega = builder.enderecoEntrega;
        this.dataSolicitacao = LocalDateTime.now();
        this.dataEntregaPrevista = builder.dataEntregaPrevista;
        this.statusEntrega = "PENDENTE";
        this.taxaEntrega = builder.taxaEntrega;
    }

    
 
    public static class DeliveryBuilder {
        private Long id;
        private String enderecoEntrega;
        private LocalDateTime dataEntregaPrevista = LocalDateTime.now().plusDays(2);
        private double taxaEntrega = 8.90;

        public DeliveryBuilder() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

 
        public DeliveryBuilder enderecoEntrega(String endereco) {
            this.enderecoEntrega = endereco;
            return this;
        }
 
        public DeliveryBuilder taxaEntrega(double taxa) {
            this.taxaEntrega = taxa;
            return this;
        }
 
        public Delivery build() {
            if (enderecoEntrega == null || enderecoEntrega.trim().isEmpty()) {
                throw new IllegalStateException("Endereço de entrega é obrigatório");
            }
            return new Delivery(this);
        }
    }
 

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEnderecoEntrega() { return enderecoEntrega; }
    public double getTaxaEntrega() { return taxaEntrega; }
}