package com.sales.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table(name = "produto")
public class Produto implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String nome;
  @Column
  private String descricao;
  @Column
  private BigDecimal preco;
  @Column
  private Integer quantidade;
  @Column
  private Boolean status;

  public Produto() {
  }

  public Produto(
    String nome,
    String descricao,
    BigDecimal preco,
    Integer quantidade,
    Boolean status
  ) {
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.quantidade = quantidade;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
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
    return id.equals(produto.id) && nome.equals(produto.nome) && descricao.equals(produto.descricao) && preco.equals(
      produto.preco) && quantidade.equals(produto.quantidade) && status.equals(produto.status);
  }

  @Override public int hashCode() {
    return Objects.hash(id, nome, descricao, preco, quantidade, status);
  }
}
