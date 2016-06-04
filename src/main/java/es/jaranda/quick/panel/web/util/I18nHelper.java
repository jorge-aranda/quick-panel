
package es.jaranda.quick.panel.web.util;

import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;


/**
 * Provides support for i18n into Vaadin
 */
@VaadinSessionScope
@SpringComponent
public class I18nHelper implements Serializable {
    
    @Autowired
    private MessageSource messageSource;
    
    public String getMessage(String code, String... args) {
        return messageSource.getMessage(code, args, 
                VaadinSession.getCurrent().getLocale());
    }
    
}
