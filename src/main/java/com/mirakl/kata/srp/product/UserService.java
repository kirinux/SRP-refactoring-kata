package com.mirakl.kata.srp.product;

class UserService {
    User getCurrentUser() {
        return new User("id", "mytoken", "username");
    }
}
