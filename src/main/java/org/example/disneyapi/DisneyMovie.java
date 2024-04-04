package org.example.disneyapi;

// DisneyMovie class (super class)
public class DisneyMovie {
    // instance variables
    private int movieId;
    private String title;
    private String year;
    private String image;
    private String rating;

    // constructor
    public DisneyMovie(int movieId, String title, String year, String image, String rating) {
        this.movieId = movieId;
        this.title = title;
        this.year = year;
        this.image = image;
        this.rating = rating;
    }

    // getters and setters
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    // toString() method to display it as a searched result
    @Override
    public String toString() {
        return
                title + " " + year ;
    }
}
