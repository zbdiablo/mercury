package com.jardon.mercury.core.production;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jardon.mercury.core.Material;
import com.jardon.mercury.core.Product;

@Entity
@Table(name = "manu_production_record")
public class ProductionRecord {
    private long id;
    private Map<Material, ProductionInput> inputMap = new HashMap<Material, ProductionInput>();
    private Map<Product, ProductionOutput> outputMap = new HashMap<Product, ProductionOutput>();
    private Date startDate;
    private Date endDate;
    
    public ProductionRecord() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @OneToMany
    @JoinTable(
            name = "manu_production_record_to_input",
            joinColumns = @JoinColumn(name = "record_id"),
            inverseJoinColumns = @JoinColumn(name = "input_id"))
    @MapKeyColumn(name = "material_id")
    public Map<Material, ProductionInput> getInputMap() {
        return inputMap;
    }
    
    public void setInputMap(Map<Material, ProductionInput> inputMap) {
        this.inputMap = inputMap;
    }
    
    @OneToMany
    @JoinTable(
            name = "manu_production_record_to_output",
            joinColumns = @JoinColumn(name = "record_id"),
            inverseJoinColumns = @JoinColumn(name = "output_id"))
    @MapKeyColumn(name = "production_id")
    public Map<Product, ProductionOutput> getOutputMap() {
        return outputMap;
    }
    
    public void setOutputMap(Map<Product, ProductionOutput> outputMap) {
        this.outputMap = outputMap;
    }
    
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
}
