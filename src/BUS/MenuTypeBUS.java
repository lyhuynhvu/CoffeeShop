package BUS;

import DAO.MenuTypeDAO;
import DTO.MenuTypeDTO;
import java.util.ArrayList;

public class MenuTypeBUS {

    static ArrayList<MenuTypeDTO> dsLoaiSP;

    public ArrayList<MenuTypeDTO> docDSLoaiSP() {
        MenuTypeDAO data = new MenuTypeDAO();
        if (dsLoaiSP == null) {
        } else {
            dsLoaiSP = new ArrayList<MenuTypeDTO>();
        }
        dsLoaiSP = data.docDSMenuType();
        return dsLoaiSP;
    }
}
