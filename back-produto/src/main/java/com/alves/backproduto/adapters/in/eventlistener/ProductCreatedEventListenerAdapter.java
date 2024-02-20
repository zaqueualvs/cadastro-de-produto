package com.alves.backproduto.adapters.in.eventlistener;

import com.alves.backproduto.application.ports.in.event.ProductCreatedEventListener;
import com.alves.backproduto.commons.customannotations.EventListenerAdapter;
import com.alves.backproduto.domain.event.ProductCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

@EventListenerAdapter
@Slf4j
public class ProductCreatedEventListenerAdapter implements ProductCreatedEventListener {

    @EventListener
    @Override
    public void handle(ProductCreatedEvent event) {
        log.info("Product created with id " + event.getId() + " at " + event.getDate());
    }
}
