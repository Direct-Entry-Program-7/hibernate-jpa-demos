package lk.ijse.dep7.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "movie")
@Entity
public class Movie extends SuperClass implements Serializable {

}