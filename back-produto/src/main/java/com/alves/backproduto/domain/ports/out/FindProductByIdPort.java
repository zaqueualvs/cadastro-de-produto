package com.alves.backproduto.domain.ports.out;

import com.alves.backproduto.domain.model.Product;

import java.util.Optional;

public interface FindProductByIdPort {

    Optional<Product> findById(Long id);
}
