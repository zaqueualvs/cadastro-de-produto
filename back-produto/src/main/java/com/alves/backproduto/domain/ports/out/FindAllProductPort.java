package com.alves.backproduto.domain.ports.out;

import com.alves.backproduto.domain.model.Product;

import java.util.List;

public interface FindAllProductPort {

    List<Product> findAll();
}
