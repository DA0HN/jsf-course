package com.gabriel.beans;

import com.gabriel.domain.Product;
import com.gabriel.services.IProductService;

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
@Named("stock")
@SessionScoped
public class StockBean implements Serializable {

  private final IProductService productService;

  private List<Product> products;

  @Inject
  public StockBean(@Named("service") IProductService productService) {
    this.productService = productService;
    this.products = new ArrayList<>();
  }

  public List<Product> getProducts() {
    return products;
  }

  public void initialize() {
    if(Objects.nonNull(this.productService)) {
      this.products = Objects.requireNonNullElse(
        this.productService.findAll(),
        new ArrayList<>()
      );
    }
  }

}
