package com.mercado.inteligente.decorator;



import com.mercado.inteligente.model.Produto;



public class ProdutoBase implements ProdutoComponent {

private final Produto produto;



public ProdutoBase(Produto produto) {

this.produto = produto;

}



@Override

public String getDescricao() {

return produto.getNome() + " (" + produto.getCodigoBarras() + ")";

}



@Override

public double getPrecoFinal() {

return produto.getPreco();

}



@Override

public void exibirInfo() {

System.out.println("Produto: " + produto.getNome() + " | Preço: R$ " + produto.getPreco());

}

}