package com.alves.backproduto.domain.service;

import com.alves.backproduto.commons.customannotations.UseCase;
import com.alves.backproduto.application.ports.in.DeleteProductByIdUseCase;
import com.alves.backproduto.application.ports.out.DeleteProductByIdPort;

@UseCase
public class DeleteProductByIdService implements DeleteProductByIdUseCase {
    private final DeleteProductByIdPort deleteProductByIdPort;

    public DeleteProductByIdService(DeleteProductByIdPort deleteProductByIdPort) {
        this.deleteProductByIdPort = deleteProductByIdPort;
    }

    @Override
    public void deleteById(Long id) {
        deleteProductByIdPort.deleteById(id);
    }
}
