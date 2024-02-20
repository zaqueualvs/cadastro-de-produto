package com.alves.backproduto.adapters.out.eventpublisher;

import com.alves.backproduto.domain.event.ProductCreatedEvent;

public interface ProductCreatedEventPublisherAdapter {
    void publisheEvent(ProductCreatedEvent event);
}
