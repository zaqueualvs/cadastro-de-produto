package com.alves.backproduto.application.ports.out;

import com.alves.backproduto.domain.model.Product;

import java.util.List;

public interface FindAllProductPort {

    List<Product> findAll();
}
