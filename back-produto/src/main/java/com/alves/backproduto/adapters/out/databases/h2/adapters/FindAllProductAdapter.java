package com.alves.backproduto.adapters.out.databases.h2.adapters;

import com.alves.backproduto.adapters.out.databases.h2.mapper.ProductPersistenceMapper;
import com.alves.backproduto.adapters.out.databases.h2.repository.ProductRepository;
import com.alves.backproduto.application.ports.out.FindAllProductPort;
import com.alves.backproduto.commons.customannotations.PersistenceAdapter;
import com.alves.backproduto.domain.model.Product;
import lombok.RequiredArgsConstructor;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindAllProductAdapter implements FindAllProductPort {

    private final ProductRepository productRepository;
    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public List<Product> findAll() {
        List<Product> products = productPersistenceMapper.toDomainList(productRepository.findAll());
        return products;
    }
}
