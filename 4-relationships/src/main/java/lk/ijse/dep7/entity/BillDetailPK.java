package lk.ijse.dep7.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BillDetailPK implements Serializable {
    @Column(name = "item_code")
    private String itemCode;
    @Column(name = "bill_id")
    private String billId;

    public BillDetailPK() {
    }

    public BillDetailPK(String itemCode, String billId) {
        this.itemCode = itemCode;
        this.billId = billId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    @Override
    public String toString() {
        return "BillDetailPK{" +
                "itemCode='" + itemCode + '\'' +
                ", billId='" + billId + '\'' +
                '}';
    }
}
