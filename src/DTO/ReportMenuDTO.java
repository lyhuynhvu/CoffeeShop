package DTO;

public class ReportMenuDTO {

    public int id;
    public String name;
    public int price;
    public String img;
    public int amount;

    public ReportMenuDTO() {
    }

    public ReportMenuDTO(int id, String name, int price, String img, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
