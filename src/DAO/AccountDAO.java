package DAO;

import DTO.AccountDTO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDAO extends ConnectDB {

    public void create(AccountDTO acc) {
        try {
            getConnect();
            String qry = "Insert into account (username, password, role_id) values (";
            qry += "'" + acc.username + "'";
            qry += ", '" + acc.password + "'";
            qry += ", " + acc.roleId;
            qry += ")";
            st = conn.createStatement();
            st.executeUpdate(qry);
            closeConnect();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
