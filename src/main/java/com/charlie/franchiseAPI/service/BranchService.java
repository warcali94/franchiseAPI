package com.charlie.franchiseAPI.service;

import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlie.franchiseAPI.model.Branch;
import com.charlie.franchiseAPI.model.Franchise;
import com.charlie.franchiseAPI.model.Product;
// import com.charlie.franchiseAPI.model.Franchise;
import com.charlie.franchiseAPI.repository.BranchRepository;
import com.charlie.franchiseAPI.repository.FranchiseRepository;
import com.charlie.franchiseAPI.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private FranchiseRepository franchiseRepository;
    @Autowired
    private ProductRepository productRepository;
    private Product product;
    // Get all franchises
    public List<Branch> findAll() {
        return branchRepository.findAll();
    };

    // Save new branch
    public Branch saveBranch(Branch newBranch) {
        try {
            // Busca la franquicia relacionada con la sucursal
            Franchise franchise = franchiseRepository.findById(newBranch.getFranchise())
                    .orElseThrow(() -> new RuntimeException("Franchise not found"));

            // save branch in repository
            Branch savedBranch = branchRepository.save(newBranch);

            // Put branch id into franchise branch array
            franchise.addBranch(savedBranch.getId()); 

            // Save updated franchise
            franchiseRepository.save(franchise);

            return savedBranch;

        } catch (Exception e) {
            System.err.println("Error saving branch: " + e.getMessage());
            throw new RuntimeException("Failed to save branch", e);
        }
    }


    /* Pending to finish this method */
    public Product findProductWithMostStock(String branchId) {
        // Optional<Branch> branch = branchRepository.findById(branchId);
        List<Product> products = productRepository.findAll();

        // .orElseThrow(() -> new EntityNotFoundException("Branch not found"));
        return (Product) products;/* getProducts() *//* .stream()
                                  .max(Comparator.comparing(Product::getStock))
                                  .orElseThrow(() -> new EntityNotFoundException("No products found"));
     */}

}
