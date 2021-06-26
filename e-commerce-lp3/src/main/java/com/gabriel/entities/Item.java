package com.gabriel.entities;

import javax.faces.annotation.ManagedProperty;
import java.util.Objects;

/**
 * @author daohn
 * @since 21/06/2021
 */
public class Item {

  @ManagedProperty(value = "#{item.produto}")
  private Produto produto;
  private Integer quantidade;

  public Item(Produto produto, Integer quantidade) {
    this.produto = produto;
    this.quantidade = quantidade;
  }

  public Item() {
  }

  public static Item createItemWithZeroQuantidade(Produto produto) {
    return new Item(produto, 1);
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

  public void incrementQuantidade() {
    this.quantidade += 1;
  }

  public Double valorTotal() {
    return this.quantidade * this.produto.getPreco().doubleValue();
  }

  @Override public boolean equals(Object o) {
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return produto.equals(item.produto) && quantidade.equals(item.quantidade);
  }

  @Override public int hashCode() {
    return Objects.hash(produto, quantidade);
  }
}

