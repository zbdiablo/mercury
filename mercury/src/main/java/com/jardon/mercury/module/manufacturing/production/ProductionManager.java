package com.jardon.mercury.module.manufacturing.production;

import java.util.Date;
import java.util.List;

import com.jardon.mercury.core.Product;
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
    public void createProductionRecord(ProductionRecord record);
    
    /**
     * remove the record from storage
     * 
     * @param recordId
     *            record id to remove
     */
    public void deleteProductionRecord(long recordId);
    
    /**
     * modify the content of the record
     * 
     * @param recordId
     *            record id to update
     * @param record
     *            the new content
     */
    public void modifyProductionRecord(long recordId, ProductionRecord record);
    
    /**
     * find the production record with a period of time
     * 
     * @param product
     *            the product to find
     * @param startDate
     *            start date
     * @param endDate
     *            end date
     */
    public List<ProductionRecord> findProductionRecord(Product product, Date startDate, Date endDate);
}
