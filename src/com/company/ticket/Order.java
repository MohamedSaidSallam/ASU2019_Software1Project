package com.company.ticket;

import java.util.ArrayList;

public class Order {

    // region Variables
    private ArrayList<Ticket> tickets = new ArrayList<>();
    // endregion Variables

    // region accessors

    public ArrayList<Ticket> getTickets() {
        return tickets; // todo Return a copy ?
    }

    // endregion accessors

    // region mutators

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    // endregion mutators

    public int getTicketsLength() {
        return tickets.size();
    }

    public float calTotalCost() {
        float totalCost = 0;

        for (Ticket ticket : tickets) {
            totalCost += ticket.getMoviePrice();
        }

        return totalCost;
    }

    public void printTickets() {
        for (Ticket ticket : tickets) {
            ticket.printTicket();
        }
    }

    public void reserveSeats() {
        for (Ticket ticket : tickets) {
            ticket.reserveSeat();
        }
    }
}
