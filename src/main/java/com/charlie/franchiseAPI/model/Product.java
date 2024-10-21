package com.charlie.franchiseAPI.model;

import org.springframework.data.annotation.Id;
// import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document( collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private int stock;
    private String branch;

    public String getName(){
        return name;
    }
    public String getBranch(){
        return branch;
    }

}
