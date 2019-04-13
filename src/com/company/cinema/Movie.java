package com.company.cinema;

public class Movie {

    public class Info {
        private String name;
        private MPAA rating;
        private int duration;
        private String trailer; //todo should be a url or relative path to the local video file
        private String plot;
        private float IMDBscore;
        private int metascore;
        private int tomatometer;
        private Genre[] genres;
        private String[] actors;
        private String[] writers;
        private String director;


        //But wait!! There's more

        // region Constructor

        public Info(String name, MPAA rating, int duration, String trailer, String plot, float IMDBscore, int metascore, int tomatometer, Genre[] genres, String[] actors, String[] writers, String director) {
            this.name = name;
            this.rating = rating;
            this.duration = duration;
            this.trailer = trailer;
            this.plot = plot;
            this.IMDBscore = IMDBscore;
            this.metascore = metascore;
            this.tomatometer = tomatometer;
            this.genres = genres;
            this.actors = actors;
            this.writers = writers;
            this.director = director;
        }

        // endregion Constructor

        // region accessors

        public float getIMDBscore() {
            return IMDBscore;
        }

        public int getMetascore() {
            return metascore;
        }

        public int getTomatometer() {
            return tomatometer;
        }

        public String[] getActors() {
            return actors;
        }

        public String[] getWriters() {
            return writers;
        }

        public String getDirector() {
            return director;
        }

        public int getDuration() {
            return duration;
        }

        public String getName() {
            return name;
        }

        public MPAA getRating() {
            return rating;
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

        public void setActors(String[] actors) {
            this.actors = actors;
        }

        public void setWriters(String[] writers) {
            this.writers = writers;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setRating(MPAA rating) {
            this.rating = rating;
        }

        public void setPlot(String plot) {
            this.plot = plot;
        }

        public void setIMDBscore(float IMDBscore) {
            this.IMDBscore = IMDBscore;
        }

        public void setMetascore(int metascore) {
            this.metascore = metascore;
        }

        public void setTomatometer(int tomatometer) {
            this.tomatometer = tomatometer;
        }

        public void setTrailer(String trailer) {
            this.trailer = trailer;
        }

        public void setGenres(Genre[] genres) {
            this.genres = genres;
        }
        // endregion mutators
    }

    private int id;
    private boolean available;
    private int[] availableSessionsIndices;

    private ViewingOption[] viewingOptions;
    private Info info;

    //endregion Variables

    // region Constructor

    public Movie(int id, boolean available, int[] availableSessionsIndices, ViewingOption[] viewingOptions, String name, MPAA rating, int duration, String trailer, String plot, float IMDBscore, int metascore, int tomatometer, Genre[] genres, String[] actors, String[] writers, String directors) {
        this.id = id;
        this.available = available;
        this.availableSessionsIndices = availableSessionsIndices;
        this.viewingOptions = viewingOptions;
        this.info = new Info(name, rating, duration, trailer, plot, IMDBscore, metascore, tomatometer, genres, actors, writers, directors);
    }

    // endregion Constructor

    //region accessors

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public Info getInfo() {
        return info;
    }

    public ViewingOption[] getViewingOptions() {
        return viewingOptions;
    }

    public int[] getAvailableSessionsIndices() {
        return availableSessionsIndices;
    }
    //endregion accessors

    //region mutators

    public void setId(int id) {
        this.id = id;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setViewingOptions(ViewingOption[] viewingOptions) {
        this.viewingOptions = viewingOptions;
    }

    public void setAvailableSessionsIndices(int[] availableSessionsIndices) {
        this.availableSessionsIndices = availableSessionsIndices;
    }

    //endregion mutators

    public String getGenresString(){
        StringBuilder strBuilder = new StringBuilder();
        for (Genre genre: info.getGenres()) {
            strBuilder.append(genre.toString());
            strBuilder.append(", ");
        }
        strBuilder.setLength(strBuilder.length() - 2);
        return strBuilder.toString();
    }

    public String getWritersString() {
        StringBuilder strBuilder = new StringBuilder();
        for (String writer : info.getWriters()) {
            strBuilder.append(writer);
            strBuilder.append(", ");
        }
        strBuilder.setLength(strBuilder.length() - 2);
        return strBuilder.toString();
    }

    public String getActorsString() {
        StringBuilder strBuilder = new StringBuilder();
        for (String actor : info.getActors()) {
            strBuilder.append(actor);
            strBuilder.append(", ");
        }
        strBuilder.setLength(strBuilder.length() - 2);
        return strBuilder.toString();
    }
}
