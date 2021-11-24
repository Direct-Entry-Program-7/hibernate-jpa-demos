package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "`order`")
public class Order implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private Date date;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    public Order() {
    }

    public Order(String id, Date date, Customer customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }
}
