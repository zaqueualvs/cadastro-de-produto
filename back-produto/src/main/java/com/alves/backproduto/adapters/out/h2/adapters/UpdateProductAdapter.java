package com.alves.backproduto.adapters.out.h2.adapters;

import com.alves.backproduto.commons.customannotations.PersistenceAdapter;
import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.application.ports.out.UpdateProductPort;
import com.alves.backproduto.adapters.out.h2.entity.ProductEntity;
import com.alves.backproduto.adapters.out.h2.mapper.ProductPersistenceMapper;
import com.alves.backproduto.adapters.out.h2.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@PersistenceAdapter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductAdapter implements UpdateProductPort {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPersistenceMapper productPersistenceMapper;

    @Override
    public void update(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toEntity(product);
        productRepository.save(productEntity);
    }
}
