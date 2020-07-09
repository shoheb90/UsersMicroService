package com.shb.appl.api.users.ui.security;
/*
   @Author      : Shoheb
   Description  : 
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        /*
            CSRF stands for Cross-Site Request Forgery.
            It is an attack that forces an
            end user to execute unwanted actions on a web application in which they are currently authenticated
            Eg : user is asked to change email address or change password

         */
        http.csrf().disable();

        /*
            Temporary permitted users service requests
         */
        http.authorizeRequests().antMatchers("/users/**").permitAll();
    }
}
