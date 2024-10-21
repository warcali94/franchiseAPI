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

    /* Create method */
    public Product saveProduct(Product newProduct) {
        try {

            Branch branch = branchRepository.findById(newProduct.getBranch())
                    .orElseThrow(() -> new RuntimeException("Branch not found"));

            // save branch in repository
            Product savedProduct = productRepository.save(newProduct);

            // Put product id into products array.
            branch.addProduct(savedProduct.getId());

            // Save updated franchise
            branchRepository.save(branch);

            return savedProduct;

        } catch (Exception e) {
            System.err.println("Error saving product: " + e.getMessage());
            throw new RuntimeException("Failed to save product", e);
        }
    }

    /* Update method */
    public Product updateProduct(Product product) {
        try {
            // Busca la sucursal relacionada con el producto
            Branch branch = branchRepository.findById(product.getBranch())
                    .orElseThrow(() -> new RuntimeException("Branch not found"));

            // Actualiza el producto en el repositorio
            Product updatedProduct = productRepository.save(product); // Aquí deberías usar save para la actualización

            // If product does not extist it'll be added.
            if (!branch.getProducts().contains(updatedProduct.getId())) {
                branch.addProduct(updatedProduct.getId());
                branchRepository.save(branch);
            }

            return updatedProduct;

        } catch (Exception e) {
            System.err.println("Error updating product: " + e.getMessage());
            throw new RuntimeException("Failed to update product", e);
        }
    }

    /* Delete method */
    public Product deleteProduct(Product product) {
        try {
            Branch branch = branchRepository.findById(product.getBranch())
                    .orElseThrow(() -> new RuntimeException("Branch not found"));

            productRepository.delete(product);

            branch.removeProduct(product.getId()); // Asumiendo que tienes un método removeProduct en la clase Branch

            branchRepository.save(branch);

            return product; // Retorna el producto eliminado si es necesario para el seguimiento

        } catch (Exception e) {
            System.err.println("Error deleting product: " + e.getMessage());
            throw new RuntimeException("Failed to delete product", e);
        }
    }

}