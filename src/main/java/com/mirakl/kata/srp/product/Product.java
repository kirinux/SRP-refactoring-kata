package com.mirakl.kata.srp.product;

class Product {

    private String id;
    private int price;
    private String description;

    String getId() {
        return id;
    }

    void setId(final String id) {
        this.id = id;
    }

    int getPrice() {
        return price;
    }

    void setPrice(final int price) {
        this.price = price;
    }

    String getDescription() {
        return description;
    }

    void setDescription(final String description) {
        this.description = description;
    }
}
