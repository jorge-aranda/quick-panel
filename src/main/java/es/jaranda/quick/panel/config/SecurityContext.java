
package es.jaranda.quick.panel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.
        builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.
        EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.
        WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.
        configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityContext extends WebSecurityConfigurerAdapter {
    
    private static final String URL_INTERCEPTOR = "/**";
    
    // TODO pending use final authentication
    /* Provisional AUTHENTICATION */
    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "user";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private static final String ROLE_USER_ID = "USER";
    private static final String ROLE_ADMIN_ID = "ADMIN";
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers(URL_INTERCEPTOR).permitAll()
                .anyRequest().authenticated()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
            throws Exception {
        
        auth.inMemoryAuthentication()
                .withUser(USER_USERNAME)
                    .password(USER_PASSWORD)
                    .roles(ROLE_USER_ID).and()
                .withUser(ADMIN_USERNAME).password(ADMIN_PASSWORD)
                    .roles(ROLE_USER_ID, ROLE_ADMIN_ID);
    }
}
