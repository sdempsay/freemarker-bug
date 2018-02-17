package org.dempsay.demo.freemaker.api;

/**
 * A Sample immutable
 * 
 * @author shawn
 *
 */
public class Sample {
    public final String data;
    
    protected Sample(final SampleBuilder builder) {
        this.data = builder.data;
    }
    
    public static String data(final Sample sample) {
        return sample.data;
    }
}
