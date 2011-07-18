package com.jardon.mercury.core.unit;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.jardon.mercury.MercuryUnimplementedException;

@Embeddable
public final class Amount {
    private double quantity;
    private Unit unit;
    
    public Amount() {
        this(0, null);
    }
    
    public Amount(double quantity, Unit unit) {
        this.quantity = quantity;
        this.unit = unit;
    }
    
    public double getQuantity() {
        return quantity;
    }
    
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "displayName", column = @Column(name = "unit"))
    })
    public Unit getUnit() {
        return unit;
    }
    
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    
    public void add(Amount amount) {
        // TODO check the unit before add
        if (!this.unit.equalTo(amount.getUnit())) {
            throw new MercuryUnimplementedException("different unit is not comparable yet");
        }
        this.quantity += amount.getQuantity();
    }
    
    public void reduce(Amount amount) {
        // TODO check the unit before add
        if (!this.unit.equalTo(amount.getUnit())) {
            throw new MercuryUnimplementedException("different unit is not comparable yet");
        }
        this.quantity -= amount.getQuantity();
    }
}
