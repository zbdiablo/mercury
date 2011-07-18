package com.jardon.mercury.module.manufacturing.warehouse;

import com.jardon.mercury.MercuryException;

/**
 * warehouse exception
 * 
 * @since 1.0.0
 * @author Don Li
 * 
 */
public class MercuryWareHouseException extends MercuryException {
    private static final long serialVersionUID = -5208731322392413929L;
    
    public MercuryWareHouseException(String message) {
        super(message);
    }
    
    private MercuryWareHouseException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
