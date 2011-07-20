package com.jardon.mercury.module.manufacturing.costcontrol;

import java.util.Date;
import java.util.List;

import com.jardon.mercury.core.ConversionRate;
import com.jardon.mercury.core.Product;

/**
 * interface for cost control manager
 * 
 * @since 1.0.0
 * @author Don Li
 * 
 */
public interface CostControlManager {
    List<ConversionRate> getConversionRates(Product product, Date startDate, Date endDate);
}