package com.alves.backproduto.domain.service;

import com.alves.backproduto.commons.customannotations.UseCase;
import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.application.ports.in.FindAllProductUseCase;
import com.alves.backproduto.application.ports.out.FindAllProductPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllProductService implements FindAllProductUseCase {

    private final FindAllProductPort findAllProductPort;

    @Override
    public List<Product> findAll() {
        return findAllProductPort.findAll();
    }
}
