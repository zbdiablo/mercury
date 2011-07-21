package com.jardon.mercury.module.manufacturing.production.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jardon.mercury.MercuryUnimplementedException;
import com.jardon.mercury.core.Goods;
import com.jardon.mercury.core.Product;
import com.jardon.mercury.core.production.ProductionRecord;
import com.jardon.mercury.module.manufacturing.production.ProductionManager;
import com.jardon.mercury.module.manufacturing.warehouse.WareHouseManager;

@Service("productionManager")
@NamedQuery(
        name = "qry_production_record",
        query = "select r from ProductionRecord r, ProductionOutput o where r.outputMap[o.product] = o and o.product = :product and r.startDate >= :startDate and r.endDate <= :endDate")
public class ProductionManagerImpl implements ProductionManager {
    private WareHouseManager wareHouseManager;
    private EntityManagerFactory emf;
    
    @Autowired
    public ProductionManagerImpl(WareHouseManager wareHouseManager, EntityManagerFactory emf) {
        this.wareHouseManager = wareHouseManager;
        this.emf = emf;
    }
    
    // TODO commit in one transaction: JTA or pass the em
    @Override
    public void createProductionRecord(ProductionRecord record) {
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
    
    @Override
    public List<ProductionRecord> findProductionRecord(Product product, Date startDate, Date endDate) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<ProductionRecord> query = em.createNamedQuery("qry_production_record", ProductionRecord.class);
            query.setParameter("product", product);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    @Override
    public void deleteProductionRecord(long recordId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.detach(em.find(getClass(), recordId));
        } finally {
            em.close();
        }
    }
    
    @Override
    public void modifyProductionRecord(long recordId, ProductionRecord record) {
        throw new MercuryUnimplementedException("not implemented");
    }
}
