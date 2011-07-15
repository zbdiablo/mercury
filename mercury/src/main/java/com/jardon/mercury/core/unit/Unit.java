package com.jardon.mercury.core.unit;

public interface Unit {
    public String getDisplayName();
    
    /**
     * Whether the unit is equal to me
     * 
     * @param unit
     *            the unit to compare with
     * @return
     * @since 1.0.0
     */
    public boolean equalTo(Unit unit);
}
