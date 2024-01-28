package com.alves.backproduto.domain.service;

import com.alves.backproduto.domain.ports.in.DeleteProductByIdUseCase;
import com.alves.backproduto.domain.ports.out.DeleteProductByIdPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;

@Component
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
