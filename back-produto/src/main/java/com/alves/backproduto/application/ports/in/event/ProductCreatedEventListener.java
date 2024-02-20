package com.alves.backproduto.application.ports.in.event;

import com.alves.backproduto.domain.event.ProductCreatedEvent;

public interface ProductCreatedEventListener {
    void handle(ProductCreatedEvent event);
}
