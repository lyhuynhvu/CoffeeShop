package BUS;

import DAO.BillDetailDAO;
import DTO.BillDetailDTO;
import java.util.ArrayList;

public class BillDetailBUS {
    static ArrayList<BillDetailDTO> dsDetail;
    public ArrayList<BillDetailDTO> docDSDetail(int billId){
        BillDetailDAO data= new BillDetailDAO();
        if(dsDetail==null){
        } else {
            dsDetail= new ArrayList<BillDetailDTO>();
        } 
        dsDetail= data.docDSDetail(billId);
        return dsDetail;
    }
}
