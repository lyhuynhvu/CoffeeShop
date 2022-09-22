package DTO;

public class BillDetailDTO {
    public int id;
    public int billId;
    public int item;
    public int quanity;
    public float subtotal;
    public String note;

    public BillDetailDTO() {
    }

    public BillDetailDTO(int id, int billId, int item, int quanity, float subtotal, String note) {
        this.id = id;
        this.billId = billId;
        this.item = item;
        this.quanity = quanity;
        this.subtotal = subtotal;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
