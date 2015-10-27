package com.researchdwit.rara.core;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * Created by saneel on 10/26/15.
 */
public class Ticket implements TicketDetails {
    private String ticketNumber;
    private String movieStartTime;
    private String movieEndTime;
    private boolean ticketExpired;

    private final Set<GrantedAuthority> authorities;

    public Ticket(String ticketNumber,Collection<? extends GrantedAuthority> authorities,Boolean ticketExpired) {
        this.ticketNumber = ticketNumber;
        this.authorities= Collections.unmodifiableSet(sortAuthorities(authorities));
        this.ticketExpired=ticketExpired;

    }

    public String getMovieStartTime() {
        return movieStartTime;
    }

    public void setMovieStartTime(String movieStartTime) {
        this.movieStartTime = movieStartTime;
    }

    public String getMovieEndTime() {
        return movieEndTime;
    }

    public void setMovieEndTime(String movieEndTime) {
        this.movieEndTime = movieEndTime;
    }



    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String getTicketNumber() {
        return this.ticketNumber;
    }

    @Override
    public boolean isTicketExpired() {
        return this.ticketExpired;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_TICKET");
        return Arrays.asList(authority);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(": ");
        sb.append("ticketNumber: ").append(this.ticketNumber).append("; ");

        return sb.toString();
    }

    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        // Ensure array iteration order is predictable (as per UserDetails.getAuthorities() contract and SEC-717)
        SortedSet<GrantedAuthority> sortedAuthorities =
                new TreeSet<GrantedAuthority>(new AuthorityComparator());

        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }

        return sortedAuthorities;
    }

    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            // Neither should ever be null as each entry is checked before adding it to the set.
            // If the authority is null, it is a custom authority and should precede others.
            if (g2.getAuthority() == null) {
                return -1;
            }

            if (g1.getAuthority() == null) {
                return 1;
            }

            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }
}
