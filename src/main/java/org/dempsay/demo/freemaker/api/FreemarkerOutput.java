package org.dempsay.demo.freemaker.api;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * Quick output for freemarker
 * @author shawn
 *
 */
public class FreemarkerOutput {
    public String output(final Sample data) {
        Configuration freemarkerConfig = setupFreemarker();
        try (StringWriter sw = new StringWriter()) {
            Template template = freemarkerConfig.getTemplate("sample.ftl");
            HashMap<String,Object> dictionary = new HashMap<>();
            dictionary.put("sample", data);
            template.process(dictionary, sw);
            return sw.toString();
        } catch (IOException | TemplateException e) {
            System.err.println("Failed to generate from template "+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    protected Configuration setupFreemarker() {
        Configuration freemarkerConfig;
        BeansWrapperBuilder builder = new BeansWrapperBuilder(Configuration.VERSION_2_3_23); 
        builder.setExposeFields(true);
        BeansWrapper wrapper = builder.build();
        freemarkerConfig = new Configuration(Configuration.VERSION_2_3_23);
        freemarkerConfig.setObjectWrapper(wrapper);
        freemarkerConfig.setClassLoaderForTemplateLoading(this.getClass().getClassLoader(), "/template");
        freemarkerConfig.setDefaultEncoding("UTF-8");
        freemarkerConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return freemarkerConfig;
    }
}
