package BUS;

import DAO.ReportMenuDAO;
import DTO.ReportMenuDTO;
import java.util.ArrayList;

public class ReportMenuBUS {

    public static ArrayList<ReportMenuDTO> dsmenu;

    public ArrayList<ReportMenuDTO> reportMost() {
        ReportMenuDAO data = new ReportMenuDAO();
        if (dsmenu == null) {
        } else {
            dsmenu = new ArrayList<ReportMenuDTO>();
        }
        dsmenu = data.reportMost();
        return dsmenu;
    }

    public ArrayList<ReportMenuDTO> reportNot() {
        ReportMenuDAO data = new ReportMenuDAO();
        if (dsmenu == null) {
        } else {
            dsmenu = new ArrayList<ReportMenuDTO>();
        }
        dsmenu = data.reportNot();
        return dsmenu;
    }

    public ArrayList<ReportMenuDTO> reportLess() {
        ReportMenuDAO data = new ReportMenuDAO();
        if (dsmenu == null) {
        } else {
            dsmenu = new ArrayList<ReportMenuDTO>();
        }
        dsmenu = data.reportLess();
        return dsmenu;
    }
}
