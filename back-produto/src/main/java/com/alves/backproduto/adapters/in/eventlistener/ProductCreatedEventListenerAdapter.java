package com.alves.backproduto.adapters.in.eventlistener;

import com.alves.backproduto.domain.event.ProductCreatedEvent;

public interface ProductCreatedEventListenerAdapter {
    void handle(ProductCreatedEvent event);
}
