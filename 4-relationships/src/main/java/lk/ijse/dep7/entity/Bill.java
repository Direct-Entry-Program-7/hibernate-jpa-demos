package lk.ijse.dep7.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Table(name = "bill")
@Entity
public class Bill implements Serializable {

    @Id
    private String id;
    @Column(nullable = false)
    private Date date;

    public Bill() {
    }

    public Bill(String id, Date date) {
        this.id = id;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", date=" + date +
                '}';
    }
}
