package com.alves.backproduto.domain.service;

import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.domain.ports.in.CreateProductUseCase;
import com.alves.backproduto.domain.ports.out.CreateProductPort;
import org.springframework.stereotype.Component;

@Component
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
