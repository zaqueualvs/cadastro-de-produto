package com.alves.backproduto.adapters.out.databases.h2.adapters;

import com.alves.backproduto.adapters.out.databases.h2.repository.ProductRepository;
import com.alves.backproduto.application.ports.out.DeleteProductByIdPort;
import com.alves.backproduto.commons.customannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class DeleteProductByIdAdapter implements DeleteProductByIdPort {

    private final ProductRepository productRepository;
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
