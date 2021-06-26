package com.gabriel.beans;

import com.gabriel.domain.Item;
import com.gabriel.domain.Produto;
import com.gabriel.services.IProdutoService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
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

  private final IProdutoService service;
  private final Map<Produto, Item> itens;

  @Inject
  public CarrinhoBean(@Named("produtoService") IProdutoService service) {
    this.service = service;
    this.itens = new HashMap<>();
  }

  public List<Item> getItens() {
    return new ArrayList<>(itens.values());
  }

  public String addProdutoInCart(Produto produto) {

    if(itens.containsKey(produto)) {
      var item = itens.get(produto);
      item.incrementQuantity();
    }
    else {
      itens.put(produto, Item.createItemWithZeroQuantidade(produto));
    }
    return "cart?faces-redirect=true";
  }

  public String finalizarCompra() {

    this.getItens().forEach(item -> {
      var purchaseQuantity = item.getQuantity();
      var produto = item.getProduct();

      produto.updateStock(purchaseQuantity);

      service.salvar(produto);
    });

    this.itens.clear();

    return "index?faces-redirect=true";
  }
}
