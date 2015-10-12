
package es.jaranda.quick.panel.web.window;

import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Window;
import es.jaranda.quick.panel.web.util.I18nHelper;
import static es.jaranda.quick.panel.constants.i18n.DemoI18nConstants.*;
import static es.jaranda.quick.panel.constants.i18n.LoginI18nConstants.*;
import es.jaranda.quick.panel.web.utils.NotificationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import static 
    org.springframework.beans.factory.config.ConfigurableBeanFactory.*;
import org.springframework.context.annotation.Scope;

@SpringComponent
@Scope(SCOPE_PROTOTYPE)
public class LoginWindow extends Window {

    private static final String WIDTH_SIZE = "90%";
    private static final String HEIGHT_SIZE = "90%";
    
    private final I18nHelper i18n;
    
    @Autowired
    public LoginWindow(I18nHelper i18n) {
        super(i18n.getMessage(CAPTION));
        
        this.i18n = i18n;
        
        setUp();

        // XXX remove demo
        /* DEMO */
        prepareDemo();
    }
    
    private void setUp() {
        this.setModal(true);
        this.setResizable(true);
        this.setClosable(false);
        this.setResponsive(true);

        this.setWidth(WIDTH_SIZE);
        this.setHeight(HEIGHT_SIZE);
    }
    
    private String getMessage(String code) {
        return i18n.getMessage(code);
    }
    
    // XXX remove demo
    /* DEMO -> to remove */
    
    private void prepareDemo() {
        this.setContent(new Button(getMessage(CLICK_ME), 
            e -> NotificationUtils.showInfoMessage(getMessage(HELLO)))
        );
    }
}
