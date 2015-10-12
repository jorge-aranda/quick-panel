
package es.jaranda.quick.panel.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Provides static access to Spring Application Context. This will be used to
 * provide Application Context to static helper (such as I18nServerUtils)
 */
@Component
class SpringContextHelper implements ApplicationContextAware {
    
    private static ApplicationContext ctx;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) 
            throws BeansException {
        SpringContextHelper.ctx = applicationContext;
    }
    
    public static<T> T getBean(Class<T> requiredType) {
        return ctx.getBean(requiredType);
    }
    
    public static<T> T getBean(Class<T> requiredType, String... args) {
        return ctx.getBean(requiredType, (Object[]) args);
    }
    
    public static<T> T getBean(String name, Class<T> requiredType) {
        return ctx.getBean(name, requiredType);
    }
    
    public Environment getEnvironment() {
        return ctx.getEnvironment();
    }
    
}
