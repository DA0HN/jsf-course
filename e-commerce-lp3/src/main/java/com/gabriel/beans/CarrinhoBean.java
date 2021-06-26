package com.gabriel.beans;

import com.gabriel.entities.Item;
import com.gabriel.entities.Produto;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author daohn
 * @since 21/06/2021
 */
@Named
@SessionScoped
public class CarrinhoBean implements Serializable {
  private Map<Produto, Item> itens;

  public CarrinhoBean() {
    itens = new HashMap<>();
  }

  public List<Item> getItens() {
    return new ArrayList<>(itens.values());
  }

  public void setItens(Map<Produto, Item> itens) {
    this.itens = itens;
  }

  public String addProdutoInCart(Produto produto) {

    if(itens.containsKey(produto)) {
      var item = itens.get(produto);
      item.incrementQuantidade();
    }
    else {
      itens.put(produto,Item.createItemWithZeroQuantidade(produto));
    }
    return "cart?faces-redirect=true";
  }
}
