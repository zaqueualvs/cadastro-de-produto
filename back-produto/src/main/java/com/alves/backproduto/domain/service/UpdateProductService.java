package com.alves.backproduto.domain.service;

import com.alves.backproduto.application.ports.in.UpdateProductUseCase;
import com.alves.backproduto.application.ports.out.UpdateProductPort;
import com.alves.backproduto.application.ports.out.event.ProductUpdatedEventPublisher;
import com.alves.backproduto.commons.customannotations.UseCase;
import com.alves.backproduto.domain.event.ProductUpdatedEvent;
import com.alves.backproduto.domain.model.Product;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateProductService implements UpdateProductUseCase {

    private final UpdateProductPort updateProductPort;
    private final ProductUpdatedEventPublisher productUpdatedEventPublisher;

    @Override
    public Product update(Product product) {
        updateProductPort.update(product);
        productUpdatedEventPublisher.publisheEvent(new ProductUpdatedEvent(product.getId()));
        return product;
    }
}
