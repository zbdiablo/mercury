package com.jardon.mercury.module.manufacturing.production.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jardon.mercury.core.Goods;
import com.jardon.mercury.core.production.ProductionRecord;
import com.jardon.mercury.module.manufacturing.production.ProductionManager;
import com.jardon.mercury.module.manufacturing.warehouse.WareHouseManager;

@Service("productionManager")
public class ProductionManagerImpl implements ProductionManager {
    private WareHouseManager wareHouseManager;
    private EntityManagerFactory emf;
    
    @Autowired
    public ProductionManagerImpl(WareHouseManager wareHouseManager, EntityManagerFactory emf) {
        this.wareHouseManager = wareHouseManager;
        this.emf = emf;
    }
    
    @Override
    public void persitProductionRecord(ProductionRecord record) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            for (Goods goods : record.getInputMap().keySet()) {
                wareHouseManager.exportGoods(goods, record.getInputMap().get(goods).getAmount());
            }
            for (Goods goods : record.getOutputMap().keySet()) {
                wareHouseManager.importGoods(goods, record.getOutputMap().get(goods).getAmount());
            }
            em.persist(record);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        
    }
}
