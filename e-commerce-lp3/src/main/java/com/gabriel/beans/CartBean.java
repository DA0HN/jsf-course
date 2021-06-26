package com.gabriel.beans;

import com.gabriel.domain.Item;
import com.gabriel.domain.Product;
import com.gabriel.services.IProductService;

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
@Named("cart")
@SessionScoped
public class CartBean implements Serializable {

  private final IProductService service;
  private final Map<Product, Item> itens;

  @Inject
  public CartBean(@Named("service") IProductService service) {
    this.service = service;
    this.itens = new HashMap<>();
  }

  public List<Item> getItens() {
    return new ArrayList<>(itens.values());
  }

  public String addProdutoInCart(Product product) {

    if(itens.containsKey(product)) {
      var item = itens.get(product);
      item.incrementQuantity();
    }
    else {
      itens.put(product, Item.createItemWithZeroQuantidade(product));
    }
    return "cart?faces-redirect=true";
  }

  public String closePurchase() {

    this.getItens().forEach(item -> {
      var purchaseQuantity = item.getQuantity();
      var produto = item.getProduct();

      produto.updateStock(purchaseQuantity);

      service.save(produto);
    });

    this.itens.clear();

    return "index?faces-redirect=true";
  }

  public String clearCart() {
    this.itens.clear();
    return "index?faces-redirect=true";
  }
}
