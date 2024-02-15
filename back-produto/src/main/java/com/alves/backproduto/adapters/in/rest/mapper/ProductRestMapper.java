package com.alves.backproduto.adapters.in.rest.mapper;

import com.alves.backproduto.adapters.in.rest.data.request.ProductRequest;
import com.alves.backproduto.adapters.in.rest.data.response.ProductPageResponse;
import com.alves.backproduto.adapters.in.rest.data.response.ProductResponse;
import com.alves.backproduto.domain.model.Product;
import com.alves.backproduto.domain.model.ProductPage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProductRestMapper {

    @Mapping(target = "id", ignore = true)
    Product toDomain(ProductRequest productRequest);

    ProductResponse toResponse(Product product);


    List<ProductResponse> toResponseList(List<Product> products);

    default ProductPageResponse toProductPageResponse(ProductPage productPage) {
        List<ProductResponse> productsResponse = productPage.getProducts()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return new ProductPageResponse(productsResponse,
                productPage.getTotalElements(),
                productPage.getTotalPages()
        );

    }

}
