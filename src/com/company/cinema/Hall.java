package com.company.cinema;

public class Hall {
    // region variables
    private int id;
    private String name;
    private int capacity;
    private Seat[] seats;
    // endregion variables

    // region Constructor

    public Hall(int id, String name, int capacity, Seat[] seats) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.seats = seats;
    }

    // endregion Constructor

    // region accessors

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Seat[] getSeats() {
        return seats;
    }
    // endregion accessors

    // region mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }
    // endregion mutators

    public int getNumOfBookedSeats() { //todo rewrite if it's called a lot

        int BookedSeats = 0;

        for (Seat seat : seats) {
            if (!seat.isAvailable()) {
                BookedSeats++;
            }
        }

        return BookedSeats;
    }
}
