package com.sample;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test cases on buying show tickets.
 */
public class ShowTicketsTest {

    @Test
    public void test5TicketQueuePosition2() {
        ShowTickets ticketObj = new ShowTickets();
        List<Integer> tickets = Arrays.asList(2, 6, 3, 4, 5);
        int position = 2;
        int timeCounter = ticketObj.calculateTimer(tickets, position);
        assertEquals(12, timeCounter);
    }

    @Test
    public void test1TicketQueuePosition0() {
        ShowTickets ticketObj = new ShowTickets();
        List<Integer> tickets = Arrays.asList(13);
        int position = 0;
        int timeCounter = ticketObj.calculateTimer(tickets, position);
        assertEquals(13, timeCounter);
    }

    @Test
    public void test3TicketQueuePosition1() {
        ShowTickets ticketObj = new ShowTickets();
        List<Integer> tickets = Arrays.asList(1, 2, 5);
        int position = 1;
        int timeCounter = ticketObj.calculateTimer(tickets, position);
        assertEquals(4, timeCounter);
    }
}
