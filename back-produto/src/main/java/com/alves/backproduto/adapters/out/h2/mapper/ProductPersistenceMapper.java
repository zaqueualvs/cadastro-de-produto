package com.alves.backproduto.adapters.out.h2.mapper;

import com.alves.backproduto.adapters.out.h2.entity.ProductEntity;
import com.alves.backproduto.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {
    ProductPersistenceMapper INSTANCE = Mappers.getMapper(ProductPersistenceMapper.class);
    ProductEntity toEntity(Product product);

    Product toDomain(ProductEntity productEntity);

    List<Product> toDomainList(List<ProductEntity> productEntities);
}
