package DAO;

import DTO.BillDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillDAO extends ConnectDB {

    public ArrayList docDSBill() {
        ArrayList dsBill = new ArrayList<BillDTO>();
        try {
            getConnect();
            String qry = "SELECT * FROM bill";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                BillDTO bill = new BillDTO();
                bill.id = rs.getInt(1);
                bill.createAt = rs.getString(2);
                bill.createBy = rs.getString(3);
                bill.total = rs.getInt(4);
                dsBill.add(bill);
            }
            closeConnect();
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsBill;
    }

    public void create(int total) {
        try {
            getConnect();
            String qry = "Insert into bill (total) values(";
            qry += total;
            qry += ")";
            st = conn.createStatement();
            st.executeUpdate(qry);
            closeConnect();
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getTheLast() {
        int idBill = 0;
        try {
            getConnect();
            String qry = "SELECT id FROM bill ORDER BY ID DESC LIMIT 1";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                idBill = rs.getInt(1);
            }
            closeConnect();
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idBill;
    }
}
