package com.alves.backproduto.adapters.in.eventlistener;

import com.alves.backproduto.domain.event.ProductUpdatedEvent;

public interface ProductUpdatedEventListenerAdapter {

    void handle(ProductUpdatedEvent event);
}
