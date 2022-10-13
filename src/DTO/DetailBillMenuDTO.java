package DTO;

public class DetailBillMenuDTO {
    private int idItem;
    private String name;
    private int price;
    private int quantity;

    public DetailBillMenuDTO() {
    }

    public DetailBillMenuDTO(int idItem, String name, int price, int quantity) {
        this.idItem = idItem;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
