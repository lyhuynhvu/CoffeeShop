package DTO;

public class BillDetailDTO {

    public int id;
    public int billId;
    public String item;
    public int quanity;
    public int subtotal;
    public String note;

    public BillDetailDTO() {
    }

    public BillDetailDTO(int id, int billId, String item, int quanity, int subtotal, String note) {
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
