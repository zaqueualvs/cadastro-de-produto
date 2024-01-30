package com.alves.backproduto.infrastructure.adapters.in.rest.data.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotBlank
    private String name;
    @NotNull
    @PositiveOrZero
    private Long quantity;
    private String description;
}
