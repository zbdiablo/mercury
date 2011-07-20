package com.jardon.mercury.core.production;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jardon.mercury.core.Product;
import com.jardon.mercury.core.unit.Amount;

@Entity
@Table(name = "manu_production_output")
public class ProductionOutput {
    private long id;
    private Product product;
    private Amount amount;
    
    public ProductionOutput() {
    }
    
    public ProductionOutput(Product product, Amount amount) {
        super();
        this.product = product;
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
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    @Embedded
    public Amount getAmount() {
        return amount;
    }
    
    public void setAmount(Amount amount) {
        this.amount = amount;
    }
    
}
