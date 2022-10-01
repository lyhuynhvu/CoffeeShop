package BUS;

import DAO.AccountDAO;
import DTO.AccountDTO;
import java.util.ArrayList;

public class AccountBUS {

    public static ArrayList<AccountDTO> dsAcc;

    public void create(AccountDTO acc) {
        AccountDAO data = new AccountDAO();
        data.create(acc);
        dsAcc.add(acc);
    }
}
