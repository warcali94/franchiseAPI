package com.charlie.franchiseAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection = "branches")
@Data
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Branch {
    @Id
    private String id;
    private String name;
    // @DBRef
    // private Franchise franchise;
    private String franchise;

    private List<Product> products = new ArrayList<>();
    String getBranchId(){
        return id;
    }
    public String getFranchise(){
        return franchise;
    }
}