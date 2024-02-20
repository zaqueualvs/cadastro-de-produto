package com.alves.backproduto.adapters.in.eventlistener;

import com.alves.backproduto.application.ports.in.event.ProductUpdatedEventListener;
import com.alves.backproduto.commons.customannotations.EventListenerAdapter;
import com.alves.backproduto.commons.customannotations.EventPublisherAdapter;
import com.alves.backproduto.domain.event.ProductUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

@EventListenerAdapter
@Slf4j
public class ProductUpdatedEventListenerAdapter implements ProductUpdatedEventListener {

    @EventListener
    @Override
    public void handle(ProductUpdatedEvent event) {
        log.info("Product with id " + event.getId() + " updated at: " + event.getDate());
    }
}
