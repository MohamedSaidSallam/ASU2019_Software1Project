package com.company.cinema;

import java.sql.Time;
import java.util.ArrayList;

public final class Session { //todo enum ? (idk how runtime enums work)

    // region variables
    private static ArrayList<Time> availableSessions = new ArrayList<>();
    // endregion variables

    // region Constructor
    private Session() {

    }
    // endregion Constructor

    // region accessors
    public static Time[] getAvailableSessions() {
        return (Time[]) availableSessions.toArray(); //todo might be wasting memory
    }
    // endregion accessors


    public static void Initialize() {
        //todo implement (Read from json)
        throw new UnsupportedOperationException();
    }
}
