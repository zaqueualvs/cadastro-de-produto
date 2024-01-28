package com.alves.backproduto.infrastructure.persistence.h2.adapters;

import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.domain.ports.out.UpdateProductPort;
import com.alves.backproduto.infrastructure.persistence.h2.entity.ProductEntity;
import com.alves.backproduto.infrastructure.persistence.h2.mapper.ProductPersistenceMapper;
import com.alves.backproduto.infrastructure.persistence.h2.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductAdapter implements UpdateProductPort {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPersistenceMapper productPersistenceMapper;

    @Override
    public void update(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toProductEntity(product);
        productRepository.save(productEntity);
    }
}
