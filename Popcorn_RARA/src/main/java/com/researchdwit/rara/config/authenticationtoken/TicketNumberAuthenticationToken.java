package com.researchdwit.rara.config.authenticationtoken;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by saneel on 10/26/15.
 */
public class TicketNumberAuthenticationToken extends AbstractAuthenticationToken {
    private Object ticketNumber;
    private Object isTicketExpired;
    private  Object authorities;

    public TicketNumberAuthenticationToken(Object ticketNumber,Object isTicketExpired){
        super(null);
        this.ticketNumber = ticketNumber;
        this.isTicketExpired = isTicketExpired;
        setAuthenticated(false);
    }

    /**
     * Creates a authenticationtoken with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the
     *                    principal represented by this authentication object.
     */
    public TicketNumberAuthenticationToken(Object ticketNumber,Object isTicketExpired,Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.ticketNumber = ticketNumber;
        this.isTicketExpired = isTicketExpired;
        this.authorities = authorities;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.ticketNumber;
    }
}
