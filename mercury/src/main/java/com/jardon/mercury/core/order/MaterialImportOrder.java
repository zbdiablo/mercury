package com.jardon.mercury.core.order;

import com.jardon.mercury.core.Material;
import com.jardon.mercury.core.Unit;

public class MaterialImportOrder implements ImportOrder {
    private Material material;
    private double amount;
    private Unit unit;
    
    public MaterialImportOrder() {
    }
    
    public MaterialImportOrder(Material material, double amount, Unit unit) {
        this.material = material;
        this.amount = amount;
        this.unit = unit;
    }
    
    public Material getMaterial() {
        return material;
    }
    
    public void setMaterial(Material material) {
        this.material = material;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public Unit getUnit() {
        return unit;
    }
    
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
