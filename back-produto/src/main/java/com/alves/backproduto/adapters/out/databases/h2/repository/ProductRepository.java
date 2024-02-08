package com.alves.backproduto.adapters.out.databases.h2.repository;

import com.alves.backproduto.adapters.out.databases.h2.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
