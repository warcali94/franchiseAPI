package com.charlie.franchiseAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.charlie.franchiseAPI.model.Product;

@Repository

public interface ProductRepository extends MongoRepository<Product, String> {

}
