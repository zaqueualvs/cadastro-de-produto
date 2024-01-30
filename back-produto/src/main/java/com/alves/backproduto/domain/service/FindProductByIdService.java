package com.alves.backproduto.domain.service;

import com.alves.backproduto.commons.customannotations.UseCase;
import com.alves.backproduto.domain.exception.ProductNotFoundException;
import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.application.ports.in.FindProductByIdUseCase;
import com.alves.backproduto.application.ports.out.FindProductByIdPort;

@UseCase
public class FindProductByIdService implements FindProductByIdUseCase {

    private final FindProductByIdPort findProductByIdPort;

    public FindProductByIdService(FindProductByIdPort findProductByIdPort) {
        this.findProductByIdPort = findProductByIdPort;
    }

    @Override
    public Product findById(Long id) {
        return findProductByIdPort.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
