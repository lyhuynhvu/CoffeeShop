package DAO;

import DTO.MenuDTO;
import DTO.ReportMenuDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportMenuDAO extends ConnectDB{
    public ArrayList reportMost() {
        ArrayList dsmenu = new ArrayList<ReportMenuDTO>();
        try {
            getConnect();
            String qry = "SELECT m.id, m.name, m.price, SUM(d.quantity) FROM bill_detail as d, menu as m WHERE m.id = d.item GROUP BY d.item HAVING SUM(d.quantity) > 5 ORDER BY SUM(d.quantity) DESC";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                ReportMenuDTO menu = new ReportMenuDTO();
                menu.id = rs.getInt(1);
                menu.name = rs.getString(2);
                menu.price = rs.getInt(3);
                menu.amount = rs.getInt(4);
                dsmenu.add(menu);
            }
            closeConnect();
        } catch (SQLException ex) {
            Logger.getLogger(ReportMenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsmenu;
    }
    
    public ArrayList reportNot() {
        ArrayList dsmenu = new ArrayList<ReportMenuDTO>();
        try {
            getConnect();
            String qry = "SELECT id, name, price FROM menu WHERE id NOT IN (SELECT item from bill_detail)";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                ReportMenuDTO menu = new ReportMenuDTO();
                menu.id = rs.getInt(1);
                menu.name = rs.getString(2);
                menu.price = rs.getInt(3);
                menu.amount = 0;
                dsmenu.add(menu);
            }
            closeConnect();
        } catch (SQLException ex) {
            Logger.getLogger(ReportMenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsmenu;
    }
    
    public ArrayList reportLess() {
        ArrayList dsmenu = new ArrayList<ReportMenuDTO>();
        try {
            getConnect();
            String qry = "SELECT m.id, m.name, m.price, SUM(d.quantity) FROM bill_detail as d, menu as m WHERE m.id = d.item GROUP BY d.item HAVING SUM(d.quantity) <= 5 ORDER BY SUM(d.quantity) ASC";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                ReportMenuDTO menu = new ReportMenuDTO();
                menu.id = rs.getInt(1);
                menu.name = rs.getString(2);
                menu.price = rs.getInt(3);
                menu.amount = rs.getInt(4);
                dsmenu.add(menu);
            }
            closeConnect();
        } catch (SQLException ex) {
            Logger.getLogger(ReportMenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsmenu;
    }
}
