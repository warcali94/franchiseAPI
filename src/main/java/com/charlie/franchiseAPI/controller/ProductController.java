package com.charlie.franchiseAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlie.franchiseAPI.model.Branch;
import com.charlie.franchiseAPI.model.Product;
import com.charlie.franchiseAPI.service.BranchService;
import com.charlie.franchiseAPI.service.ProductService;

import lombok.NonNull;

@RestController
@RequestMapping("/api/products")
public class ProductController {

@Autowired
    private ProductService productService;
   @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody @NonNull Product product) {
        try {
            System.out.println("PRODUCTO ENTRANDO: " + product);
            Product savedProduct = productService.saveProduct(product);
            System.out.println("PRODUCTO GUARDADO: " + savedProduct);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);

        } catch (Exception e) {
            // Log the exception and return a more specific error response
            System.err.println("Error saving branch: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // More specific message
        }
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody @NonNull Product product) {
        try {
            System.out.println("PRODUCTO A ACTUALIZAR: " + product);
            Product savedProduct = productService.saveProduct(product);
            System.out.println("PRODUCTO ACTUALIZADO: " + savedProduct);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);

        } catch (Exception e) {
            // Log the exception and return a more specific error response
            System.err.println("Error updating product: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // More specific message
        }
    }
    @DeleteMapping
    public ResponseEntity<Product> deleteProduct(@RequestBody @NonNull Product product) {
        try {
            Product deletedProduct = productService.deleteProduct( product );            System.out.println("PRODUCTO ELIMINADO: " + deletedProduct);
            return ResponseEntity.status(HttpStatus.OK).body(deletedProduct);

        } catch (Exception e) {
            // Log the exception and return a more specific error response
            System.err.println("Error removing product: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // More specific message
        }
    }


}
