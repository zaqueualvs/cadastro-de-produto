package com.alves.backproduto.application.ports.out.event;

import com.alves.backproduto.domain.event.ProductCreatedEvent;
import com.alves.backproduto.domain.event.ProductUpdatedEvent;

public interface ProductCreatedEventPublisher {
    void publisheEvent(ProductCreatedEvent event);
}
