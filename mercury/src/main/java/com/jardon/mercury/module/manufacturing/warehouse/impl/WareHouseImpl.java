package com.jardon.mercury.module.manufacturing.warehouse.impl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jardon.mercury.MercuryUnimplementedException;
import com.jardon.mercury.core.Goods;
import com.jardon.mercury.core.unit.Amount;
import com.jardon.mercury.module.manufacturing.warehouse.WareHouse;

/**
 * warehouse implementation
 * 
 * @since 1.0.0
 * @author Don Li
 * 
 */
@Entity
@Table(name = "wh_warehouse")
public class WareHouseImpl implements WareHouse {
    
    private long id;
    private Goods goods;
    private Amount amount;
    
    public WareHouseImpl() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id")
    // @PrimaryKeyJoinColumn
    public Goods getGoods() {
        return goods;
    }
    
    public void setGoods(Goods goods) {
        this.goods = goods;
    }
    
    public Amount getAmount() {
        return amount;
    }
    
    public void setAmount(Amount amount) {
        this.amount = amount;
    }
    
    @Override
    public void increase(Amount amount) throws MercuryUnimplementedException {
        if (!this.amount.getUnit().equalTo(amount.getUnit())) {
            throw new MercuryUnimplementedException("can't increse ammount with different units");
        }
    }
    
    @Override
    public void decrease(Amount amount) {
        // TODO Auto-generated method stub
        
    }
    
}
