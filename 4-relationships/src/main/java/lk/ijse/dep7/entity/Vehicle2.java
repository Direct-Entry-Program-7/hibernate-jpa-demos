package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicle2")
public class Vehicle2 implements Serializable {
    @Id
    private String number;
    @Column(nullable = false)
    private String type;

    @OneToOne(mappedBy = "vehicle2", cascade = CascadeType.PERSIST)
    private Vehicle2Employee2 vehicle2Employee2;

    public Vehicle2() {
    }

    public Vehicle2(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public Vehicle2(String number, String type, Vehicle2Employee2 vehicle2Employee2) {
        this.number = number;
        this.type = type;
        this.vehicle2Employee2 = vehicle2Employee2;
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

    @Override
    public String toString() {
        return "Vehicle2{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Vehicle2Employee2 getVehicle2Employee2() {
        return vehicle2Employee2;
    }

//    public void setVehicle2Employee2(Vehicle2Employee2 vehicle2Employee2) {
//        vehicle2Employee2.setVehicle2(this);
//        this.vehicle2Employee2 = vehicle2Employee2;
//    }
}
