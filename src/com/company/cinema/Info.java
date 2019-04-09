package com.company.cinema;

public class Info {
    private String name;
    private int duration;
    private String trailer; //todo should be a url or relative path to the local video file
    private String plot;
    private float score;
    private Genre[] genres;


    //But wait!! There's more

    // region Constructor

    public Info(String name, int duration, String trailer, String plot, float score, Genre[] genres) {
        this.name = name;
        this.duration = duration;
        this.trailer = trailer;
        this.plot = plot;
        this.score = score;
        this.genres = genres;

    }

    // endregion Constructor

    // region accessors

    public float getScore() {
        return score;
    }

    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public String getPlot() {
        return plot;
    }

    public String getTrailer() {
        return trailer;
    }

    public Genre[] getGenres() {
        return genres;
    }
    // endregion accessors

    // region mutators

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }
    // endregion mutators
}