package BUS;

import DAO.StaffDAO;
import DTO.StaffDTO;
import java.util.ArrayList;

public class StaffBUS {

    public static ArrayList<StaffDTO> dsStaff;

    public ArrayList<StaffDTO> docDSNV() {
        StaffDAO data = new StaffDAO();
        if (dsStaff == null) {
        } else {
            dsStaff = new ArrayList<StaffDTO>();
        }
        dsStaff = data.docDSNV();
        return dsStaff;
    }

    public ArrayList<StaffDTO> searchByName(String name) {
        StaffDAO data = new StaffDAO();
        dsStaff = data.searchByName(name);
        return dsStaff;
    }

    public ArrayList<StaffDTO> searchByStatus(String status) {
        StaffDAO data = new StaffDAO();
        dsStaff = data.searchByStatus(status);
        return dsStaff;
    }

    public void create(StaffDTO staffDTO) {
        StaffDAO data = new StaffDAO();
        data.create(staffDTO);
        dsStaff.add(staffDTO);
    }
    
    public void update(StaffDTO staffDTO) {
        StaffDAO data = new StaffDAO();
        data.update(staffDTO);
        dsStaff.add(staffDTO);
    }
}
