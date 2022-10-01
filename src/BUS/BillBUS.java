package BUS;

import DTO.BillDTO;
import DAO.BillDAO;
import java.util.ArrayList;

public class BillBUS {
    static ArrayList<BillDTO> dshd;
    public ArrayList<BillDTO> docDSBill(){
        BillDAO data= new BillDAO();
        if(dshd==null){
        } else {
            dshd= new ArrayList<BillDTO>();
        } 
        dshd= data.docDSBill();
        return dshd;
    }
}
