package com.gabriel.beans;

import com.gabriel.domain.Produto;
import com.gabriel.services.IProdutoService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author daohn
 * @since 21/06/2021
 */
@Named("estoque")
@SessionScoped
public class EstoqueBean implements Serializable {

  private final IProdutoService produtoService;

  private List<Produto> produtos;

  @Inject
  public EstoqueBean(@Named("produtoService") IProdutoService produtoService) {
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
