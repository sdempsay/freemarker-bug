package org.dempsay.demo.freemaker.api;

/**
 * Builder for sample
 * 
 * @author shawn
 *
 */
public class SampleBuilder {
    public String data;
    
    public SampleBuilder data(final String data) {
        this.data = data;
        return this;
    }
    
    public Sample build() {
        return new Sample(this);
    }
    
    public static String data(final SampleBuilder builder) {
        return builder.data;
    }
}
