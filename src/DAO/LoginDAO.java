package DAO;

import DTO.AccountDTO;
import java.sql.SQLException;
import java.util.*;

public class LoginDAO extends ConnectDB {

    public ArrayList<AccountDTO> checkLogin(String username, String password) {
        ArrayList acc = new ArrayList<AccountDTO>();
        try {
            getConnect();
            String qry = "select * from account where username='" + username + "' and password='" + password + "'";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                AccountDTO account = new AccountDTO();
                account.username = rs.getString(1);
                account.password = rs.getString(2);
                account.roleId = rs.getInt(3);
                acc.add(account);

            }
            closeConnect();
        } catch (SQLException ex) {
        }
        return acc;
    }
}
