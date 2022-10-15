package DTO;

public class StaffDTO {

    public int id;
    public int roleId;
    public String fullname;
    public String gender;
    public String phone;
    public String email;
    public String address;
    public String status;

    public StaffDTO() {
    }

    public StaffDTO(int id, int roleId, String fullname, String gender, String phone, String email, String address, String status) {
        this.id = id;
        this.roleId = roleId;
        this.fullname = fullname;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
