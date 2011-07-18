package com.jardon.mercury.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jardon.mercury.module.manufacturing.warehouse.impl.WareHouseImpl;

@Entity
@Table(name = "manu_goods")
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class Goods {
    private long id;
    private String name;
    private WareHouseImpl wareHouseImpl;
    
    public Goods() {
    }
    
    public Goods(long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setWareHouseImpl(WareHouseImpl wareHouseImpl) {
        this.wareHouseImpl = wareHouseImpl;
    }
    
    @OneToOne(mappedBy = "goods")
    public WareHouseImpl getWareHouseImpl() {
        return wareHouseImpl;
    }
}
