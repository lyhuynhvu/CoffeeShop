package DAO;

import DTO.BillDetailDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillDetailDAO extends ConnectDB {
    public ArrayList docDSDetail(int billId){
        ArrayList dsDetail= new ArrayList<BillDetailDTO>();
        try{
            getConnect();
            String qry="SELECT d.id, d.parent_id, m.name, d.quantity, d.subtotal, d.note FROM bill_detail as d LEFT JOIN menu as m ON d.item = m.id WHERE d.parent_id=" +billId;
            st=conn.createStatement();
            rs= st.executeQuery(qry);
            while(rs.next()){
                BillDetailDTO detail= new BillDetailDTO();
                detail.id = rs.getInt(1);
                detail.billId = rs.getInt(2);
                detail.item = rs.getString(3);
                detail.quanity = rs.getInt(4);
                detail.subtotal = rs.getInt(5);
                detail.note = rs.getString(6);
                dsDetail.add(detail);
            }
            closeConnect();
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDetail;
    }
}
