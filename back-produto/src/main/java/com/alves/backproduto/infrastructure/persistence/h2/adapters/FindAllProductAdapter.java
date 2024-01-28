package com.alves.backproduto.infrastructure.persistence.h2.adapters;

import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.domain.ports.out.FindAllProductPort;
import com.alves.backproduto.infrastructure.persistence.h2.mapper.ProductPersistenceMapper;
import com.alves.backproduto.infrastructure.persistence.h2.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class FindAllProductAdapter implements FindAllProductPort {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPersistenceMapper productPersistenceMapper;

    @Override
    public List<Product> findAll() {
        List<Product> products = productPersistenceMapper.toProductList(productRepository.findAll());
        return products;
    }
}
