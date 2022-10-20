package com.mirakl.kata.srp.product;

class FakeIAMService {
    boolean isAllowedToCreateProduct(final User currentUser) {
        return true;
    }

    boolean isAllowedToGetProduct(final User currentUser) {
        return true;
    }

    boolean isAllowedToUpdateCatalog(final User currentUser) {
        return true;
    }
}
