package com.jardon.mercury.module.manufacturing.warehouse;

import com.jardon.mercury.core.unit.Amount;

/**
 * define the basic interface of a warehouse
 * 
 * @since 1.0.0
 * @author Don Li
 * 
 */
public interface WareHouse {
    /**
     * increase the amount
     * 
     * @param amount
     */
    public void increase(Amount amount);
    
    /**
     * decrease the amount
     * 
     * @param amount
     */
    public void decrease(Amount amount);
    
}
