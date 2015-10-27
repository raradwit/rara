package com.researchdwit.rara.service;

import com.researchdwit.rara.config.exception.TicketNumberNotFoundException;
import com.researchdwit.rara.core.Ticket;
import com.researchdwit.rara.core.TicketDetails;
import com.researchdwit.rara.core.TicketDetailsService;
import com.researchdwit.rara.model.TicketInfo;
import com.researchdwit.rara.service.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by saneel on 10/26/15.
 */
@Service
public class TicketService implements TicketDetailsService {
    @Autowired
    private TicketDao ticketDao;

    @Override
    public TicketDetails loadTicketByTicketNumber(String ticketNumber) throws TicketNumberNotFoundException {
        TicketInfo ticketInfo = ticketDao.getTicketInfo(ticketNumber);
        GrantedAuthority authority = new SimpleGrantedAuthority(ticketInfo.getRole());
        TicketDetails ticketDetails = new Ticket(ticketNumber, Arrays.asList(authority),ticketInfo.isTicketExpired());

        System.out.println("\n\n==============Ticket info received=================");
        System.out.println("ticket number: "+ticketInfo.getTicketNumber());
        System.out.println("ticket time: "+ticketInfo.getTicketTime());
        System.out.println("ticket role: "+ticketInfo.getRole());
        System.out.println("ticket expired: "+ticketInfo.isTicketExpired());
        System.out.println("==============Ticket info complete=================\n\n");

        return ticketDetails;
    }
}