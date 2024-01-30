package com.alves.backproduto.adapters.in.rest.controller;

import com.alves.backproduto.adapters.in.rest.data.request.ProductRequest;
import com.alves.backproduto.adapters.in.rest.data.response.ProductResponse;
import com.alves.backproduto.adapters.in.rest.mapper.ProductRestMapper;
import com.alves.backproduto.application.ports.in.*;
import com.alves.backproduto.domain.model.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestAdapter {

    @Autowired
    private CreateProductUseCase createProductUseCase;
    @Autowired
    private FindAllProductUseCase findAllProductUseCase;
    @Autowired
    private DeleteProductByIdUseCase deleteProductByIdUseCase;
    @Autowired
    private FindProductByIdUseCase findProductByIdUseCase;
    @Autowired
    private UpdateProductUseCase updateProductUseCase;
    @Autowired
    private ProductRestMapper productRestMapper;


    @PostMapping
    public ResponseEntity<ProductResponse> save(
            @RequestBody @Valid ProductRequest productRequest) {
        Product product = productRestMapper.toDomain(productRequest);
        product = createProductUseCase.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRestMapper.toResponse(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<Product> products = findAllProductUseCase.findAll();
        List<ProductResponse> productResponses = productRestMapper.toResponseList(products);
        return ResponseEntity.status(HttpStatus.OK).body(productResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Product product = findProductByIdUseCase.findById(id);
        ProductResponse productResponse = productRestMapper.toResponse(product);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }
}
