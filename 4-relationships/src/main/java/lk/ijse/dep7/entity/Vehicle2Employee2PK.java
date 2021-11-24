package lk.ijse.dep7.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Vehicle2Employee2PK implements Serializable {
    private String number;
    private String id;

    public Vehicle2Employee2PK() {
    }

    public Vehicle2Employee2PK(String number, String id) {
        this.number = number;
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vehicle2Employee2PK{" +
                "number='" + number + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
