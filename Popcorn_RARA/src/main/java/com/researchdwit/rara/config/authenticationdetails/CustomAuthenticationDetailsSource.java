package com.researchdwit.rara.config.authenticationdetails;

import org.springframework.security.authentication.AuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by saneel on 10/26/15.
 */
public class CustomAuthenticationDetailsSource implements AuthenticationDetailsSource {

    @Override
    public Object buildDetails(Object context) {
        return new CustomWebAuthenticationDetails((HttpServletRequest) context);
    }

}
