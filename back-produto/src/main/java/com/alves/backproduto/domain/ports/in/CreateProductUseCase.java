package com.alves.backproduto.domain.ports.in;

import com.alves.backproduto.domain.model.Product;

public interface CreateProductUseCase {

    Product createProduct(Product product);
}
