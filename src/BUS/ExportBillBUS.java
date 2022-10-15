package BUS;

import DAO.ExportBillDAO;
import DTO.ExportBillDTO;
import java.util.List;

public class ExportBillBUS {
    static List<ExportBillDTO> bill;
    public List<ExportBillDTO> bill(int parentId){
        ExportBillDAO data= new ExportBillDAO();
        bill = data.bill(parentId);
        return bill;
    }
}
