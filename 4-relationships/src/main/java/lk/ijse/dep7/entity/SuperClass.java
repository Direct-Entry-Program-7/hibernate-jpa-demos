package lk.ijse.dep7.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class SuperClass implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;

    public SuperClass() {
    }

    public SuperClass(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "SuperClass{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
