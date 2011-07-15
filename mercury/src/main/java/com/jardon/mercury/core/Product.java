package com.jardon.mercury.core;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "manu_product")
public class Product extends Goods {
    
    public Product(long id, String name) {
        super(id, name);
    }
    
}
