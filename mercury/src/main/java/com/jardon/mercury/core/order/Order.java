package com.jardon.mercury.core.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bom_order")
public class Order {
    private long id;
    private List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
    private Date createOn;
    private OrderType orderType;
    private OrderStatus orderStatus;
    
    public enum OrderType {
        IMPORT_ORDER, EXPORT_ORDER
    }
    
    public enum OrderStatus {
        CREATED, PROCESSING, COMPLETED, ERROR, CANCELED
    }
    
    public Order() {
    }
    
    public Order(OrderType orderType) {
        this.orderType = orderType;
        this.createOn = new Date();
        this.orderStatus = OrderStatus.CREATED;
    }
    
    public boolean addOrderInfo(OrderInfo orderInfo) {
        return orderInfos.add(orderInfo);
    }
    
    public boolean deleteOrderInfo(OrderInfo orderInfo) {
        if (orderInfos.contains(orderInfo)) {
            orderInfos.remove(orderInfo);
            return true;
        }
        return false;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "bom_order_to_info",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "order_info_id"))
    public List<OrderInfo> getOrderInfos() {
        return orderInfos;
    }
    
    public void setOrderInfos(List<OrderInfo> orderInfos) {
        this.orderInfos = orderInfos;
    }
    
    @Column(name = "create_on")
    public Date getCreateOn() {
        return createOn;
    }
    
    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }
    
    @Column(name = "order_type")
    public OrderType getOrderType() {
        return orderType;
    }
    
    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }
    
    @Column(name = "order_status")
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    
}
