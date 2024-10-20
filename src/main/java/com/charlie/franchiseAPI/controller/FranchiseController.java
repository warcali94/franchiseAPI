package com.charlie.franchiseAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlie.franchiseAPI.model.Franchise;
import com.charlie.franchiseAPI.service.FranchiseService;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/franchises")
public class FranchiseController {

    private static final URI URI = null;
    @Autowired
    private FranchiseService franchiseService;
/* Getting all franchises */
    @GetMapping
    public ResponseEntity getAll(/* @RequestBody *//*  Franchise franchise */) {
        // Franchise franquiciaGuardada = franquiciaService.crearFranquicia(franquicia);
        List <Franchise> saved = franchiseService.findAll();
        return ResponseEntity.ok().body(saved);
        /* return ResponseEntity.created(URI.create("/api/franquicias/" + franquiciaGuardada.getId()))
                .body(franquiciaGuardada); */
    }

    
  @PostMapping
public ResponseEntity<Franchise> addFranchise(@RequestBody Franchise franchise) {
    try {
        System.out.println("FRANQUICIA ENTRANDO: " + franchise);
        Franchise savedFranchise = franchiseService.save(franchise);
        URI location = URI.create("/api/franchises/" + savedFranchise.getId());
        System.out.println("LOCATION: " + location);
        return ResponseEntity.created(location).body(savedFranchise);
    } catch (Exception e) {
        // Log the exception and return a more specific error response
        System.err.println("Error saving franchise: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

    // Otros métodos para obtener, actualizar y eliminar franquicias
}