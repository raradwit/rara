package com.researchdwit.rara.config.beanconfig;

import com.researchdwit.rara.config.authenticationdetails.CustomAuthenticationDetailsSource;
import com.researchdwit.rara.config.authenticationprovider.CustomAuthenticationProvider;
import com.researchdwit.rara.config.authenticationsuccesshandler.CustomAuthenticationSuccessHandler;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by saneel on 9/21/15.
 */
@Configuration
/*@ComponentScan({ "com.researchdwit.rara.controller.*" })
@Import({ SecurityConfig.class })*/
public class AppConfig {
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setUrl(dataSourceUrl);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driverClassName);

        return ds;
    }

    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider();
    }

    @Bean
    public CustomAuthenticationDetailsSource customAuthenticationDetailsSource() {
        return  new CustomAuthenticationDetailsSource();
    }

    @Bean
    public CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

}