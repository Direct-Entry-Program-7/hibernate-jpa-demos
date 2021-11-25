package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "`order2`")
public class Order2 implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private Date date;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "customer2_order2",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
    private Customer2 customer;

    public Order2() {
    }

    public Order2(String id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Order2(String id, Date date, Customer2 customer) {
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

    public Customer2 getCustomer() {
        return customer;
    }

    public void setCustomer(Customer2 customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order2{" +
                "id='" + id + '\'' +
                ", date=" + date +
                '}';
    }
}
