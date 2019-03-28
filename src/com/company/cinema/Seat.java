package com.company.cinema;

public class Seat {
    // region variables
    private String column;
    private String row;
    private boolean available;
    // endregion variables

    // region Constructor

    public Seat(String column, String row, boolean available) {
        this.column = column;
        this.row = row;
        this.available = available;
    }

    public Seat(String column, String row) {
        this.column = column;
        this.row = row;
        this.available = true;
    }
    // endregion Constructor

    // region accessors

    public String getColumn() {
        return column;
    }

    public String getRow() {
        return row;
    }

    public boolean isAvailable() {
        return available;
    }
    // endregion accessors

    // region mutators

    public void setColumn(String column) {
        this.column = column;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    // endregion mutators
}
