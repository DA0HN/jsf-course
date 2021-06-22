package com.sales.beans;

import com.sales.entities.Item;
import com.sales.entities.Produto;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class CarrinhoBean implements Serializable {
  private List<Item> itens;

  public CarrinhoBean() {
    itens = new ArrayList<>();
  }

  public List<Item> getItens() {
    return itens;
  }

  public void setItens(List<Item> itens) {
    this.itens = itens;
  }

  public String adicionarProdutoNoCarrinho(Produto produto) {
    int indice = existeItem(produto);
    if(indice == -1) {
      itens.add(new Item(produto, 1));
    }
    else {
      int qtde = this.itens.get(indice).getQuantidade() + 1;
      this.itens.get(indice).setQuantidade(qtde);
    }

    return "cart?faces-redirect=true";
  }

  private int existeItem(Produto produto) {
    for(int i = 0; i < itens.size(); i++) {
      if(itens.get(i).getProduto().getId() == produto.getId()) {
        return i;
      }
    }
    return -1;

  }

}
