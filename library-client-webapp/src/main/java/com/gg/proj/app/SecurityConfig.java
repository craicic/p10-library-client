package com.gg.proj.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {

        authentication.inMemoryAuthentication()
                .withUser("gg").password("123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().usernameParameter("pseudo").passwordParameter("password").failureForwardUrl("/login");
        http.logout().deleteCookies("token").logoutUrl("/logout");
        http.authorizeRequests().antMatchers("/*").hasRole("USER");
    }

}
