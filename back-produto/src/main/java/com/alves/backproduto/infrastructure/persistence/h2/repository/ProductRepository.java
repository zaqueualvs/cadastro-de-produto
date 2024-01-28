package com.alves.backproduto.infrastructure.persistence.h2.repository;

import com.alves.backproduto.infrastructure.persistence.h2.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
