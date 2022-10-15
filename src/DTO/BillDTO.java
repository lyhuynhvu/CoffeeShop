package DTO;

public class BillDTO {

    public int id;
    public String createAt;
    public String createBy;
    public int total;

    public BillDTO() {
    }

    public BillDTO(int id, String createAt, String createBy, int total) {
        this.id = id;
        this.createAt = createAt;
        this.createBy = createBy;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
