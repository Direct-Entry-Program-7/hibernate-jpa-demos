package lk.ijse.dep7.entity;

import java.io.Serializable;

public class CustomEntity implements Serializable {
    private String id;
    private String name;
    private String address;
    private String spouseName;

    public CustomEntity() {
    }

    public CustomEntity(String id, String name, String address, String spouseName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.spouseName = spouseName;
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

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    @Override
    public String toString() {
        return "CustomEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", spouseName='" + spouseName + '\'' +
                '}';
    }
}
