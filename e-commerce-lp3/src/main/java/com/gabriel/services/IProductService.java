package com.gabriel.services;

import com.gabriel.domain.Product;

import java.util.List;

/**
 * @author daohn
 * @since 21/06/2021
 */
public interface IProductService {
  void save(Product product);
  List<Product> findAll();
}
