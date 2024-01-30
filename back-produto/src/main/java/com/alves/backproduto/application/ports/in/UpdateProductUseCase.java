package com.alves.backproduto.application.ports.in;

import com.alves.backproduto.domain.model.Product;

public interface UpdateProductUseCase {

    void update(Product product);
}
