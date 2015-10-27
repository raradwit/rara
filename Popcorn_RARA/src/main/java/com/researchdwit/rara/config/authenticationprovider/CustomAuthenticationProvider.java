package com.researchdwit.rara.config.authenticationprovider;

import com.researchdwit.rara.config.authenticationdetails.CustomWebAuthenticationDetails;
import com.researchdwit.rara.config.authenticationtoken.TicketNumberAuthenticationToken;
import com.researchdwit.rara.config.exception.TicketNumberNotFoundException;
import com.researchdwit.rara.core.TicketDetails;
import com.researchdwit.rara.service.TicketService;
import com.researchdwit.rara.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by saneel on 10/26/15.
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;

    @Autowired
    TicketService ticketService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException,ClassCastException {
        String userName = authentication.getName().trim();
        String ticketNumber = ((CustomWebAuthenticationDetails)authentication.getDetails()).getTicketNumber();

        Authentication auth = null;

        if(userName!="" ){
            UserDetails user = userService.loadUserByUsername(userName);

            if(user == null) {
                throw  new BadCredentialsException("Username not found");
            }

            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            auth = new UsernamePasswordAuthenticationToken(user,authentication.getCredentials().toString().trim(),authorities);
            System.out.println("\n\n===========UsernamePasswordAuthenticationToken=========");
            System.out.println(auth);
            System.out.println("===========UsernamePasswordAuthenticationToken complete=========\n\n");

        }else if(ticketNumber!=null) {
            try {
                TicketDetails ticket = ticketService.loadTicketByTicketNumber(ticketNumber);
                System.out.println("\n\n==========CustomAuthProvider=========");
                System.out.println("ticket authority: "+ticket.getAuthorities());
                System.out.println("ticket number: "+ticket.getTicketNumber());
                System.out.println("ticket expired: "+ticket.isTicketExpired());
                System.out.println("==========CustomAuthProvider complete=========\n\n");
                if(ticket.isTicketExpired()) {
                    throw  new BadCredentialsException("Ticket expired");
                }else {
                    auth = new TicketNumberAuthenticationToken(ticket.getTicketNumber(),ticket.isTicketExpired(),ticket.getAuthorities());
                }

            } catch (TicketNumberNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("\n\n=========TicketNumberAuthenticationToken==========");
            System.out.println(auth);
            System.out.println("=========TicketNumberAuthenticationToken complete==========\n\n");


        }

        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        if(authentication.equals(UsernamePasswordAuthenticationToken.class)){
            return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
        }else{
            return TicketNumberAuthenticationToken.class.isAssignableFrom(authentication);
        }
    }
}
