package classes;


public class Ticket {

    //region Variables
    private int id;
    private String date;
    private Movie movie;
    private Seat seat;
    private int sessionIndex;
    private int hallIndex;
    // endregion Variables

    // region Constructor

    public Ticket(int id, String date, Movie movie, Seat seat, int sessionIndex, int hallIndex) {
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

    public 	String getDate() {
        return  date;//todo Might be a waste of memory
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

    public void setDate(String date) {
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

    public float getMoviePrice() {
        return this.movie.getPrice();
    }

    public void printTicket() {
        HardwareRep.getInstance().printTicket("");
        //todo implement
        throw new UnsupportedOperationException();
    }

    public void reserveSeat() {
        seat.setAvailable(false);

        //todo implement
        throw new UnsupportedOperationException();
    }

}
