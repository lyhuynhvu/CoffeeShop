package DAO;

import DTO.MenuDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuDAO extends ConnectDB {

    public ArrayList docDSSP() {
        ArrayList dsmenu = new ArrayList<MenuDTO>();
        try {
            getConnect();
            String qry = "select * from menu";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                MenuDTO menu = new MenuDTO();
                menu.id = rs.getInt(1);
                menu.name = rs.getString(2);
                menu.price = rs.getInt(3);
                menu.type = rs.getInt(4);
                menu.image = rs.getString(5);
                menu.status = rs.getString(6);
                dsmenu.add(menu);
            }
            closeConnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsmenu;
    }

    public ArrayList<MenuDTO> searchByName(String name) {
        ArrayList dssp = new ArrayList<MenuDTO>();
        try {
            getConnect();
            String qry = "select * from menu where name like '%" + name + "%'";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                MenuDTO sp = new MenuDTO();
                sp.id = rs.getInt(1);
                sp.name = rs.getString(2);
                sp.price = rs.getInt(3);
                sp.type = rs.getInt(4);
                sp.image = rs.getString(5);
                sp.status = rs.getString(6);
                dssp.add(sp);
            }
            closeConnect();
        } catch (Exception e) {
        }
        return dssp;
    }

    public ArrayList<MenuDTO> searchByStatus(String status) {
        ArrayList dssp = new ArrayList<MenuDTO>();
        try {
            getConnect();
            String qry = "select * from menu where status = '" + status + "'";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                MenuDTO sp = new MenuDTO();
                sp.id = rs.getInt(1);
                sp.name = rs.getString(2);
                sp.price = rs.getInt(3);
                sp.type = rs.getInt(4);
                sp.image = rs.getString(5);
                sp.status = rs.getString(6);
                dssp.add(sp);
            }
            closeConnect();
        } catch (Exception e) {
        }
        return dssp;
    }

    public void create(MenuDTO menu) {
        try {
            getConnect();
            String qry = "Insert into menu (name, price, type, image, status) values (";
            qry += "'" + menu.name + "'";
            qry += "," + menu.price;
            qry += "," + menu.type;
            qry += "," + "'" + menu.image + "'";
            qry += "," + "'" + menu.status + "'";
            qry += ")";
            st = conn.createStatement();
            st.executeUpdate(qry);
            closeConnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(MenuDTO menu) {
        try {
            getConnect();
            String qry = "Update menu set";
            qry += " name='" + menu.name + "'";
            qry += ",price=" + menu.price;
            qry += ",type=" + menu.type;
            qry += ",image='" + menu.image + "'";
            qry += ",status='" + menu.status + "'";
            qry += " " + "where id=" + menu.id;
            st = conn.createStatement();
            st.executeUpdate(qry);
            closeConnect();
        } catch (Exception e) {

        }
    }

    public ArrayList<MenuDTO> getMenuByType(int type) {
        ArrayList dssp = new ArrayList<MenuDTO>();
        try {
            getConnect();
            String qry = "select * from menu where type = " + type;
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                MenuDTO sp = new MenuDTO();
                sp.id = rs.getInt(1);
                sp.name = rs.getString(2);
                sp.price = rs.getInt(3);
                sp.type = rs.getInt(4);
                sp.image = rs.getString(5);
                sp.status = rs.getString(6);
                dssp.add(sp);
            }
            closeConnect();
        } catch (Exception e) {
        }
        return dssp;
    }
}
