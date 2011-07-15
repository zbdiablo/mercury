package com.jardon.mercury.core.unit;

public enum Length implements Unit {
    UNDEFINED, METER;
    
    @Override
    public String getDisplayName() {
        return null;
    }
    
    @Override
    public boolean equalTo(Unit unit) {
        if (!(unit instanceof Length)) {
            return false;
        }
        return false;
    }
    
}
