package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Table(name = "actor")
@Entity
public class Actor extends SuperClass implements Serializable {

    @ManyToMany
    @JoinTable(name = "actor_movie",
            joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private Set<Movie> movieList;

    public Actor() {
    }

    public Actor(String id, String name, Set<Movie> movieList) {
        super(id, name);
        this.movieList = movieList;
    }

    public Set<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(Set<Movie> movieList) {
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
