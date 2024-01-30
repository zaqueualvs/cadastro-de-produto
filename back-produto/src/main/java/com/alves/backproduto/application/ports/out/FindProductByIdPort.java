package com.alves.backproduto.application.ports.out;

import com.alves.backproduto.domain.model.Product;

import java.util.Optional;

public interface FindProductByIdPort {

    Optional<Product> findById(Long id);
}
