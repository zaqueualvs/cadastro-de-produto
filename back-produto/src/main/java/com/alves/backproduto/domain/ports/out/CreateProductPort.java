package com.alves.backproduto.domain.ports.out;

import com.alves.backproduto.domain.model.Product;

public interface CreateProductPort {

    Product createProduct(Product product);
}
