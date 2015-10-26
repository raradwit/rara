package com.researchdwit.rara.service.dao;

import com.researchdwit.rara.model.TicketInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by saneel on 10/26/15.
 */
@Repository
public class TicketDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public TicketInfo getTicketInfo(String ticketNumber) {
        String sql = "select t.ticket_number,m.start_time,m.end_time from ticket as t inner join movie_show as m on t.id=m.ticket_id where t.ticket_number=?;";

        TicketInfo ticketInfo = jdbcTemplate.queryForObject(sql, new Object[]{ticketNumber}, new RowMapper<TicketInfo>() {
            @Override
            public TicketInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                TicketInfo ticket = new TicketInfo();
                ticket.setTicketNumber(rs.getString("ticket_number"));
                ticket.setTicketTime(rs.getString("start_time")+"-"+rs.getString("end_time"));
                ticket.setRole("ROLE_TICKET");

                String startTime = rs.getString("start_time").toString();
                String endTime = rs.getString("end_time").toString();
                String currentTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

                System.out.println("starttime: "+startTime);
                System.out.println("endtime: "+endTime);
                System.out.println("currenttime: "+currentTime);

                try {

                    boolean result = isTimeBetweenTwoTime(startTime,endTime,currentTime);
                    System.out.println("result : "+result);
                    if(result){
                        ticket.setTicketExpired(false);
                    }else {
                        ticket.setTicketExpired(true);
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }


                return ticket;
            }
        });

        return ticketInfo;
    }

    public boolean isTimeBetweenTwoTime(String argStartTime, String argEndTime, String argCurrentTime) throws ParseException {
        String reg = "^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
        //
        if (argStartTime.matches(reg) && argEndTime.matches(reg) && argCurrentTime.matches(reg)) {
            boolean valid = false;
            // Start Time
            java.util.Date startTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(argStartTime);
            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(startTime);

            // Current Time
            java.util.Date currentTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(argCurrentTime);
            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTime(currentTime);

            // End Time
            java.util.Date endTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(argEndTime);
            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(endTime);

            //
            if (currentTime.compareTo(endTime) < 0) {

                currentCalendar.add(Calendar.DATE, 1);
                currentTime = currentCalendar.getTime();

            }

            if (startTime.compareTo(endTime) < 0) {

                startCalendar.add(Calendar.DATE, 1);
                startTime = startCalendar.getTime();

            }
            //
            if (currentTime.before(startTime)) {

                System.out.println(" Time is Lesser ");

                valid = false;
            } else {

                if (currentTime.after(endTime)) {
                    endCalendar.add(Calendar.DATE, 1);
                    endTime = endCalendar.getTime();

                }

                System.out.println("Comparing , Start Time /n " + startTime);
                System.out.println("Comparing , End Time /n " + endTime);
                System.out.println("Comparing , Current Time /n " + currentTime);

                if (currentTime.before(endTime)) {
                    System.out.println("RESULT, Time lies b/w");
                    valid = true;
                } else {
                    valid = false;
                    System.out.println("RESULT, Time does not lies b/w");
                }

            }
            return valid;

        } else {
            throw new IllegalArgumentException(
                    "Not a valid time, expecting HH:MM:SS format");
        }

    }


}
