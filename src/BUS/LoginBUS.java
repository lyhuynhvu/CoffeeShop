package BUS;

import DAO.LoginDAO;
import DTO.AccountDTO;
import java.util.ArrayList;

public class LoginBUS {

    public static ArrayList<AccountDTO> acc;

    public ArrayList<AccountDTO> checkLogin(String username, String pass) {
        LoginDAO data = new LoginDAO();
        acc = data.checkLogin(username, pass);
        return acc;
    }
}
