package com.researchdwit.rara.core;

import com.researchdwit.rara.config.exception.TicketNumberNotFoundException;

/**
 * Created by saneel on 10/26/15.
 */
public interface TicketDetailsService {
    TicketDetails loadTicketByTicketNumber(String ticketNumber) throws TicketNumberNotFoundException;
}
