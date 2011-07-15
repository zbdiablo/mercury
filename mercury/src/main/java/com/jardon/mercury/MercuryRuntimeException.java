package com.jardon.mercury;

/**
 * Mercury root runtime exception class.
 * 
 * @since 1.0.0
 * @author Don Li
 * 
 */
public class MercuryRuntimeException extends RuntimeException {
    
    private static final long serialVersionUID = -7186122195976000158L;
    
    public MercuryRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public  MercuryRuntimeException(String message) {
        super(message);
    }
    
}
