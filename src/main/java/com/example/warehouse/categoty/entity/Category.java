package com.example.warehouse.categoty.entity;

import com.example.warehouse.common.AbsClass;
import com.example.warehouse.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Category extends AbsClass {
    @Id
    private Long id;
    private String name;
    private  Boolean status;


    @OneToMany(mappedBy = "category")
    private List<Product> products;


}
