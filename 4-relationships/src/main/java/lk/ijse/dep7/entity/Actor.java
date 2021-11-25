package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "actor")
@Entity
public class Actor extends SuperClass implements Serializable {

    @ManyToMany
    @JoinTable(name = "actor_movie",
            joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private List<Movie> movieList;

    public Actor() {
    }

    public Actor(String id, String name, List<Movie> movieList) {
        super(id, name);
        this.movieList = movieList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "super=" + super.toString() + "," +
                "movieList=" + movieList +
                '}';
    }
}
