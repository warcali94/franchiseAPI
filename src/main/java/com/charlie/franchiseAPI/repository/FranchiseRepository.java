package com.charlie.franchiseAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.charlie.franchiseAPI.model.Franchise;

@Repository
/**
 * FranchiseRepository
 */
public interface FranchiseRepository extends MongoRepository<Franchise,String> {
    boolean existsByName(String name);
    // boolean getName(String name);
}
