package GUI;

import BUS.MenuBUS;
import DTO.MenuDTO;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MenuManagement extends JPanel {

    public static DefaultTableModel model = new DefaultTableModel();
    private JPanel panel;
    private JTextField txtSearchName = new JTextField("", 280);
    String status[] = {"Trạng Thái", "Đang Bán", "Ngừng Bán"};
    private JComboBox cbxStatus = new JComboBox(status);
    public static JTable tblNV = new JTable() {
        public Class getColumnClass(int column) {
            if (column == 5) {
                return Icon.class;
            } else {
                return Object.class;
            }
        }
    };
    private ArrayList<MenuDTO> listSP = new ArrayList<>();
    public static MenuManagement mngt = new MenuManagement();

    public MenuManagement() {
        init();
        loadtblSP();
    }

    public void init() {
        setLayout(null);
        setSize(1500, 900);

        JPanel pnMenu = new JPanel();
        pnMenu.setLayout(new BorderLayout());
        pnMenu.setBounds(0, 0, 1500, 900);

        // ===== LEFT =====
        JPanel func = new JPanel();
        func.setLayout(null);
        func.setBorder(BorderFactory.createEtchedBorder());
        func.setPreferredSize(new Dimension(375, 900));

        JButton btnCreate = new JButton("Thêm Sản Phẩm");
        btnCreate.setForeground(new Color(90, 50, 30));
        btnCreate.setBackground(Color.WHITE);
        btnCreate.setBounds(30, 50, 315, 50);
        btnCreate.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        func.add(btnCreate);

        JButton btnUpdate = new JButton("Sửa Sản Phẩm");
        btnUpdate.setForeground(new Color(90, 50, 30));
        btnUpdate.setBackground(Color.WHITE);
        btnUpdate.setBounds(30, 150, 315, 50);
        btnUpdate.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        func.add(btnUpdate);

        JPanel pnSearch = new JPanel();
        pnSearch.setLayout(null);
        pnSearch.setBounds(30, 250, 315, 550);
        pnSearch.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        JLabel lblSearch = new JLabel("Tìm kiếm");
        lblSearch.setBounds(100, 20, 280, 50);
        lblSearch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        pnSearch.add(lblSearch);

        JLabel lblSearchName = new JLabel("Tên:");
        lblSearchName.setBounds(15, 100, 100, 50);
        lblSearchName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        pnSearch.add(lblSearchName);

        txtSearchName.setBounds(15, 150, 280, 50);
        txtSearchName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        pnSearch.add(txtSearchName);

        JLabel lblSearchStt = new JLabel("Trạng thái:");
        lblSearchStt.setBounds(15, 200, 180, 50);
        lblSearchStt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        pnSearch.add(lblSearchStt);

        cbxStatus.setBounds(15, 250, 280, 50);
        cbxStatus.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        pnSearch.add(cbxStatus);

        JButton btnSearch = new JButton("Tìm Sản Phẩm");
        btnSearch.setForeground(new Color(90, 50, 30));
        btnSearch.setBackground(Color.WHITE);
        btnSearch.setBounds(15, 400, 280, 50);
        btnSearch.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        pnSearch.add(btnSearch);
        func.add(pnSearch);

        pnMenu.add(func, BorderLayout.WEST);

        // ===== CENTER =====
        JPanel menuCenter = new JPanel();
        menuCenter.setLayout(null);
        menuCenter.setPreferredSize(new Dimension(1125, 900));

        JLabel lblMenu = new JLabel("Quản lý menu");
        lblMenu.setBounds(60, 20, 600, 50);
        lblMenu.setForeground(new Color(90, 50, 30));
        lblMenu.setFont(new Font(Font.MONOSPACED, 3, 22));
        menuCenter.add(lblMenu);

        JScrollPane scroll = new JScrollPane(tblNV);
        scroll.setBounds(new Rectangle(60, 100, 1000, 700));
        tblNV.getTableHeader().setOpaque(false);
        tblNV.getTableHeader().setBackground(new Color(236, 177, 51));
        tblNV.getTableHeader().setForeground(Color.white);
        tblNV.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tblNV.setFont(new Font("Times New Roman", 0, 18));
        tblNV.setSelectionBackground(new Color(244, 223, 125));
        tblNV.setRowHeight(150);
        menuCenter.add(scroll);

        pnMenu.add(menuCenter, BorderLayout.CENTER);
        add(pnMenu);
        setVisible(true);

        btnSearch.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        btnCreate.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                FormMenu formMenu = new FormMenu("create");
                formMenu.show();
            }
        });

        btnUpdate.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                FormMenu formMenu = new FormMenu("update");
                formMenu.show();
            }
        });
    }

    public void loadtblSP() {
        MenuBUS menuBus = new MenuBUS();
        listSP = menuBus.docDSSP();
        renderDataToTable();
    }

    private void btnSearchMouseClicked(MouseEvent event) {
        MenuBUS menuBUS = new MenuBUS();
        String name = txtSearchName.getText();
        String stt = cbxStatus.getSelectedItem().toString();

        if (!name.equals("")) {
            listSP = menuBUS.searchByName(name);
            if (listSP.size() == 0) {
                JOptionPane.showMessageDialog(panel, "Không tìm thấy sản phẩm có tên " + name, "Lời nhắn", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            listSP = menuBUS.docDSSP();
        }

        if (stt != "Trạng Thái") {
            listSP = menuBUS.searchByStatus(stt);
            if (listSP.size() == 0) {
                JOptionPane.showMessageDialog(panel, "Không có sản phẩm nào ở trạng thái " + stt, "Lời nhắn", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        renderDataToTable();
    }

    public void renderDataToTable() {
        Vector header = new Vector();
        header.add("ID");
        header.add("Tên");
        header.add("Đơn giá");
        header.add("Loại");
        header.add("Trạng thái");
        header.add("Hình");

        model = new DefaultTableModel(header, 0);
        for (MenuDTO menuDTO : listSP) {
            Vector row = new Vector();
            row.add(menuDTO.id);
            row.add(menuDTO.name);
            row.add(menuDTO.price);
            row.add(menuDTO.type);
            row.add(menuDTO.status);
            row.add(new ImageIcon(getClass().getResource("/images/" + menuDTO.image)));

            model.addRow(row);
            tblNV.setModel(model);
        }
    }
}
