package GUI;

import BUS.MenuTypeBUS;
import DTO.MenuTypeDTO;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableMenuType extends JFrame {

    public static DefaultTableModel model = new DefaultTableModel();
    private ArrayList<MenuTypeDTO> listMenuType = new ArrayList<>();
    public static JTable tblMenuType = new JTable();
    private JPanel panel;

    public TableMenuType() {
        init();
        loadtblLoaiSP();
    }

    public void init() {
        setTitle("Menu Type");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLayout(null);

        JButton btnOK = new JButton("Chọn");
        btnOK.setBounds(250, 290, 100, 40);
        btnOK.setForeground(new Color(255, 149, 43));
        btnOK.setBackground(Color.white);
        
        JButton btnCancel = new JButton("Bỏ chọn");
        btnCancel.setBounds(360, 290, 100, 40);
        btnCancel.setBackground(Color.white);
        btnCancel.setPreferredSize(new Dimension(130, 40));
        btnCancel.setForeground(Color.RED);
        add(btnOK);
        add(btnCancel);

        JScrollPane scroll = new JScrollPane(tblMenuType);
        scroll.setBounds(new Rectangle(30, 50, 600, 200));
        tblMenuType.getTableHeader().setOpaque(false);
        tblMenuType.getTableHeader().setBackground(new Color(32, 136, 203));
        tblMenuType.getTableHeader().setForeground(Color.white);
        tblMenuType.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblMenuType.setFont(new Font("Times New Roman", 0, 18));
        tblMenuType.setSelectionBackground(new Color(255, 102, 102));
        tblMenuType.setRowHeight(35);

        add(scroll);
        setLocationRelativeTo(null);
        setVisible(true);

        btnOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btOKMouseClicked(evt);
            }
        });
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setVisible(false);
            }
        });
    }

    private void btOKMouseClicked(java.awt.event.MouseEvent evt) {
        int i = tblMenuType.getSelectedRow();
        FormMenu.txtType.setText(tblMenuType.getModel().getValueAt(i, 0).toString());
        setVisible(false);
    }

    public void loadtblLoaiSP() {
        MenuTypeBUS typeBus = new MenuTypeBUS();
        listMenuType = typeBus.docDSLoaiSP();
        Vector header = new Vector();
        header.add("Mã loại");
        header.add("Tên loại");
        header.add("Mô tả");

        model = new DefaultTableModel(header, 0);
        for (MenuTypeDTO typeDTO : listMenuType) {
            Vector row = new Vector();
            row.add(typeDTO.id);
            row.add(typeDTO.name);
            row.add(typeDTO.description);

            model.addRow(row);
            tblMenuType.setModel(model);
        }
    }
}
