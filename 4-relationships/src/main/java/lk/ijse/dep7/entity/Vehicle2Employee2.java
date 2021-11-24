package lk.ijse.dep7.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="vehicle2_employee2")
public class Vehicle2Employee2 implements Serializable {

    @EmbeddedId
    private Vehicle2Employee2PK vehicle2Employee2PK;
    private Date date;

    public Vehicle2Employee2() {
    }

    public Vehicle2Employee2(Vehicle2Employee2PK vehicle2Employee2PK, Date date) {
        this.vehicle2Employee2PK = vehicle2Employee2PK;
        this.date = date;
    }

    public Vehicle2Employee2(String number, String id, Date date) {
        this.vehicle2Employee2PK = new Vehicle2Employee2PK(number, id);
        this.date = date;
    }

    public Vehicle2Employee2PK getVehicle2Employee2PK() {
        return vehicle2Employee2PK;
    }

    public void setVehicle2Employee2PK(Vehicle2Employee2PK vehicle2Employee2PK) {
        this.vehicle2Employee2PK = vehicle2Employee2PK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Vehicle2Employee2{" +
                "vehicle2Employee2PK=" + vehicle2Employee2PK +
                ", date=" + date +
                '}';
    }
}
