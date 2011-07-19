package com.jardon.mercury.core.order;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jardon.mercury.core.Goods;
import com.jardon.mercury.core.unit.Amount;

@Entity
@Table(name = "bom_order_info")
public class OrderInfo {
    private long id;
    private Goods good;
    private Amount amount;
    
    public OrderInfo() {
    }
    
    public OrderInfo(Goods good, Amount amount) {
        this.good = good;
        this.amount = amount;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "goods_id")
    public Goods getGood() {
        return good;
    }
    
    public void setGood(Goods good) {
        this.good = good;
    }
    
    @Embedded
    public Amount getAmount() {
        return amount;
    }
    
    public void setAmount(Amount amount) {
        this.amount = amount;
    }
    
}
