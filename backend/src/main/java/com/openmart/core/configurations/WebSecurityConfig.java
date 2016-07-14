package com.openmart.core.configurations;

import com.openmart.core.security.AppUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/*
 * Created by Sandip on 7/3/16.
*/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

     @Autowired
     AppUserDetailService userDetailService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //TODO commented to disable security
        //auth.userDetailsService(userDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //TODO remove and uncomment Added to disable security.
        http.authorizeRequests().anyRequest().permitAll();
        http.csrf().disable();
       /* http
                .httpBasic().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**").hasRole("CUSTOMER"); */
    }


}
