package com.alves.backproduto.application.ports.out;

import com.alves.backproduto.domain.model.Product;

public interface UpdateProductPort {

    Product update(Product product);
}
