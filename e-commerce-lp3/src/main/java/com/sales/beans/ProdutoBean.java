package com.sales.beans;

import com.sales.entities.Produto;
import com.sales.services.IProdutoService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Named
@SessionScoped
public class ProdutoBean implements Serializable {

  private final IProdutoService produtoService;

  private List<Produto> produtos;

  @Inject
  public ProdutoBean(@Named("produtoService") IProdutoService produtoService) {
    this.produtoService = produtoService;
    this.produtos = new ArrayList<>();
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void initialize() {
    if(Objects.nonNull(this.produtoService)) {
      this.produtos = Objects.requireNonNullElse(
        this.produtoService.buscarTodos(),
        new ArrayList<>()
      );
    }
  }

}
