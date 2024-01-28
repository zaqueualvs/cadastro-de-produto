package com.alves.backproduto.domain.service;

import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.domain.ports.in.FindAllProductUseCase;
import com.alves.backproduto.domain.ports.out.FindAllProductPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllProductService implements FindAllProductUseCase {

    private final FindAllProductPort findAllProductPort;

    public FindAllProductService(FindAllProductPort findAllProductPort) {
        this.findAllProductPort = findAllProductPort;
    }

    @Override
    public List<Product> findAll() {
        return findAllProductPort.findAll();
    }
}
