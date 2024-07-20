package com.loqo.productapi.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.loqo.productapi.model.Product;
import com.loqo.productapi.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final MongoTemplate mongoTemplate;

    public ProductService(ProductRepository productRepository, MongoTemplate mongoTemplate) {
        this.productRepository = productRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public List<Product> getFilteredAndSortedProducts(String category, Double minPrice, Double maxPrice,
                                                      Boolean inStock, String sortField, String sortOrder) {
        Query query = new Query();
        
        if (category != null) {
            query.addCriteria(Criteria.where("category").is(category));
        }
        
        if (minPrice != null && maxPrice != null) {
            query.addCriteria(Criteria.where("price").gte(minPrice).lte(maxPrice));
        } else if (minPrice != null) {
            query.addCriteria(Criteria.where("price").gte(minPrice));
        } else if (maxPrice != null) {
            query.addCriteria(Criteria.where("price").lte(maxPrice));
        }
        
        if (inStock != null) {
            query.addCriteria(Criteria.where("inStock").is(inStock));
        }
        
        if (sortField != null) {
            Sort.Direction direction = Sort.Direction.ASC;
            if (sortOrder != null && sortOrder.equalsIgnoreCase("desc")) {
                direction = Sort.Direction.DESC;
            }
            query.with(Sort.by(direction, sortField));
        }
        
        return mongoTemplate.find(query, Product.class);
    }
}