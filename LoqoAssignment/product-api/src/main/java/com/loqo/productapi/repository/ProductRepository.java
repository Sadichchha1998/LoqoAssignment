package com.loqo.productapi.repository;




import org.springframework.data.mongodb.repository.MongoRepository;

import com.loqo.productapi.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
