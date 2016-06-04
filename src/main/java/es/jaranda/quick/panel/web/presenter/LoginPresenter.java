
package es.jaranda.quick.panel.web.presenter;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import es.jaranda.quick.panel.web.window.LoginWindow;
import static 
        org.springframework.beans.factory.config.ConfigurableBeanFactory.*;
import org.springframework.context.annotation.Scope;

@SpringComponent
@Scope(SCOPE_PROTOTYPE)
public class LoginPresenter {
    
    private LoginWindow view;
    
    public void buttonClickMe(Button.ClickEvent event) {
        this.view.displayDemoMessage();
    }
    
    public void setView(LoginWindow view) {
        this.view = view;
    }
    
}
