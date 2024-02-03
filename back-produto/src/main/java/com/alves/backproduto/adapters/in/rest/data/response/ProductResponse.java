package com.alves.backproduto.adapters.in.rest.data.response;

import com.alves.backproduto.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse extends RepresentationModel<ProductResponse> implements Serializable {
    private Long id;
    private String name;
    private Long quantity;
    private String description;
}
