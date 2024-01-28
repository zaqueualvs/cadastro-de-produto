package com.alves.backproduto.infrastructure.persistence.h2.adapters;

import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.domain.ports.out.FindProductByIdPort;
import com.alves.backproduto.infrastructure.persistence.h2.entity.ProductEntity;
import com.alves.backproduto.infrastructure.persistence.h2.mapper.ProductPersistenceMapper;
import com.alves.backproduto.infrastructure.persistence.h2.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
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
        Product product = productPersistenceMapper.toProduct(productEntity);
        return Optional.of(product);
    }
}
