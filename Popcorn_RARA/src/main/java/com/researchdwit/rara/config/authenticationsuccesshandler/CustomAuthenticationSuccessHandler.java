package com.researchdwit.rara.config.authenticationsuccesshandler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by saneel on 10/26/15.
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {

    }

    private void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        boolean isUser = false;
        boolean isAdmin = false;
        boolean isTicket = false;
        boolean isManager = false;
        boolean isClerk = false;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if(authorities.isEmpty()){
            isTicket=true;

        }

        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                isUser = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            }else if (grantedAuthority.getAuthority().equals("ROLE_TICKET")) {
                isTicket = true;
                break;
            }else if (grantedAuthority.getAuthority().equals("ROLE_MANAGER")) {
                isManager = true;
                break;
            }else if (grantedAuthority.getAuthority().equals("ROLE_CLERK")) {
                isClerk = true;
                break;
            }
        }

        if (isUser) {
            return "/user";
        } else if (isAdmin) {
            return "/admin";
        } else if(isTicket){
            return "/ticket";
        }else if(isManager){
            return "/manager";
        }else if(isClerk){
            return "/clerk";
        }
        else {
            throw new IllegalStateException();
        }
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}