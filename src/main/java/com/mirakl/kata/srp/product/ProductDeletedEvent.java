package com.mirakl.kata.srp.product;

class ProductDeletedEvent extends NewProductEvent {
    public ProductDeletedEvent(final String id) {
        super(null);
    }
}
