package com.jardon.mercury.core;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "manu_material")
public class Material extends Goods {
    private String specification;
    
    public Material(long id, String name) {
        super(id, name);
    }
    
    public String getSpecification() {
        return specification;
    }
    
    public void setSpecification(String specification) {
        this.specification = specification;
    }
    
}
