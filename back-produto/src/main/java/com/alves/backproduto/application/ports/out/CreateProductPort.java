package com.alves.backproduto.application.ports.out;

import com.alves.backproduto.domain.model.Product;

public interface CreateProductPort {

    Product createProduct(Product product);
}
