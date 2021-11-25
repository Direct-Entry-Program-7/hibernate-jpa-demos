package lk.ijse.dep7.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "movie")
@Entity
public class Movie extends SuperClass implements Serializable {

    @ManyToMany(mappedBy = "movieList")
    private List<Actor> actorList = new ArrayList<>();

    public Movie() {
    }

    public Movie(String id, String name) {
        super(id, name);
    }

    public Movie(String id, String name, List<Actor> actorList) {
        super(id, name);
        this.actorList = actorList;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        actorList.forEach(actor -> actor.getMovieList().add(this));
        this.actorList = actorList;
    }

    public void addActor(Actor actor){
        actorList.add(actor);
        actor.getMovieList().add(this);
    }

    public void removeActor(Actor actor){
        actor.getMovieList().remove(this);
        this.actorList.remove(actor);
    }
}