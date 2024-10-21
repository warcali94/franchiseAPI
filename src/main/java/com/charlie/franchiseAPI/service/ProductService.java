package com.charlie.franchiseAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlie.franchiseAPI.model.Branch;
import com.charlie.franchiseAPI.model.Franchise;
import com.charlie.franchiseAPI.model.Product;
import com.charlie.franchiseAPI.repository.BranchRepository;
import com.charlie.franchiseAPI.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    BranchRepository branchRepository;

    // private Product product;
    public Product saveProduct(Product newProduct) {
        try {
            
            Branch branch = branchRepository.findById(newProduct.getBranch())
                    .orElseThrow(() -> new RuntimeException("Branch not found"));

            System.out.println("SUCURSAL ENCONTRADA" + branch);
            // save branch in repository
            Product savedProduct = productRepository.save(newProduct);
            System.out.println("PRODUCTO GUARDADO" + savedProduct);

            // Put product id into products array.
            branch.addProduct(savedProduct.getId());

            // Save updated franchise
            branchRepository.save(branch);

            return savedProduct;

        } catch (Exception e) {
            System.err.println("Error saving branch: " + e.getMessage());
            throw new RuntimeException("Failed to save branch", e);
        }
    }
}
