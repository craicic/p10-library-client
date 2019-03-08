package com.gg.proj.app;

import com.gg.proj.authentication.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan("com.gg.proj.authentication")
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

//    @Autowired
//    public SecurityConfig(CustomAuthenticationProvider authenticationProvider) {
//        this.authenticationProvider = authenticationProvider;
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.formLogin().usernameParameter("pseudo").passwordParameter("password").failureForwardUrl("/login");
//        http.logout().deleteCookies("token").logoutUrl("/logout");

        http.authorizeRequests()
                .antMatchers("/**")
                .authenticated()
                .and()
                .formLogin();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
//
//        authentication.inMemoryAuthentication()
//                .withUser("gg").password("123").roles("USER");
//    }

}
