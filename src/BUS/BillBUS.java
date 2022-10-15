package BUS;

import DTO.BillDTO;
import DAO.BillDAO;
import java.util.ArrayList;

public class BillBUS {

    static ArrayList<BillDTO> dshd;

    public ArrayList<BillDTO> docDSBill() {
        BillDAO data = new BillDAO();
        if (dshd == null) {
        } else {
            dshd = new ArrayList<BillDTO>();
        }
        dshd = data.docDSBill();
        return dshd;
    }

    public void create(int total) {
        BillDAO data = new BillDAO();
        data.create(total);
    }

    public int getTheLast() {
        BillDAO data = new BillDAO();
        int idBill = data.getTheLast();
        return idBill;
    }
}
