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
    public void importGoods(Goods goods, Amount amount);
    
    public void exportGoods(Goods goods, Amount amount);
    
    public Amount getAmountOfGoods(Goods material);
    
    public boolean canExport(Goods goods, Amount amount);
}
