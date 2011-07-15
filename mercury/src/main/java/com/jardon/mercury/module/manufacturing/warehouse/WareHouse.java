package com.jardon.mercury.module.manufacturing.warehouse;

import com.jardon.mercury.core.unit.Amount;

public interface WareHouse {
    public void increase(Amount amount);
    
    public void decrease(Amount amount);
    
}
