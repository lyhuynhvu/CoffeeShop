package DAO;

import DTO.ExportBillDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExportBillDAO extends ConnectDB {

    public List<ExportBillDTO> bill(int parentId) {
        List<ExportBillDTO> list = new ArrayList<ExportBillDTO>();
        try {
            getConnect();
            String qry = "SELECT m.name, m.price, d.quantity, d.subtotal, b.total, b.create_at, b.create_by FROM bill_detail AS d LEFT JOIN menu AS m ON d.item = m.id LEFT JOIN bill as b on d.parent_id = b.id  WHERE d.parent_id =";
            qry += parentId;
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                ExportBillDTO e = new ExportBillDTO();
                e.item = rs.getString(1);
                e.price = rs.getInt(2);
                e.quanity = rs.getInt(3);
                e.subtotal = rs.getInt(4);
                e.sum = rs.getInt(5);
                e.date = rs.getString(6);
                e.by = rs.getString(7);
                list.add(e);
            }
            closeConnect();
        } catch (SQLException ex) {
        }
        return list;
    }
}
