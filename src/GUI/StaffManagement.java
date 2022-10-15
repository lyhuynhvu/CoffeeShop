package GUI;

import BUS.StaffBUS;
import DTO.StaffDTO;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StaffManagement extends JPanel {

    public static DefaultTableModel model = new DefaultTableModel();
    private JPanel panel;
    private JTextField txtSearchName = new JTextField("", 280);
    String status[] = {"Trạng Thái", "Đang làm", "Đã nghỉ"};
    private JComboBox cbxStatus = new JComboBox(status);
    public static JTable tblStaff = new JTable() {
        public Class getColumnClass(int column) {
            if (column == 5) {
                return Icon.class;
            } else {
                return Object.class;
            }
        }
    };
    
    private ArrayList<StaffDTO> listStaff = new ArrayList<>();
    public static StaffManagement smgt = new StaffManagement();

    public StaffManagement() {
        init();
        loadTbl();
    }

    public void init() {
        setLayout(null);
        setSize(1500, 900);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());
        pnMain.setBounds(0, 0, 1500, 900);

        // ===== LEFT =====
        JPanel func = new JPanel();
        func.setLayout(null);
        func.setBorder(BorderFactory.createEtchedBorder());
        func.setPreferredSize(new Dimension(375, 900));

        JButton btnCreate = new JButton("Thêm Nhân Viên");
        btnCreate.setForeground(new Color(90, 50, 30));
        btnCreate.setBackground(Color.WHITE);
        btnCreate.setBounds(30, 50, 315, 50);
        btnCreate.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        func.add(btnCreate);

        JButton btnUpdate = new JButton("Sửa Nhân Viên");
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

        JButton btnSearch = new JButton("Tìm Nhân Viên");
        btnSearch.setForeground(new Color(90, 50, 30));
        btnSearch.setBackground(Color.WHITE);
        btnSearch.setBounds(15, 400, 280, 50);
        btnSearch.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        pnSearch.add(btnSearch);
        func.add(pnSearch);

        pnMain.add(func, BorderLayout.WEST);

        // ===== CENTER =====
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(null);
        pnCenter.setPreferredSize(new Dimension(1125, 900));

        JLabel lblMenu = new JLabel("Quản lý nhân viên");
        lblMenu.setBounds(60, 20, 600, 50);
        lblMenu.setForeground(new Color(90, 50, 30));
        lblMenu.setFont(new Font(Font.MONOSPACED, 3, 22));
        pnCenter.add(lblMenu);

        JScrollPane scroll = new JScrollPane(tblStaff);
        scroll.setBounds(new Rectangle(60, 100, 1000, 700));
        tblStaff.getTableHeader().setOpaque(false);
        tblStaff.getTableHeader().setBackground(new Color(236, 177, 51));
        tblStaff.getTableHeader().setForeground(Color.white);
        tblStaff.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tblStaff.setFont(new Font("Times New Roman", 0, 18));
        tblStaff.setSelectionBackground(new Color(244, 223, 125));
        tblStaff.setRowHeight(50);
        pnCenter.add(scroll);

        pnMain.add(pnCenter, BorderLayout.CENTER);
        add(pnMain);
        setVisible(true);

        btnSearch.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        btnCreate.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                FormStaff form = new FormStaff("create");
                form.show();
            }
        });

        btnUpdate.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                FormStaff form = new FormStaff("update");
                form.show();
            }
        });
    }

    public void loadTbl() {
        StaffBUS staffBus = new StaffBUS();
        listStaff = staffBus.docDSNV();
        renderDataToTable();
    }

    private void btnSearchMouseClicked(MouseEvent event) {
        StaffBUS staffBus = new StaffBUS();
        String name = txtSearchName.getText();
        String stt = cbxStatus.getSelectedItem().toString();

        if (!name.equals("")) {
            listStaff = staffBus.searchByName(name);
            if (listStaff.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "Không tìm thấy sản phẩm có tên " + name, "Lời nhắn", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            listStaff = staffBus.docDSNV();
        }

        if (!stt.equals("Trạng Thái")) {
            listStaff = staffBus.searchByStatus(stt);
            if (listStaff.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "Không có sản phẩm nào ở trạng thái " + stt, "Lời nhắn", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        renderDataToTable();
    }

    public void renderDataToTable() {
        Vector header = new Vector();
        header.add("ID");
        header.add("Role");
        header.add("Tên đầy đủ");
        header.add("Giới tính");
        header.add("Số điện thoại");
        header.add("Email");
        header.add("Địa chỉ");
        header.add("Trạng thái");

        model = new DefaultTableModel(header, 0);
        for (StaffDTO staffDTO : listStaff) {
            Vector row = new Vector();
            row.add(staffDTO.id);
            row.add(staffDTO.roleId);
            row.add(staffDTO.fullname);
            row.add(staffDTO.gender);
            row.add(staffDTO.phone);
            row.add(staffDTO.email.intern());
            row.add(staffDTO.address);
            row.add(staffDTO.status);

            model.addRow(row);
            tblStaff.setModel(model);
        }
    }
}
