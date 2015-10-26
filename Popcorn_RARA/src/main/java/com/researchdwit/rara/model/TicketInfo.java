package com.researchdwit.rara.model;

/**
 * Created by saneel on 10/26/15.
 */
public class TicketInfo {
    private String ticketNumber;
    private String ticketTime;
    private String role;
    private boolean ticketExpired;

    public boolean isTicketExpired() {
        return ticketExpired;
    }

    public void setTicketExpired(boolean ticketExpired) {
        this.ticketExpired = ticketExpired;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(String ticketTime) {
        this.ticketTime = ticketTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
