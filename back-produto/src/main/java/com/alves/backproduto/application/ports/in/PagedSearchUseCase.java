package com.alves.backproduto.application.ports.in;

import com.alves.backproduto.domain.model.ProductPage;

public interface PagedSearchUseCase {

    ProductPage PagedSearch(Integer page, Integer pageSize);
}
