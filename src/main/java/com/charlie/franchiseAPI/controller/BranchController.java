package com.charlie.franchiseAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlie.franchiseAPI.model.Branch;
import com.charlie.franchiseAPI.model.Franchise;
import com.charlie.franchiseAPI.model.Product;
import com.charlie.franchiseAPI.service.BranchService;
import com.charlie.franchiseAPI.service.FranchiseService;

import lombok.NonNull;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/branches")

public class BranchController {

    // private static final URI URI = null; // This field is not needed

    @Autowired
    private BranchService branchService;


    @GetMapping
    public ResponseEntity getAll() {
        // Franchise franquiciaGuardada = franquiciaService.crearFranquicia(franquicia);
        List <Branch> saved = branchService.findAll();
        return ResponseEntity.ok().body(saved);
        /* return ResponseEntity.created(URI.create("/api/franquicias/" + franquiciaGuardada.getId()))
                .body(franquiciaGuardada); */
    }

    
    @PostMapping
    public ResponseEntity<Branch> addBranch(@RequestBody @NonNull Branch branch) {
        try {
            System.out.println("Sucursal ENTRANDO: " + branch);
            Branch savedBranch = branchService.saveBranch(branch);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBranch);

        } catch (Exception e) {
            // Log the exception and return a more specific error response
            System.err.println("Error saving branch: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // More specific message
        }
    }

    @GetMapping("/{branchId}/mostStock")
    public ResponseEntity getProductWithMostStock(@PathVariable String branchId) {
        try {
            Product productWithMostStock = branchService.findProductWithMostStock(branchId);
            if (productWithMostStock == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(productWithMostStock);
        } catch (Exception e) {
            // Handle exceptions appropriately
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching product");
        }
    }
}
