package DTO;

public class MenuDTO {

    public int id;
    public String name;
    public int type;
    public int price;
    public String status;
    public String image;

    public MenuDTO() {
    }

    public MenuDTO(int id, String name, int type, int price, String status, String image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.status = status;
        this.image = image;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
