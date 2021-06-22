package com.sales.entities;

/**
 * @author daohn
 * @since 21/06/2021
 */
public class Item {

  private Produto produto;
  private Integer quantidade;

  public Item(Produto produto, Integer quantidade) {
    this.produto = produto;
    this.quantidade = quantidade;
  }

  public Item() {
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

}

