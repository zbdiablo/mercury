package com.jardon.mercury;

/**
 * Mercury unimplemented runtime exception class.
 * 
 * @since 1.0.0
 * @author Don Li
 * 
 */
public class MercuryUnimplementedException extends MercuryRuntimeException {
    private static final long serialVersionUID = 4737555717692343170L;
    
    public MercuryUnimplementedException(String message) {
        super(message);
    }
    
}
