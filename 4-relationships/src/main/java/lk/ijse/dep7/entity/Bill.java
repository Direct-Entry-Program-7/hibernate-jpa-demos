package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Table(name = "bill")
@Entity
public class Bill implements Serializable {

    @Id
    private String id;
    @Column(nullable = false)
    private Date date;

    @OneToMany(mappedBy = "bill", cascade = {CascadeType.PERSIST})
    private List<BillDetail> billDetailList;

    public Bill() {
    }

    public Bill(String id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Bill(String id, Date date, List<BillDetail> billDetailList) {
        this.id = id;
        this.date = date;
        this.billDetailList = billDetailList;
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

    public List<BillDetail> getBillDetailList() {
        return billDetailList;
    }

    @PrePersist
    private void beforePersist() {
        if (billDetailList != null) {
            billDetailList.forEach(bd -> bd.getBillDetailPK().setBillId(this.id));
        }
    }
}
