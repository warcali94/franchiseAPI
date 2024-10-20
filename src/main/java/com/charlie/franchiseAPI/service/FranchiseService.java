package com.charlie.franchiseAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlie.franchiseAPI.model.Franchise;
import com.charlie.franchiseAPI.repository.FranchiseRepository;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
@Service
public class FranchiseService {
    
    @Autowired
    private FranchiseRepository franchiseRepository;
    
    public List<Franchise> findAll (){ // Get all franchises
        return franchiseRepository.findAll();
    };

    public Franchise save(Franchise franchise) {
        try {

           /*  if (franchiseRepository.existsByName(franchise)) {
                
            } */
            Franchise savedFranchise = franchiseRepository.insert(franchise);
            System.out.println("FRANQUICIA GUARDADA: " + savedFranchise);
            return savedFranchise;
        } catch (Exception e) {
            // Log the exception and throw a custom exception
            System.err.println("Error saving franchise: " + e.getMessage());
            throw new RuntimeException("Failed to save franchise", e);
        }
    }


    public Optional<Franchise> getId (String franchise){
        return  franchiseRepository.findById(franchise);
    };
}

