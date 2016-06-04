
package es.jaranda.quick.panel.web.utils;

import com.vaadin.ui.Notification;

public class NotificationUtils {
    
    private NotificationUtils() {
        // no instances
    }
    
    public static final void showInfoMessage(String message) {
        Notification.show(message, Notification.Type.HUMANIZED_MESSAGE);
    }
    
    public static final void showWarnMessage(String caption, String message) {
        Notification.show(caption, message, 
                Notification.Type.WARNING_MESSAGE);
    }
    
    public static final void showInfoMessage(String caption, String message) {
        Notification.show(caption, message, 
                Notification.Type.HUMANIZED_MESSAGE);
    }
    
    public static final void showTrayMessage(String caption, String message) {
        Notification.show(caption, message, 
                Notification.Type.TRAY_NOTIFICATION);
    }
}
