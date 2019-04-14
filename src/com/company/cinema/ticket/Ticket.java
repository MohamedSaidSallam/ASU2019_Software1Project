package com.company.cinema.ticket;

import com.company.cinema.Movie;
import com.company.cinema.Seat;
import com.company.prototyping.HardwareProto;

import java.util.Date;

public class Ticket {

    //region Variables
    private int id;
    private Date date;
    private Movie movie;
    private Seat seat;
    private int sessionIndex;
    private int hallIndex;
    // endregion Variables

    // region Constructor

    public Ticket(int id, Date date, Movie movie, Seat seat, int sessionIndex, int hallIndex) {
        this.id = id;
        this.date = date;
        this.movie = movie;
        this.seat = seat;
        this.sessionIndex = sessionIndex;
        this.hallIndex = hallIndex;
    }

    // endregion Constructor

    // region accessors

    public int getId() {
        return id;
    }

    public Date getDate() {
        return (Date) date.clone();//todo Might be a waste of memory
    }

    public Movie getMovie() {
        return movie;//todo clone ?
    }

    public Seat getSeat() {
        return seat;//todo clone ?
    }

    public int getSessionIndex() {
        return sessionIndex;
    }

    public int getHallIndex() {
        return hallIndex;
    }

    // endregion accessors

    // region mutators

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setSessionIndex(int sessionIndex) {
        this.sessionIndex = sessionIndex;
    }

    public void setHallIndex(int hallIndex) {
        this.hallIndex = hallIndex;
    }

    // endregion mutators

    private int generateTicketID() {
        //todo implement
        throw new UnsupportedOperationException();
    }

    public void printTicket() {
        HardwareProto.printTicket("");
        //todo implement
        throw new UnsupportedOperationException();
    }

    public void reserveSeat() {
        seat.setAvailable(false);

        //todo implement
        throw new UnsupportedOperationException();
    }

}
