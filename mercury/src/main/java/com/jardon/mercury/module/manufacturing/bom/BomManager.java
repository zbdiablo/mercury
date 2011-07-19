package com.jardon.mercury.module.manufacturing.bom;

import java.util.List;

import com.jardon.mercury.core.order.Order;
import com.jardon.mercury.core.order.Order.OrderStatus;
import com.jardon.mercury.core.order.Order.OrderType;
import com.jardon.mercury.core.order.OrderInfo;

/**
 * interface for the bussiness order management(BOM) manager
 * 
 * @since 1.0.0
 * @author Don Li
 * 
 */
public interface BomManager {
    /**
     * create a new order
     * 
     * @param orderType
     *            order type to create
     * @param orderInfos
     *            detail order information
     * @return the order created
     */
    public Order createOrder(OrderType orderType, List<OrderInfo> orderInfos);
    
    /**
     * query the status of the order
     * 
     * @param order
     *            the order to query
     * @return
     */
    public OrderStatus getOrderStatus(Order order);
    
    /**
     * cancel an order, recently only the order in [CREATED, COMPLETED] status can be canceled
     * 
     * @param order
     *            the order to cancel
     * @return true concel succeeded, false otherwise
     */
    public boolean cancelOrder(Order order);
}