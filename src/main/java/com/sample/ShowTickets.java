package com.sample;

import java.util.*;

/**
 * This code will find show tickets timing
 */
public class ShowTickets {

    /**
     * Calculate time taken for each ticket
     * @param tickets
     * @param position
     * @return
     */
    static int calculateTimer(List<Integer> tickets, int position) {
        int queueLength = tickets.size() - 1;
        int index = 0;
        int timeCounter = 0;

        List<Integer> ticketPosition = setPositionIndicator(queueLength, position);

        while (true) {
            int TicketPositionIndex = findPositionIndex(ticketPosition);
            if (tickets.get(TicketPositionIndex) == 0) {
                break;
            } else {
                int personTicket = tickets.get(index);
                personTicket--;
                if (personTicket >= 0) {
                    timeCounter++;
                }
                tickets.set(index, personTicket);
                rotateTicketQueue(tickets, queueLength);
                rotateIndicatorQueue(ticketPosition, queueLength);
            }
        }
        return timeCounter;
    }

    /**
     * Move the Ticket Queue
     *
     * @param ticketQueue
     * @param queueLength
     * @return
     */
    static List rotateTicketQueue(List<Integer> ticketQueue, int queueLength) {
        Collections.rotate(ticketQueue, queueLength);
        return ticketQueue;
    }

    /**
     * Move the Position Indicator Queue
     *
     * @param ticketPosition
     * @param queueLength
     * @return
     */
    static List rotateIndicatorQueue(List<Integer> ticketPosition, int queueLength) {
        Collections.rotate(ticketPosition, queueLength);
        return ticketPosition;
    }

    /**
     * Get current position Index
     *
     * @param ticketPosition
     * @return
     */
    static int findPositionIndex(List<Integer> ticketPosition) {
        int indexCount = 0;
        for (int index : ticketPosition) {
            if (index == 1) {
                break;
            }
            indexCount++;
        }
        return indexCount;
    }

    /**
     * setting position Indicator
     *
     * @param length
     * @param position
     * @return
     */
    static List setPositionIndicator(int length, int position) {
        List<Integer> ticketPosition = new ArrayList();
        for (int i = 0; i <= length; i++) {
            if (i == position) ticketPosition.add(1);
            else
                ticketPosition.add(0);
        }
        return ticketPosition;
    }
}