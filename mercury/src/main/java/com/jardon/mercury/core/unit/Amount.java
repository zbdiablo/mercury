package com.jardon.mercury.core.unit;

import com.jardon.mercury.MercuryUnimplementedException;

public final class Amount {
    private double number;
    private Unit unit;
    
    public Amount() {
        this(0, null);
    }
    
    public Amount(double number, Unit unit) {
        this.number = number;
        this.unit = unit;
    }
    
    public double getNumber() {
        return number;
    }
    
    public void setNumber(double number) {
        this.number = number;
    }
    
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
        this.number += amount.getNumber();
    }
    
    public void reduce(Amount amount) {
        // TODO check the unit before add
        if (!this.unit.equalTo(amount.getUnit())) {
            throw new MercuryUnimplementedException("different unit is not comparable yet");
        }
        this.number -= amount.getNumber();
    }
}
