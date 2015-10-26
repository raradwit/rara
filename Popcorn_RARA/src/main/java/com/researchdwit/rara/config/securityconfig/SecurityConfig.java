package com.researchdwit.rara.config.securityconfig;

import com.researchdwit.rara.config.authenticationdetails.CustomAuthenticationDetailsSource;
import com.researchdwit.rara.config.authenticationprovider.CustomAuthenticationProvider;
import com.researchdwit.rara.config.authenticationsuccesshandler.CustomAuthenticationSuccessHandler;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * Created by saneel on 9/21/15.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Autowired
    CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    CustomAuthenticationDetailsSource customAuthenticationDetailsSource;

    @Autowired
    CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/images/**").permitAll();
        http.authorizeRequests().antMatchers("/js/**").permitAll();
        http.authorizeRequests().antMatchers("/css/**").permitAll();

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin", "/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/user", "/user/**").access("hasRole('ROLE_USER')")
                .antMatchers("/manager", "/manager/**").access("hasRole('ROLE_MANAGER')")
                .antMatchers("/clerk", "/clerk/**").access("hasRole('ROLE_CLERK')")
                .antMatchers("/ticket", "/ticket/**").access("hasRole('ROLE_TICKET')")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage("/login")
                .authenticationDetailsSource(customAuthenticationDetailsSource)
                .successHandler(customAuthenticationSuccessHandler)
                .permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }



}
