package com.alves.backproduto.adapters.out.eventpublisher;

import com.alves.backproduto.application.ports.out.event.ProductCreatedEventPublisher;
import com.alves.backproduto.commons.customannotations.EventPublisherAdapter;
import com.alves.backproduto.domain.event.ProductCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
@EventPublisherAdapter
public class ProductCreatedEventPublisherAdapter implements ProductCreatedEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void publisheEvent(ProductCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
