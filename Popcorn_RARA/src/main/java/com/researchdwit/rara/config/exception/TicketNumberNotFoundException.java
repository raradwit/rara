package com.researchdwit.rara.config.exception;

/**
 * Created by saneel on 10/26/15.
 */
public class TicketNumberNotFoundException extends Exception {
    public TicketNumberNotFoundException() {
        super("Ticket not found");
    }
}
