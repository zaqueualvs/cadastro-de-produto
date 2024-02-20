package com.alves.backproduto.application.ports.in;

import com.alves.backproduto.domain.model.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
}
