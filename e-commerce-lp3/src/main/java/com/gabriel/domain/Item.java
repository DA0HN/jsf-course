package com.gabriel.domain;

import javax.faces.annotation.ManagedProperty;
import java.util.Objects;

/**
 * @author daohn
 * @since 21/06/2021
 */
public class Item {

  @ManagedProperty(value = "#{item.product}")
  private Product product;
  private Integer quantity;

  public Item(Product product, Integer quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Item() {
  }

  public static Item createItemWithZeroQuantidade(Product product) {
    return new Item(product, 1);
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public void incrementQuantity() {
    this.quantity += 1;
  }

  public Double subtotal() {
    return this.quantity * this.product.getPrice().doubleValue();
  }

  @Override public boolean equals(Object o) {
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return product.equals(item.product) && quantity.equals(item.quantity);
  }

  @Override public int hashCode() {
    return Objects.hash(product, quantity);
  }
}

