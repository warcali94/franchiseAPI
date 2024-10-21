package com.charlie.franchiseAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.charlie.franchiseAPI.model.Branch;

@Repository

public interface BranchRepository extends MongoRepository<Branch, String> {

}
