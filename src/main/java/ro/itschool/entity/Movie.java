package ro.itschool.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    @Column(nullable = false)
    private String movieTitle;

    @Column(nullable = false)
    private String movieGenre;


    @Column(nullable = false)
    private String cast;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String yearRelease;

    @Column(nullable = false)
    private String length;


    @Column(nullable = false)
    private String description;


    @Column(nullable = false)
    private String imdbRating;

    @Column(nullable = true, length = 64)
    private String photos;
    @Transient
    public String getPhotosImagePath() {
        if (photos == null);

        return "/movie-photos/" + id + "/" + photos;
    }

//   ---------------------------------------------------------------

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDirector() {return director;}

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(String yearRelease) {
        this.yearRelease = yearRelease;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }
}
