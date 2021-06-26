package com.gabriel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;



/**
 * @author daohn
 * @since 21/06/2021
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="nome")
  private String name;
  @Column(name="descricao")
  private String description;
  @Column(name="preco")
  private BigDecimal price;
  @Column(name="quantidade")
  private Integer quantity;
  @Column(name = "status")
  private Boolean status;

  public Produto() {
  }

  public Produto(
    String name,
    String description,
    BigDecimal price,
    Integer quantity,
    Boolean status
  ) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
    this.status = status;
  }

  public void updateStock(int purchaseQuantity) {

    this.quantity -= purchaseQuantity;

    if(this.quantity <= 0) {
      this.quantity = 0;
    }
    this.updateStatus();
  }

  private void updateStatus() {
    this.status = this.quantity != 0;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String nome) {
    this.name = nome;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String descricao) {
    this.description = descricao;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal preco) {
    this.price = preco;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantidade) {
    this.quantity = quantidade;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  @Override public boolean equals(Object o) {
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;
    Produto produto = (Produto) o;
    return id.equals(produto.id) && name.equals(produto.name) && description.equals(produto.description) && price.equals(
      produto.price) && quantity.equals(produto.quantity) && status.equals(produto.status);
  }

  @Override public int hashCode() {
    return Objects.hash(id, name, description, price, quantity, status);
  }
}
