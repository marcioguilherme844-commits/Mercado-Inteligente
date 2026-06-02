/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mercado.inteligente.decorator;
 
public class ProdutoPremium extends ProdutoDecorator {
    public ProdutoPremium(ProdutoComponent p) {
        super(p);
    }
 
    @Override
    public String getDescricao() {
        return super.getDescricao() + " + PREMIUM";
    }
 
    @Override
    public double getPrecoFinal() {
        return super.getPrecoFinal() * 1.25; // +25%
    }
}
 