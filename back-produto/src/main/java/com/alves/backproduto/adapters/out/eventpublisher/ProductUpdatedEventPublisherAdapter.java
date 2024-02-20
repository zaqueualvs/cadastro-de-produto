package com.alves.backproduto.adapters.out.eventpublisher;

import com.alves.backproduto.application.ports.out.event.ProductUpdatedEventPublisher;
import com.alves.backproduto.commons.customannotations.EventPublisherAdapter;
import com.alves.backproduto.domain.event.ProductUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;


@RequiredArgsConstructor
@EventPublisherAdapter
public class ProductUpdatedEventPublisherAdapter implements ProductUpdatedEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void publisheEvent(ProductUpdatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
