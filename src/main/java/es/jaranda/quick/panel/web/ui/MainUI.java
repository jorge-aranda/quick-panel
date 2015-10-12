
package es.jaranda.quick.panel.web.ui;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import static es.jaranda.quick.panel.constants.ConfigurationConstants.*;
import static es.jaranda.quick.panel.constants.StylesConstants.*;
import es.jaranda.quick.panel.constants.i18n.MainUII18nConstants;
import es.jaranda.quick.panel.constants.i18n.PageI18nConstants;
import es.jaranda.quick.panel.utils.I18nServerUtils;
import es.jaranda.quick.panel.web.util.I18nHelper;
import es.jaranda.quick.panel.web.window.LoginWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path=MAIN_UI_PATH)
@Theme(DEFAULT_STYLE)
@PreserveOnRefresh
public class MainUI extends UI {

    private static final Logger LOG = LoggerFactory.getLogger(MainUI.class);
    
    @Autowired
    private I18nHelper i18n;
    
    @Autowired
    private LoginWindow loginWindow;
        
    @Override
    protected void init(VaadinRequest request) {
        reportIntoLogNewConnection(request.getWrappedSession().getId());
        
        /* Set navigation properties */
//        this.getPage().setUriFragment(???);
        this.getPage().setTitle(i18n.getMessage(PageI18nConstants.TITLE));
        
        // Let's go!
        addWindow(loginWindow);
        
    }
    
    @Override
    protected void refresh(VaadinRequest request) {
        reportIntoLogBrowserRefresh(request.getWrappedSession().getId());
    }
    
    private void reportIntoLogNewConnection(String id) {
        String address = getPage().getWebBrowser().getAddress();
        
        LOG.info(I18nServerUtils.getMessage(
                MainUII18nConstants.LOG_NEW_CONNECTION, address, id));
    }

    private void reportIntoLogBrowserRefresh(String id) {
        String address = getPage().getWebBrowser().getAddress();
        
        LOG.info(I18nServerUtils.getMessage(
                MainUII18nConstants.LOG_REFRESH_CONNECTION, address, id));
    }
}
