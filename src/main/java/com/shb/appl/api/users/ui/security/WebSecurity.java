package com.shb.appl.api.users.ui.security;
/*
   @Author      : Shoheb
   Description  : 
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    Environment environment;
    @Autowired
    public WebSecurity(Environment environment){
        this.environment = environment;
    }

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
        //http.authorizeRequests().antMatchers("/users/**

        //Restricted service to be accesible from only provided gateway IP
        http.authorizeRequests().antMatchers("/**").hasIpAddress(environment.getProperty("gateway.ip"));
        /*
        Disable security for frame options so H2 database should be accesible
         */
        http.headers().frameOptions().disable();
    }
}
