/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mercado.inteligente.decorator;
 
public abstract class ProdutoDecorator implements ProdutoComponent {
    protected final ProdutoComponent wrapped;
 
    public ProdutoDecorator(ProdutoComponent wrapped) {
        this.wrapped = wrapped;
    }
 
    @Override
    public String getDescricao() {
        return wrapped.getDescricao();
    }
 
    @Override
    public double getPrecoFinal() {
        return wrapped.getPrecoFinal();
    }
 
    @Override
    public void exibirInfo() {
        wrapped.exibirInfo();
    }
}