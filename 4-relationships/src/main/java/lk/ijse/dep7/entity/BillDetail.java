package lk.ijse.dep7.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "bill_detail")
@Entity
public class BillDetail implements Serializable {

    @EmbeddedId
    private BillDetailPK billDetailPK;
    @Column(nullable = false)
    private int qty;
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    public BillDetail() {
    }

    public BillDetail(BillDetailPK billDetailPK, int qty, BigDecimal unitPrice) {
        this.billDetailPK = billDetailPK;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public BillDetail(String itemCode, String billId, int qty, BigDecimal unitPrice) {
        this.billDetailPK = new BillDetailPK(itemCode, billId);
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public BillDetailPK getBillDetailPK() {
        return billDetailPK;
    }

    public void setBillDetailPK(BillDetailPK billDetailPK) {
        this.billDetailPK = billDetailPK;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "billDetailPK=" + billDetailPK +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
