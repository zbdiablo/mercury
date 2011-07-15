package com.jardon.mercury.core;

import com.jardon.mercury.core.unit.Unit;

public class ConversionRate {
    private Goods from;
    private double fromAmount;
    private Unit fromUnit;
    private Goods to;
    private double toAmount;
    private Unit toUnit;
    
    public ConversionRate(Goods from, double fromAmount, Unit fromUnit, Goods to, double toAmount, Unit toUnit) {
        this.from = from;
        this.fromAmount = fromAmount;
        this.fromUnit = fromUnit;
        this.to = to;
        this.toAmount = toAmount;
        this.toUnit = toUnit;
    }
    
    public Goods getFrom() {
        return from;
    }
    
    public double getFromAmount() {
        return fromAmount;
    }
    
    public Unit getFromUnit() {
        return fromUnit;
    }
    
    public Goods getTo() {
        return to;
    }
    
    public double getToAmount() {
        return toAmount;
    }
    
    public Unit getToUnit() {
        return toUnit;
    }
    
}
