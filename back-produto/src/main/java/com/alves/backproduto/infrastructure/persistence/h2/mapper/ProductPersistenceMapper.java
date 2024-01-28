package com.alves.backproduto.infrastructure.persistence.h2.mapper;

import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.infrastructure.persistence.h2.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {
    ProductPersistenceMapper INSTANCE = Mappers.getMapper(ProductPersistenceMapper.class);
    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);

    List<Product> toProductList(List<ProductEntity> productEntities);
}
