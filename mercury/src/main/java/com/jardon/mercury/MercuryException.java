package com.jardon.mercury;

/**
 * Mercury root exception class.
 * 
 * @since 1.0.0
 * @author Don Li
 * 
 */
public class MercuryException extends Exception {
    
    private static final long serialVersionUID = 1318759070914163188L;
    
    public MercuryException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public MercuryException(String message) {
        super(message);
    }
    
}
