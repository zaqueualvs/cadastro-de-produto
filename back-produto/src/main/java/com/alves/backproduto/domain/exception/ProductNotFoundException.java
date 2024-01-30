package com.alves.backproduto.domain.exception;

public class ProductNotFoundException extends DomainException {

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(Long id) {
        this(String.format("Não existe um cadastro de produto com código %d", id));
    }

}
