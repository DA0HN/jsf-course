package com.gabriel.services;

import com.gabriel.domain.Produto;

import java.util.List;

/**
 * @author daohn
 * @since 21/06/2021
 */
public interface IProdutoService {
  void salvar(Produto produto);
  List<Produto> buscarTodos();
}
