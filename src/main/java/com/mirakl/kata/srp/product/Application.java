package com.mirakl.kata.srp.product;

class Application {

    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        CatalogRepository catalogRepository = new CatalogRepository();
        FakeIAMService fakeIAMService =new FakeIAMService();
        UserService userService = new UserService();
        KafkaEventService eventService =new KafkaEventService();



        ProductService service = new ProductService(productRepository, catalogRepository, fakeIAMService, userService,eventService);
        Product product = new Product();
        product.setId("id");
        service.createProduct(product);
    }

}
