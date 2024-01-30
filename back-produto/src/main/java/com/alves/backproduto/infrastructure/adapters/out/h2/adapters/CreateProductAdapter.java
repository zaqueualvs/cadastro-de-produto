package com.alves.backproduto.infrastructure.adapters.out.h2.adapters;

import com.alves.backproduto.infrastructure.adapters.out.h2.entity.ProductEntity;
import com.alves.backproduto.infrastructure.adapters.out.h2.mapper.ProductPersistenceMapper;
import com.alves.backproduto.infrastructure.adapters.out.h2.repository.ProductRepository;
import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.application.ports.out.CreateProductPort;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductAdapter implements CreateProductPort {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toEntity(product);
        productEntity = productRepository.save(productEntity);
        return productPersistenceMapper.toDomain(productEntity);
    }
}
