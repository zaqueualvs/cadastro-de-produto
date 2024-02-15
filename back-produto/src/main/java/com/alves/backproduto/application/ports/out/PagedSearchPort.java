package com.alves.backproduto.application.ports.out;

import com.alves.backproduto.domain.model.ProductPage;

public interface PagedSearchPort {

    ProductPage PagedSearch(Integer page, Integer pageSize);
}
