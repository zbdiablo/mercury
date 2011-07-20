package com.jardon.mercury.core.production;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jardon.mercury.core.Material;
import com.jardon.mercury.core.unit.Amount;

@Entity
@Table(name = "manu_production_input")
public class ProductionInput {
    private long id;
    private Material material;
    private Amount amount;
    
    public ProductionInput() {
    }
    
    public ProductionInput(Material material, Amount amount) {
        this.material = material;
        this.amount = amount;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "material_id")
    public Material getMaterial() {
        return material;
    }
    
    public void setMaterial(Material material) {
        this.material = material;
    }
    
    @Embedded
    public Amount getAmount() {
        return amount;
    }
    
    public void setAmount(Amount amount) {
        this.amount = amount;
    }
    
}
