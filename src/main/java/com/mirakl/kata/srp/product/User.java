package com.mirakl.kata.srp.product;

/**
 * technical user of auth and IAM
 */
class User {

    private final String authId;
    private final String token;

    User(final String authId, final String token, final String userName) {
        this.authId = authId;
        this.token = token;
        this.userName = userName;
    }

    private final String userName;


}
