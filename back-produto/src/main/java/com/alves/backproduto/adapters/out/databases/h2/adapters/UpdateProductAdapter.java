package com.alves.backproduto.adapters.out.databases.h2.adapters;

import com.alves.backproduto.adapters.out.databases.h2.entity.ProductEntity;
import com.alves.backproduto.adapters.out.databases.h2.mapper.ProductPersistenceMapper;
import com.alves.backproduto.adapters.out.databases.h2.repository.ProductRepository;
import com.alves.backproduto.application.ports.out.UpdateProductPort;
import com.alves.backproduto.commons.customannotations.PersistenceAdapter;
import com.alves.backproduto.domain.model.Product;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UpdateProductAdapter implements UpdateProductPort {

    private final ProductRepository productRepository;
    private final ProductPersistenceMapper productPersistenceMapper;
    @Override
    public Product update(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toEntity(product);
        productEntity = productRepository.save(productEntity);
        product = productPersistenceMapper.toDomain(productEntity);
        return product;
    }
}
