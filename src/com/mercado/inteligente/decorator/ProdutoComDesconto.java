/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mercado.inteligente.decorator;
 
public class ProdutoComDesconto extends ProdutoDecorator {
    private final double percentual;
 
    public ProdutoComDesconto(ProdutoComponent p, double percentual) {
        super(p);
        this.percentual = percentual;
    }
 
    @Override
    public String getDescricao() {
        return super.getDescricao() + " + DESCONTO " + percentual + "%";
    }
 
    @Override
    public double getPrecoFinal() {
        return super.getPrecoFinal() * (1 - percentual / 100);
    }
}