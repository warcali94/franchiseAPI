package com.charlie.franchiseAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Document(collection = "franchise")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Franchise {

    // @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private List<Branch> branches = new ArrayList<>();

    public String getId(){
        return id;
    }
    private String getName(){
        return name;
    }
    // No need for the exists method
}