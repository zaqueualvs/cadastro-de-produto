package com.alves.backproduto.application.ports.in.event;

import com.alves.backproduto.domain.event.ProductUpdatedEvent;

public interface ProductUpdatedEventListener {

    void publisheEvent(ProductUpdatedEvent event);
}
