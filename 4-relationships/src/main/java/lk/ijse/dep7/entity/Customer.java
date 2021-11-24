package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table
@Entity(name = "customer")
public class Customer implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    private List<Order> orderList;

    public Customer() {
    }

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Customer(String id, String name, String address, List<Order> orderList) {
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

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        orderList.forEach(o -> o.setCustomer(this));
        this.orderList = orderList;
    }

    public void addOrder(Order order) {
        order.setCustomer(this);
        this.orderList.add(order);
    }

    // @PrePersist, @PostPersist, @PreRemove, @PostRemove, @PreLoad, @PostLoad, @PreUpdate, @PostUpdate
    @PrePersist
    private void beforePersist() {
        if (orderList != null) {
            orderList.forEach(o -> o.setCustomer(this));
        }
    }
}
