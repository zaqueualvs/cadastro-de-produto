package com.alves.backproduto.application.rest.mapper;

import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.application.rest.data.request.ProductRequest;
import com.alves.backproduto.application.rest.data.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductRestMapper {

    @Mapping(target = "id", ignore = true)
    Product toProduct(ProductRequest productRequest);

    ProductResponse toProductCreateResponse(Product product);

    List<ProductResponse> toProductResponseList(List<Product> products);
}
