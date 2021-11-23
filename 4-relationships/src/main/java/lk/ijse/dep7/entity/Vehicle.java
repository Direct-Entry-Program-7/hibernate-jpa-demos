package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {
    @Id
    private String number;
    @Column(nullable = false)
    private String type;

    public Vehicle() {
    }

    public Vehicle(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
