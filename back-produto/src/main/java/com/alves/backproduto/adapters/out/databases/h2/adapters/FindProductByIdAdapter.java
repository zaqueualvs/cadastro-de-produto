package com.alves.backproduto.adapters.out.databases.h2.adapters;

import com.alves.backproduto.adapters.out.databases.h2.entity.ProductEntity;
import com.alves.backproduto.adapters.out.databases.h2.mapper.ProductPersistenceMapper;
import com.alves.backproduto.adapters.out.databases.h2.repository.ProductRepository;
import com.alves.backproduto.application.ports.out.FindProductByIdPort;
import com.alves.backproduto.commons.customannotations.PersistenceAdapter;
import com.alves.backproduto.domain.model.Product;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindProductByIdAdapter implements FindProductByIdPort {

    private final ProductRepository productRepository;
    private final ProductPersistenceMapper productPersistenceMapper;

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
