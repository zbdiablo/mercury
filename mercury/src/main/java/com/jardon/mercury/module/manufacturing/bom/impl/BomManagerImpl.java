package com.jardon.mercury.module.manufacturing.bom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jardon.mercury.core.order.Order;
import com.jardon.mercury.core.order.Order.OrderStatus;
import com.jardon.mercury.core.order.Order.OrderType;
import com.jardon.mercury.core.order.OrderInfo;
import com.jardon.mercury.module.manufacturing.bom.BomManager;

/**
 * implementation of bom manager
 * 
 * @since 1.0.0
 * @author Don Li
 * 
 */
@Service("bomManager")
public class BomManagerImpl implements BomManager {
    private EntityManagerFactory emf;
    
    @Autowired
    public BomManagerImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public Order createOrder(OrderType orderType, List<OrderInfo> orderInfos) {
        EntityManager em = emf.createEntityManager();
        try {
            Order order = new Order(orderType);
            order.setOrderInfos(orderInfos);
            em.persist(order);
            return order;
        } finally {
            em.close();
        }
    }
    
    @Override
    public OrderStatus getOrderStatus(Order order) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Order.class, order.getId()).getOrderStatus();
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean cancelOrder(Order order) {
        switch (order.getOrderStatus()) {
            case CREATED:
                cancelOrderImpl(order);
                return true;
            case PROCESSING:
                cancelOrderImpl(order);
                return true;
            default:
                return false;
        }
        
    }
    
    private void cancelOrderImpl(Order order) {
        EntityManager em = emf.createEntityManager();
        try {
            em.find(Order.class, order.getId()).setOrderStatus(OrderStatus.CANCELED);
        } finally {
            em.close();
        }
    }
    
}
