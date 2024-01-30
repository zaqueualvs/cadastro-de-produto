package com.alves.backproduto.adapters.out.h2.adapters;

import com.alves.backproduto.commons.customannotations.PersistenceAdapter;
import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.application.ports.out.FindAllProductPort;
import com.alves.backproduto.adapters.out.h2.mapper.ProductPersistenceMapper;
import com.alves.backproduto.adapters.out.h2.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@PersistenceAdapter
@AllArgsConstructor
@NoArgsConstructor
public class FindAllProductAdapter implements FindAllProductPort {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPersistenceMapper productPersistenceMapper;

    @Override
    public List<Product> findAll() {
        List<Product> products = productPersistenceMapper.toDomainList(productRepository.findAll());
        return products;
    }
}
