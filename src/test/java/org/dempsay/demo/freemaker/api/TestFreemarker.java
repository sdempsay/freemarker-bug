package org.dempsay.demo.freemaker.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * 
 * @author shawn
 *
 */
public class TestFreemarker {

    @Test
    public void testFreemarker() {
        Sample sample = new SampleBuilder().data("hi").build();
        FreemarkerOutput outputter = new FreemarkerOutput();
        String rendered = outputter.output(sample);
        assertNotNull(rendered);
        assertEquals("The data from this sample is hi", rendered);
    }
}
