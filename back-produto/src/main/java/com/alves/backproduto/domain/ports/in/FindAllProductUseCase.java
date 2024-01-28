package com.alves.backproduto.domain.ports.in;

import com.alves.backproduto.domain.model.Product;

import java.util.List;

public interface FindAllProductUseCase {

    List<Product> findAll();
}
