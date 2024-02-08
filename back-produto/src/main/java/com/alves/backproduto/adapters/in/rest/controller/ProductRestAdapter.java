package com.alves.backproduto.adapters.in.rest.controller;

import com.alves.backproduto.adapters.in.rest.data.request.ProductRequest;
import com.alves.backproduto.adapters.in.rest.data.response.ProductResponse;
import com.alves.backproduto.adapters.in.rest.mapper.ProductRestMapper;
import com.alves.backproduto.application.ports.in.*;
import com.alves.backproduto.domain.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/products")
@Tag(name = "product-rest")
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


    @Operation(description = "Cadastra um produto")
    @PostMapping
    public ResponseEntity<ProductResponse> create(
            @RequestBody @Valid ProductRequest productRequest) {
        Product product = productRestMapper.toDomain(productRequest);
        product = createProductUseCase.createProduct(product);
        ProductResponse productResponse = productRestMapper.toResponse(product);
        Link linkAll = linkTo(methodOn(ProductRestAdapter.class)
                .findAll()).withSelfRel();
        productResponse.add(linkAll);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @Operation(description = "Busca todos os produtos")
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<Product> products = findAllProductUseCase.findAll();
        List<ProductResponse> productResponses = productRestMapper.toResponseList(products);
        for (ProductResponse productResponse : productResponses) {
            Link linkById = linkTo(methodOn(ProductRestAdapter.class).findById(productResponse.getId())).withSelfRel();
            productResponse.add(linkById);
        }
        return ResponseEntity.status(HttpStatus.OK).body(productResponses);
    }

    @Operation(description = "Busca um produto por Id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Product product = findProductByIdUseCase.findById(id);
        ProductResponse productResponse = productRestMapper.toResponse(product);
        Link linkAll = linkTo(methodOn(ProductRestAdapter.class).findAll()).withRel("product list");
        productResponse.add(linkAll);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @Operation(description = "Remove um produto por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        deleteProductByIdUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(description = "Atualiza um produto")
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id,
                                                  @RequestBody @Valid ProductRequest productRequest) {
        Product product = findProductByIdUseCase.findById(id);
        Product productReq = productRestMapper.toDomain(productRequest);
        BeanUtils.copyProperties(productReq, product, "id");
        product = updateProductUseCase.update(product);
        ProductResponse productResponse = productRestMapper.toResponse(product);
        Link linkAll = linkTo(methodOn(ProductRestAdapter.class).findAll()).withRel("Product List");
        productResponse.add(linkAll);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }
}
