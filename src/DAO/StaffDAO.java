package DAO;

import DTO.StaffDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StaffDAO extends ConnectDB {

    public ArrayList docDSNV() {
        ArrayList dsStaff = new ArrayList<StaffDTO>();
        try {
            getConnect();
            String qry = "select * from staff";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                StaffDTO staff = new StaffDTO();
                staff.id = rs.getInt(1);
                staff.roleId = rs.getInt(2);
                staff.fullname = rs.getString(3);
                staff.gender = rs.getString(4);
                staff.phone = rs.getString(5);
                staff.email = rs.getString(6);
                staff.address = rs.getString(7);
                staff.status = rs.getString(8);
                dsStaff.add(staff);
            }
            closeConnect();
        } catch (SQLException ex) {
            Logger.getLogger(StaffDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsStaff;
    }

    public ArrayList<StaffDTO> searchByName(String name) {
        ArrayList dsStaff = new ArrayList<StaffDTO>();
        try {
            getConnect();
            String qry = "select * from staff where full_name like '%" + name + "%'";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                StaffDTO staff = new StaffDTO();
                staff.id = rs.getInt(1);
                staff.roleId = rs.getInt(2);
                staff.fullname = rs.getString(3);
                staff.gender = rs.getString(4);
                staff.phone = rs.getString(5);
                staff.email = rs.getString(6);
                staff.address = rs.getString(7);
                staff.status = rs.getString(8);
                dsStaff.add(staff);
            }
            closeConnect();
        } catch (Exception e) {
        }
        return dsStaff;
    }

    public ArrayList<StaffDTO> searchByStatus(String status) {
        ArrayList dsStaff = new ArrayList<StaffDTO>();
        try {
            getConnect();
            String qry = "select * from staff where status = '" + status + "'";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                StaffDTO staff = new StaffDTO();
                staff.id = rs.getInt(1);
                staff.roleId = rs.getInt(2);
                staff.fullname = rs.getString(3);
                staff.gender = rs.getString(4);
                staff.phone = rs.getString(5);
                staff.email = rs.getString(6);
                staff.address = rs.getString(7);
                staff.status = rs.getString(8);
                dsStaff.add(staff);
            }
            closeConnect();
        } catch (Exception e) {
        }
        return dsStaff;
    }

    public void create(StaffDTO staff) {
        try {
            getConnect();
            String qry = "Insert into staff (full_name, gender, phone, email, address, status) values (";
            qry += "'" + staff.fullname + "'";
            qry += ", '" + staff.gender + "'";
            qry += ", '" + staff.phone + "'";
            qry += ", '" + staff.email + "'";
            qry += ", '" + staff.address + "'";
            qry += ", '" + staff.status + "'";
            qry += ")";
            st = conn.createStatement();
            st.executeUpdate(qry);
            closeConnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(StaffDTO staff) {
        try {
            getConnect();
            String qry = "Update staff set";
            qry += " full_name='" + staff.fullname + "'";
            qry += ",gender='" + staff.gender + "'";
            qry += ",phone='" + staff.phone + "'";
            qry += ",email='" + staff.email + "'";
            qry += ",address='" + staff.address + "'";
            qry += ",status='" + staff.status + "'";
            qry += " " + "where id=" + staff.id;
            st = conn.createStatement();
            st.executeUpdate(qry);
            closeConnect();
        } catch (Exception e) {
        }
    }
}
