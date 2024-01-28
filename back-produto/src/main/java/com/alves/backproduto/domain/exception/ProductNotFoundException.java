package com.alves.backproduto.domain.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super(String.format("Produto com id %d não encontrado!", id));
    }
}
