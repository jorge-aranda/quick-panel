
package es.jaranda.quick.panel.utils;

import java.util.Locale;
import org.springframework.context.MessageSource;

/**
 * Provides i18n support for server-side (for example Loggers)
 */
public class I18nServerUtils {
    
    private I18nServerUtils() {
        // no instanciable
    }
    
    public static String getMessage(String code, String... args) {
        return SpringContextHelper.getBean(MessageSource.class).
                getMessage(code, args, Locale.getDefault());
    }
    
}
