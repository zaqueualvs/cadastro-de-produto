package com.alves.backproduto.domain.service;

import com.alves.backproduto.domain.model.ProductPage;

public interface PagedSearchService {

    ProductPage PagedSearch(Long page, Long pageSize);
}
