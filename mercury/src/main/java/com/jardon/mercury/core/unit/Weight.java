package com.jardon.mercury.core.unit;

public enum Weight implements Unit {
    UNDEFINED("undefined"), GRAM("gram"), KILOGRAM("kilograme"), TON("ton");
    
    private String value;
    
    private Weight(String value) {
        this.value = value;
    }
    
    @Override
    public String getDisplayName() {
        return value;
    }
    
    @Override
    public void setDisplayName(String displayName) {
        this.value = displayName;
    }
    
    @Override
    public boolean equalTo(Unit unit) {
        if (!(unit instanceof Weight)) {
            return false;
        }
        Weight weight = (Weight) unit;
        if (weight == this) {
            return true;
        }
        return false;
    }
    
}
