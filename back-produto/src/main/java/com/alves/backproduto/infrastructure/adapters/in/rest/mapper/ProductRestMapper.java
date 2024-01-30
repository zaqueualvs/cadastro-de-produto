package com.alves.backproduto.infrastructure.adapters.in.rest.mapper;

import com.alves.backproduto.infrastructure.adapters.in.rest.data.request.ProductRequest;
import com.alves.backproduto.infrastructure.adapters.in.rest.data.response.ProductResponse;
import com.alves.backproduto.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductRestMapper {

    @Mapping(target = "id", ignore = true)
    Product toDomain(ProductRequest productRequest);

    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponseList(List<Product> products);
}
