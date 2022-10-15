package GUI;

import BUS.ReportMenuBUS;
import DTO.ReportMenuDTO;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ReportManagement extends JPanel {

    private ArrayList<ReportMenuDTO> listSP = new ArrayList<>();

    public ReportManagement() {
        init();
    }

    public void init() {
        setLayout(null);
        setSize(1500, 900);

        JPanel pnReport = new JPanel();
        pnReport.setLayout(new BorderLayout());
        pnReport.setBounds(50, 50, 1400, 800);

        JPanel pnTop = new JPanel();
        pnTop.setPreferredSize(new Dimension(1300, 60));
        pnTop.setLayout(null);

        ButtonGroup btg = new ButtonGroup();
        JRadioButton rbtnBanChay = new JRadioButton("Sản phẩm bán chạy");
        btg.add(rbtnBanChay);
        rbtnBanChay.setBounds(20, 5, 200, 30);
        rbtnBanChay.setFont(new Font("Tahoma", 1, 16));
        pnTop.add(rbtnBanChay);

        JRadioButton rbtnKBanChay = new JRadioButton("Sản phẩm không bán chạy");
        btg.add(rbtnKBanChay);
        rbtnKBanChay.setBounds(250, 5, 250, 30);
        rbtnKBanChay.setFont(new Font("Tahoma", 1, 16));
        pnTop.add(rbtnKBanChay);
        pnReport.add(pnTop, BorderLayout.NORTH);

        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new CardLayout());

        JTable tblTKSP = new JTable();
        JScrollPane scroll1 = new JScrollPane(tblTKSP);
        scroll1.setBounds(new Rectangle(50, 100, 1000, 400));
        tblTKSP.getTableHeader().setOpaque(false);
        tblTKSP.getTableHeader().setBackground(new Color(236, 177, 51));
        tblTKSP.getTableHeader().setForeground(Color.white);
        tblTKSP.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tblTKSP.setFont(new Font("Times New Roman", 0, 18));
        tblTKSP.setSelectionBackground(new Color(244, 223, 125));
        tblTKSP.setRowHeight(50);
        pnCenter.add(scroll1);

        pnReport.add(pnCenter, BorderLayout.CENTER);

        add(pnReport);
        setVisible(true);

        rbtnBanChay.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ReportMenuBUS menuBus = new ReportMenuBUS();
                listSP = menuBus.reportMost();
                Vector header = new Vector();
                header.add("ID");
                header.add("Tên sản phẩm");
                header.add("Đơn giá");
                header.add("Số lượng đã bán");
                DefaultTableModel model = new DefaultTableModel(header, 0);

                for (ReportMenuDTO menuDTO : listSP) {
                    Vector row = new Vector();
                    row.add(menuDTO.id);
                    row.add(menuDTO.name);
                    row.add(menuDTO.price);
                    row.add(menuDTO.amount);
                    model.addRow(row);
                    tblTKSP.setModel(model);
                }

            }
        });

        rbtnKBanChay.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ReportMenuBUS menuBus = new ReportMenuBUS();
                listSP = menuBus.reportNot();
                Vector header = new Vector();
                header.add("ID");
                header.add("Tên sản phẩm");
                header.add("Đơn giá");
                header.add("Số lượng đã bán");
                DefaultTableModel model = new DefaultTableModel(header, 0);

                for (ReportMenuDTO menuDTO : listSP) {
                    Vector row = new Vector();
                    row.add(menuDTO.id);
                    row.add(menuDTO.name);
                    row.add(menuDTO.price);
                    row.add(menuDTO.amount);
                    model.addRow(row);
                    tblTKSP.setModel(model);
                }

                listSP = menuBus.reportLess();
                for (ReportMenuDTO menuDTO : listSP) {
                    Vector row = new Vector();
                    row.add(menuDTO.id);
                    row.add(menuDTO.name);
                    row.add(menuDTO.price);
                    row.add(menuDTO.amount);
                    model.addRow(row);
                    tblTKSP.setModel(model);
                }
            }
        });
    }

}
