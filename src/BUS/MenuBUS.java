package BUS;

import DAO.MenuDAO;
import DTO.MenuDTO;
import java.util.ArrayList;

public class MenuBUS {

    public static ArrayList<MenuDTO> dsmenu;

    public ArrayList<MenuDTO> docDSSP() {
        MenuDAO data = new MenuDAO();
        if (dsmenu == null) {
        } else {
            dsmenu = new ArrayList<MenuDTO>();
        }
        dsmenu = data.docDSSP();
        return dsmenu;
    }

    public ArrayList<MenuDTO> searchByName(String name) {
        MenuDAO data = new MenuDAO();
        dsmenu = data.searchByName(name);
        return dsmenu;
    }

    public ArrayList<MenuDTO> searchByStatus(String status) {
        MenuDAO data = new MenuDAO();
        dsmenu = data.searchByStatus(status);
        return dsmenu;
    }

    public void create(MenuDTO menuDTO) {
        MenuDAO data = new MenuDAO();
        data.create(menuDTO);
        dsmenu.add(menuDTO);
    }

    public void update(MenuDTO menuDTO) {
        MenuDAO data = new MenuDAO();
        data.update(menuDTO);
        dsmenu.add(menuDTO);
    }
    
    public ArrayList<MenuDTO> getMenuByType(int type) {
        MenuDAO data = new MenuDAO();
        dsmenu = data.getMenuByType(type);
        return dsmenu;
    }
}
