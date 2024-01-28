package com.alves.backproduto.domain.ports.in;

import com.alves.backproduto.domain.model.Product;

import java.util.Optional;

public interface FindProductByIdUseCase {

    Product findById(Long id);
}
