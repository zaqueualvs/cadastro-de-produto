package com.alves.backproduto.domain.service;

import com.alves.backproduto.application.ports.in.PagedSearchUseCase;
import com.alves.backproduto.application.ports.out.PagedSearchPort;
import com.alves.backproduto.commons.customannotations.UseCase;
import com.alves.backproduto.domain.model.ProductPage;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class PagedSearchService implements PagedSearchUseCase {

    private final PagedSearchPort pagedSearchPort;

    @Override
    public ProductPage PagedSearch(Integer page, Integer pageSize) {
        return pagedSearchPort.PagedSearch(page, pageSize);
    }
}
