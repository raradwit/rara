package com.researchdwit.rara.core;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by saneel on 10/26/15.
 */
public interface TicketDetails extends Serializable {
    String getTicketNumber();
    boolean isTicketExpired();
    Collection<? extends GrantedAuthority> getAuthorities();
}