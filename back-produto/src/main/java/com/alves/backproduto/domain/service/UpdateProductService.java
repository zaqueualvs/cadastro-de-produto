package com.alves.backproduto.domain.service;

import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.domain.ports.in.UpdateProductUseCase;
import com.alves.backproduto.domain.ports.out.UpdateProductPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductService implements UpdateProductUseCase {

    private final UpdateProductPort updateProductPort;

    public UpdateProductService(UpdateProductPort updateProductPort) {
        this.updateProductPort = updateProductPort;
    }

    @Override
    public void update(Product product) {
        updateProductPort.update(product);
    }
}
