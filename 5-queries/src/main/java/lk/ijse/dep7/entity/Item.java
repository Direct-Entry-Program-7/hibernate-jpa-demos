package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "item")
@Entity
public class Item implements Serializable {

    @Id
    private String code;
    @Column(nullable = false)
    private String description;
    @Column(name = "qty_on_hand", nullable = false)
    private int qtyOnHand;
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @OneToMany(mappedBy = "item", cascade = {CascadeType.PERSIST})
    private List<BillDetail> billDetailList;

    public Item() {
    }

    public Item(String code, String description, int qtyOnHand, BigDecimal unitPrice) {
        this.code = code;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
    }

    public Item(String code, String description, int qtyOnHand, BigDecimal unitPrice, List<BillDetail> billDetailList) {
        this.code = code;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
        this.billDetailList = billDetailList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public List<BillDetail> getBillDetailList() {
        return billDetailList;
    }

    @PrePersist
    private void beforePersist() {
        if (billDetailList != null) {
            billDetailList.forEach(bd -> bd.getBillDetailPK().setItemCode(this.code));
        }
    }

}
