package GUI;

import BUS.BillBUS;
import BUS.BillDetailBUS;
import DTO.BillDTO;
import DTO.BillDetailDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BillManagement extends JPanel {

    public static DefaultTableModel model = new DefaultTableModel();
    private ArrayList<BillDTO> listBill = new ArrayList<>();
    public static JTable tblBill = new JTable();
    public static DefaultTableModel modelDetail = new DefaultTableModel();
    private ArrayList<BillDetailDTO> listDetail = new ArrayList<>();
    public static JTable tblDetail = new JTable();
    private JLabel lbTuNgay = new JLabel("Từ ngày");
    private JLabel lbDenNgay = new JLabel("Đến ngày");
    private JButton btnTim = new JButton("Tìm kiếm");
    private JDateChooser dcTu = new JDateChooser();
    private JDateChooser dcDen = new JDateChooser();

    public BillManagement() {
        init();
        loadtblBill();
    }

    public void init() {
        setLayout(null);
        setSize(1500, 900);

        JPanel pnSearch = new JPanel();
        pnSearch.setBounds(600, 50, 850, 50);
        pnSearch.setLayout(null);
        pnSearch.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        lbTuNgay.setBounds(30, 5, 80, 40);
        lbTuNgay.setForeground(new Color(90, 50, 30));
        lbTuNgay.setFont(new Font(Font.MONOSPACED, 1, 18));
        pnSearch.add(lbTuNgay);

        dcTu.setBounds(110, 5, 200, 40);
        pnSearch.add(dcTu);

        lbDenNgay.setBounds(345, 5, 90, 40);
        lbDenNgay.setForeground(new Color(90, 50, 30));
        lbDenNgay.setFont(new Font(Font.MONOSPACED, 1, 18));
        pnSearch.add(lbDenNgay);

        dcDen.setBounds(435, 5, 200, 40);
        pnSearch.add(dcDen);

        btnTim.setForeground(new Color(90, 50, 30));
        btnTim.setBackground(Color.white);
        btnTim.setBounds(670, 5, 150, 40);
        pnSearch.add(btnTim);
        add(pnSearch);

        JLabel lbBill = new JLabel("Danh sách hóa đơn");
        lbBill.setBounds(30, 50, 200, 40);
        lbBill.setForeground(new Color(90, 50, 30));
        lbBill.setFont(new Font(Font.MONOSPACED, 3, 18));
        add(lbBill);

        JButton btnViewDetail = new JButton("Xem chi tiết hóa đơn");
        btnViewDetail.setBounds(330, 50, 200, 40);
        btnViewDetail.setBackground(Color.white);
        btnViewDetail.setForeground(new Color(90, 50, 30));
        add(btnViewDetail);

        JScrollPane scroll = new JScrollPane(tblBill);
        scroll.setBounds(new Rectangle(30, 110, 500, 720));
        tblBill.getTableHeader().setOpaque(false);
        tblBill.getTableHeader().setBackground(new Color(236, 177, 51));
        tblBill.getTableHeader().setForeground(Color.white);
        tblBill.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblBill.setFont(new Font("Times New Roman", 0, 18));
        tblBill.setSelectionBackground(new Color(244, 223, 125));
        tblBill.setRowHeight(50);
        add(scroll);

        JLabel lbBillDetail = new JLabel("Chi tiết hóa đơn");
        lbBillDetail.setBounds(600, 150, 200, 40);
        lbBillDetail.setForeground(new Color(90, 50, 30));
        lbBillDetail.setFont(new Font(Font.MONOSPACED, 3, 18));
        add(lbBillDetail);

        JScrollPane scroll2 = new JScrollPane(tblDetail);
        scroll2.setBounds(new Rectangle(600, 210, 850, 620));
        tblDetail.getTableHeader().setOpaque(false);
        tblDetail.getTableHeader().setBackground(new Color(236, 177, 51));
        tblDetail.getTableHeader().setForeground(Color.white);
        tblDetail.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblDetail.setFont(new Font("Times New Roman", 0, 18));
        tblDetail.setSelectionBackground(new Color(244, 223, 125));
        tblDetail.setRowHeight(40);
        add(scroll2);

        setVisible(true);

        tblBill.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int i = tblBill.getSelectedRow();
            }
        });

        btnViewDetail.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btViewMouseClicked(evt);
            }
        });
    }

    public void loadtblBill() {
        BillBUS billBus = new BillBUS();
        listBill = billBus.docDSBill();
        renderToTbl();
    }

    public void renderToTbl() {
        Vector header = new Vector();
        header.add("Mã HD");
        header.add("Ngày lập");
        header.add("Nhân viên");
        header.add("Tổng tiền");

        model = new DefaultTableModel(header, 0);
        for (BillDTO bill : listBill) {
            Vector row = new Vector();
            row.add(bill.id);
            row.add(bill.createAt);
            row.add(bill.createBy);
            row.add(bill.total);

            model.addRow(row);
            tblBill.setModel(model);
        }
    }

    private void btViewMouseClicked(MouseEvent event) {
        int i = tblBill.getSelectedRow();
        int billId = Integer.parseInt(tblBill.getModel().getValueAt(i, 0).toString());
        BillDetailBUS dBus = new BillDetailBUS();
        listDetail = dBus.docDSDetail(billId);
        renderDetailTbl();
    }

    public void renderDetailTbl() {
        Vector header = new Vector();
        header.add("Mã CTHD");
        header.add("Mã HD");
        header.add("Item");
        header.add("Số lượng");
        header.add("Thành tiền");
        header.add("Ghi chú");

        modelDetail = new DefaultTableModel(header, 0);
        for (BillDetailDTO detail : listDetail) {
            Vector row = new Vector();
            row.add(detail.id);
            row.add(detail.billId);
            row.add(detail.item);
            row.add(detail.quanity);
            row.add(detail.subtotal);
            row.add(detail.note);

            modelDetail.addRow(row);
            tblDetail.setModel(modelDetail);
        }
    }
}
