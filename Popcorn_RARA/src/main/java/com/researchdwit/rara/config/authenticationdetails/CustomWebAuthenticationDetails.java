package com.researchdwit.rara.config.authenticationdetails;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by saneel on 10/26/15.
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    private final String ticketNumber;

    /**
     * Records the remote address and will also set the session Id if a session
     * already exists (it won't create one).
     *
     * @param request that the authentication request was received from
     */
    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        this.ticketNumber=request.getParameter("ticket_number");
    }

    public String getTicketNumber() {
        return ticketNumber;
    }
}
