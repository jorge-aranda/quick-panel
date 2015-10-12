
package es.jaranda.quick.panel.config;

import static es.jaranda.quick.panel.constants.ConfigurationConstants.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(COMPONENT_SCAN_PACKAGES)
public class MainApp {

    private static final Logger LOG = LoggerFactory.getLogger(MainApp.class);
    
    @Bean
    ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource bean = 
                new ResourceBundleMessageSource();
//        bean.setBeanClassLoader(this.getClass().getClassLoader());
        bean.setBasename("international/messages");
        
        return bean;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class);
    }

}
