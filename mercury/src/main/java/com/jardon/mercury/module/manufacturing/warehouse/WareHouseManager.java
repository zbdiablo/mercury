package com.jardon.mercury.module.manufacturing.warehouse;

import com.jardon.mercury.core.Goods;
import com.jardon.mercury.core.unit.Amount;

/**
 * interface defines how to manage the warehouses
 * 
 * @since 1.0.0
 * @author Don Li
 * 
 */
public interface WareHouseManager {
    /**
     * import goods to warehouse
     * 
     * @param goods
     *            goods to import
     * @param amount
     *            the amount of goods to import
     */
    public void importGoods(Goods goods, Amount amount);
    
    /**
     * export goods from warehouse
     * 
     * @param goods
     *            goods to export
     * @param amount
     *            the amount of goods to export
     */
    public void exportGoods(Goods goods, Amount amount);
    
    /**
     * get the amount of goods
     * 
     * @param goods
     *            the goods to count amount for
     * @return the amount of goods
     */
    public Amount getAmountOfGoods(Goods goods);
    
    /**
     * determine if the amount of goods can be exported
     * 
     * @param goods
     *            goods to verify amount
     * @param amount
     *            the amount to verify
     * @return true if goods can be exported, otherwise false
     */
    public boolean canExport(Goods goods, Amount amount);
}
