package com.alves.backproduto.domain.service;

import com.alves.backproduto.application.ports.out.event.ProductCreatedEventPublisher;
import com.alves.backproduto.commons.customannotations.UseCase;
import com.alves.backproduto.domain.event.ProductCreatedEvent;
import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.application.ports.in.CreateProductUseCase;
import com.alves.backproduto.application.ports.out.CreateProductPort;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {
    private final CreateProductPort createProductPort;
    private final ProductCreatedEventPublisher productCreatedEventPublisher;

    @Override
    public Product createProduct(Product product) {
        product = createProductPort.createProduct(product);
        productCreatedEventPublisher.publisheEvent(new ProductCreatedEvent(product.getId()));
        return product;
    }
}
