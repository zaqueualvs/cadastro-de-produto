package com.alves.backproduto.domain.service;

import com.alves.backproduto.commons.customannotations.UseCase;
import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.application.ports.in.UpdateProductUseCase;
import com.alves.backproduto.application.ports.out.UpdateProductPort;

@UseCase
public class UpdateProductService implements UpdateProductUseCase {

    private final UpdateProductPort updateProductPort;

    public UpdateProductService(UpdateProductPort updateProductPort) {
        this.updateProductPort = updateProductPort;
    }

    @Override
    public Product update(Product product) {
        return updateProductPort.update(product);
    }
}
