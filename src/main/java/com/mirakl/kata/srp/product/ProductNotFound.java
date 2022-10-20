package com.mirakl.kata.srp.product;

class ProductNotFound extends NewProductEvent {
    public ProductNotFound(final Product product) {
        super(product);
    }
}
