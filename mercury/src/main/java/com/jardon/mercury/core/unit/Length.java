package com.jardon.mercury.core.unit;

import com.jardon.mercury.MercuryUnimplementedException;

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
    
    @Override
    public void setDisplayName(String displayName) {
        throw new MercuryUnimplementedException("class Lengh is not implemented");
    }
    
}
