package com.jardon.mercury.core.unit;

import javax.persistence.Embeddable;

@Embeddable
public interface Unit {
    public String getDisplayName();
    
    public void setDisplayName(String displayName);
    
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
