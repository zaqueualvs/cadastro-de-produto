package com.alves.backproduto.adapters.in.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPageResponse implements Serializable {
    private List<ProductResponse> products = new ArrayList<>();
    private Long totalElements;
    private Integer totalPages;
}
