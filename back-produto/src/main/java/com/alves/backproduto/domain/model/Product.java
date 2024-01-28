package com.alves.backproduto.domain.model;

import lombok.*;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private Long quantity;
    private String description;
}
