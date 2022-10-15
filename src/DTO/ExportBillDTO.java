package DTO;

public class ExportBillDTO {
    public String item;
    public int quanity;
    public int price;
    public int subtotal;
    public String date;
    public String by;
    public int sum;

    public ExportBillDTO() {
    }

    public ExportBillDTO(String item, int quanity, int price, int subtotal, String date, String by, int sum) {
        this.item = item;
        this.quanity = quanity;
        this.price = price;
        this.subtotal = subtotal;
        this.date = date;
        this.by = by;
        this.sum = sum;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
    
    
}
