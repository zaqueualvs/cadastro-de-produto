package com.alves.backproduto.domain.ports.in;

import com.alves.backproduto.domain.model.Product;

public interface UpdateProductUseCase {

    void update(Product product);
}
