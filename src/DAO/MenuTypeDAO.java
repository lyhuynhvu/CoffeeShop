package DAO;

import DTO.MenuTypeDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuTypeDAO extends ConnectDB {

    public ArrayList<MenuTypeDTO> docDSMenuType() {
        ArrayList dsLoaisp = new ArrayList<MenuTypeDTO>();
        try {
            getConnect();
            String qry = "select * from menu_type";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                MenuTypeDTO mt = new MenuTypeDTO();
                mt.id = rs.getInt(1);
                mt.name = rs.getString(2);
                mt.description = rs.getString(3);
                dsLoaisp.add(mt);
            }
            closeConnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsLoaisp;
    }
}
