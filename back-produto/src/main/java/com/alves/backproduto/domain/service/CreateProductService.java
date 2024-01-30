package com.alves.backproduto.domain.service;

import com.alves.backproduto.commons.customannotations.UseCase;
import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.application.ports.in.CreateProductUseCase;
import com.alves.backproduto.application.ports.out.CreateProductPort;

@UseCase
public class CreateProductService implements CreateProductUseCase {
    private final CreateProductPort createProductPort;

    public CreateProductService(CreateProductPort createProductPort) {
        this.createProductPort = createProductPort;
    }

    @Override
    public Product createProduct(Product product) {
        return createProductPort.createProduct(product);
    }
}
