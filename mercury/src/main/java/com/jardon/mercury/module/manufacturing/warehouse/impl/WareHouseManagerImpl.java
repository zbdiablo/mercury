package com.jardon.mercury.module.manufacturing.warehouse.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jardon.mercury.core.Goods;
import com.jardon.mercury.core.unit.Amount;
import com.jardon.mercury.module.manufacturing.warehouse.WareHouse;
import com.jardon.mercury.module.manufacturing.warehouse.WareHouseManager;

@Service("wareHouseManager")
public class WareHouseManagerImpl implements WareHouseManager {
    
    private WareHouse wareHouse;
    private EntityManagerFactory emf;
    
    @Autowired
    public WareHouseManagerImpl(WareHouse wareHouse, EntityManagerFactory emf) {
        this.wareHouse = wareHouse;
        this.emf = emf;
    }
    
    @Override
    public void importGoods(Goods goods, Amount amount) {
        EntityManager em = emf.createEntityManager();
        try {
            // query database to get the warehouse object and increase its amount
        } finally {
            em.close();
        }
    }
    
    @Override
    public void exportGoods(Goods goods, Amount amount) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public Amount getAmountOfGoods(Goods material) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public boolean canExport(Goods goods, Amount amount) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
