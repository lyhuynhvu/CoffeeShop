package DAO;

import DTO.BillDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillDAO extends ConnectDB {
    public ArrayList docDSBill(){
        ArrayList dsBill= new ArrayList<BillDTO>();
        try{
            getConnect();
            String qry="SELECT b.id, b.create_at, s.full_name, b.total FROM bill AS b LEFT JOIN staff AS s ON b.create_by = s.id WHERE b.create_by=s.id;";
            st=conn.createStatement();
            rs= st.executeQuery(qry);
            while(rs.next()){
                BillDTO bill= new BillDTO();
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
}
