package com.alves.backproduto.adapters.out.eventpublisher;

import com.alves.backproduto.domain.event.ProductUpdatedEvent;

public interface ProductUpdatedEventPublisherAdapter {

    void publisheEvent(ProductUpdatedEvent event);
}
