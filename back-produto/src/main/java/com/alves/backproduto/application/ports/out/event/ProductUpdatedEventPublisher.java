package com.alves.backproduto.application.ports.out.event;

import com.alves.backproduto.domain.event.ProductUpdatedEvent;

public interface ProductUpdatedEventPublisher {

    void publisheEvent(ProductUpdatedEvent event);
}
