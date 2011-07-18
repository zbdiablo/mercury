package com.jardon.mercury.module.manufacturing.warehouse.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jardon.mercury.core.Goods;
import com.jardon.mercury.core.unit.Amount;
import com.jardon.mercury.module.manufacturing.warehouse.WareHouseManager;

/**
 * warehouse manager implementation
 * 
 * @since 1.0.0
 * @author Don Li
 * 
 */
@Service("wareHouseManager")
public class WareHouseManagerImpl implements WareHouseManager {
    
    private EntityManagerFactory emf;
    
    @Autowired
    public WareHouseManagerImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public void importGoods(Goods goods, Amount amount) {
        EntityManager em = emf.createEntityManager();
        try {
            em.find(Goods.class, goods.getId()).getWareHouseImpl().increase(amount);
        } finally {
            em.close();
        }
    }
    
    @Override
    public void exportGoods(Goods goods, Amount amount) {
        EntityManager em = emf.createEntityManager();
        try {
            em.find(Goods.class, goods.getId()).getWareHouseImpl().decrease(amount);
        } finally {
            em.close();
        }
    }
    
    @Override
    public Amount getAmountOfGoods(Goods goods) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Goods.class, goods.getId()).getWareHouseImpl().getAmount();
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean canExport(Goods goods, Amount amount) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Goods.class, goods.getId()).getWareHouseImpl().getAmount().compareTo(amount) >= 0 ? true : false;
        } finally {
            em.close();
        }
    }
    
}
