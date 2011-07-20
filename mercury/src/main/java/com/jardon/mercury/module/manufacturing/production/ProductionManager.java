package com.jardon.mercury.module.manufacturing.production;

import com.jardon.mercury.core.production.ProductionRecord;

/**
 * interface for manufacturing work flow management
 * 
 * @since 1.0.0
 * @author Don Li
 * 
 */
public interface ProductionManager {
    /**
     * persist ProductionRecord instance to storage and change the warehouse accordingly
     * 
     * @param record
     *            ProductionRecord instance to persist
     */
    public void persitProductionRecord(ProductionRecord record);
}
