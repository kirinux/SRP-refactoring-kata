package com.mirakl.kata.srp.product;

class ProductService {

    private final ProductRepository productRepository;
    private final CatalogRepository catalogRepository;
    private final FakeIAMService fakeIAMService;
    private final UserService userService;

    private final KafkaEventService kafkaEventService;

    ProductService(final ProductRepository productRepository, final CatalogRepository catalogRepository, final FakeIAMService fakeIAMService, final UserService userService, final KafkaEventService kafkaEventService) {
        this.productRepository = productRepository;
        this.catalogRepository = catalogRepository;
        this.fakeIAMService = fakeIAMService;
        this.userService = userService;
        this.kafkaEventService = kafkaEventService;
    }


    public void createProduct(Product product) {
        if (!fakeIAMService.isAllowedToCreateProduct(userService.getCurrentUser())) {
            throw new RuntimeException();
        }

        productRepository.createProduct(product);
        if (fakeIAMService.isAllowedToUpdateCatalog(userService.getCurrentUser())) {
            catalogRepository.update(product);
        }
        kafkaEventService.sendEvent(new NewProductEvent(product));
    }

    public Product getProduct(String id) {
        if (!fakeIAMService.isAllowedToGetProduct(userService.getCurrentUser())) {
            throw new RuntimeException();
        }
        final Product product = productRepository.getProduct(id);
        if (product != null) {
            if (fakeIAMService.isAllowedToUpdateCatalog(userService.getCurrentUser())) {
                catalogRepository.update(product);
            }
            kafkaEventService.sendEvent(new NewProductEvent(product));
        } else {
            kafkaEventService.sendEvent(new ProductNotFound(product));
        }
        return product;
    }

    public void deleteProduct(String id) {
        if (!fakeIAMService.isAllowedToGetProduct(userService.getCurrentUser())) {
            throw new RuntimeException();
        }
        boolean contained = catalogRepository.contains(id);
        if (contained && fakeIAMService.isAllowedToUpdateCatalog(userService.getCurrentUser())) {
            productRepository.deleteProduct(id);
            kafkaEventService.sendEvent(new ProductDeletedEvent(id));
        }

    }


}
