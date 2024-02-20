package com.alves.backproduto.domain.event;

import java.time.LocalDateTime;

public class ProductCreatedEvent {
    private final Long id;
    private final LocalDateTime date;

    public ProductCreatedEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
