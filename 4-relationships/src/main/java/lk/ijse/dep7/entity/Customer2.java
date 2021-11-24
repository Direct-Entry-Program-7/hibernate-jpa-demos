package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "customer2")
public class Customer2 implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @OneToMany(mappedBy = "customer")
    private List<Order2> orderList = new ArrayList<>();

    public Customer2() {
    }

    public Customer2(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Customer2(String id, String name, String address, List<Order2> orderList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.orderList = orderList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public List<Order2> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order2> orderList) {
        orderList.forEach(o -> o.setCustomer(this));
        this.orderList = orderList;
    }

    public void addOrder(Order2 order2){
        order2.setCustomer(this);
        this.orderList.add(order2);
    }

    public void removeOrder(Order2 order2){
        this.orderList.remove(order2);
        order2.setCustomer(null);
    }
}
