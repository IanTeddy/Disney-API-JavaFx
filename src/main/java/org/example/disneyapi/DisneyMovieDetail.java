package org.example.disneyapi;

// Disney movie detail class which is subclass of DisneyMovie class
public class DisneyMovieDetail extends DisneyMovie{
    // object keys of JSON data (instance variables)
    private String link;
    private String runtime;
    private String genre;
    private String summary;
    private String metascore;
    private String directors;
    private String stars;

    // constructor
    public DisneyMovieDetail(int movieId, String title, String year, String link, String image, String runtime, String genre, String summary, String rating, String metascore, String directors, String stars) {
        super(movieId, title, year, image, rating);
        this.link = link;
        this.runtime = runtime;
        this.genre = genre;
        this.summary = summary;
        this.metascore = metascore;
        this.directors = directors;
        this.stars = stars;
    }



    // Add getters, setters, and a toString method for display.
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // toString method
    @Override
    public String toString() {
        return "DisneyMovie{" +
                "movieId=" + getMovieId() +
                ", title='" + getTitle() + '\'' +
                ", year='" + getYear() + '\'' +
                ", link='" + link + '\'' +
                ", image='" + getImage() + '\'' +
                ", runtime='" + runtime + '\'' +
                ", summary='" + summary + '\'' +
                ", rating='" + getRating() + '\'' +
                ", metascore='" + metascore + '\'' +
                ", directors='" + directors + '\'' +
                ", stars='" + stars + '\'' +
                '}';
    }
}
