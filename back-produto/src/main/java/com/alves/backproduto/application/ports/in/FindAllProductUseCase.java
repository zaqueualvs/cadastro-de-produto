package com.alves.backproduto.application.ports.in;

import com.alves.backproduto.domain.model.Product;

import java.util.List;

public interface FindAllProductUseCase {

    List<Product> findAll();
}
