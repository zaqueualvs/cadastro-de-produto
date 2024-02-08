package com.alves.backproduto.adapters.out.databases.h2.adapters;

import com.alves.backproduto.commons.customannotations.PersistenceAdapter;
import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.application.ports.out.FindProductByIdPort;
import com.alves.backproduto.adapters.out.databases.h2.entity.ProductEntity;
import com.alves.backproduto.adapters.out.databases.h2.mapper.ProductPersistenceMapper;
import com.alves.backproduto.adapters.out.databases.h2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@PersistenceAdapter
public class FindProductByIdAdapter implements FindProductByIdPort {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Optional<Product> findById(Long id) {
        Optional<ProductEntity> productEntityO = productRepository.findById(id);
        if (productEntityO.isEmpty()) {
            return Optional.empty();
        }
        ProductEntity productEntity = productEntityO.get();
        Product product = productPersistenceMapper.toDomain(productEntity);
        return Optional.of(product);
    }
}
