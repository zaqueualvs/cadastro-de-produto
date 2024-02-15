package com.alves.backproduto.adapters.out.databases.h2.adapters;

import com.alves.backproduto.adapters.out.databases.h2.entity.ProductEntity;
import com.alves.backproduto.adapters.out.databases.h2.mapper.ProductPersistenceMapper;
import com.alves.backproduto.adapters.out.databases.h2.repository.ProductRepository;
import com.alves.backproduto.application.ports.out.PagedSearchPort;
import com.alves.backproduto.commons.customannotations.PersistenceAdapter;
import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.domain.model.ProductPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

@PersistenceAdapter
public class PagedSearchAdapter implements PagedSearchPort {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPersistenceMapper productPersistenceMapper;

    @Override
    public ProductPage PagedSearch(Integer page, Integer pageSize) {
        Page<ProductEntity> productsPage = productRepository.findAll(PageRequest.of(page, pageSize));
        List<Product> products = productsPage.stream()
                .map(productPersistenceMapper::toDomain)
                .collect(Collectors.toList());

        return new ProductPage(products, productsPage.getTotalElements(), productsPage.getTotalPages());
    }
}
