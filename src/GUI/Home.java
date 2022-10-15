package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame {

    public Home() {
        init();
    }

    public void init() {
        setTitle("Coffee Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 1000);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());

        // ===== Header =====
        JPanel head = new JPanel();
        head.setLayout(null);
        head.setBorder(BorderFactory.createEtchedBorder());
        head.setBackground(new Color(90, 50, 30));
        head.setPreferredSize(new Dimension(1800, 100));

        JLabel lblhear = new JLabel("COFFEE SHOP");
        lblhear.setForeground(Color.WHITE);
        lblhear.setBounds(666, 10, 500, 30);
        lblhear.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        head.add(lblhear);

        JButton btnMenu = new JButton("SẢN PHẨM");
        btnMenu.setForeground(new Color(90, 50, 30));
        btnMenu.setBackground(Color.WHITE);
        btnMenu.setBounds(0, 50, 375, 50);
        btnMenu.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        head.add(btnMenu);

        JButton btnStaff = new JButton("NHÂN VIÊN");
        btnStaff.setForeground(new Color(90, 50, 30));
        btnStaff.setBackground(Color.WHITE);
        btnStaff.setBounds(375, 50, 375, 50);
        btnStaff.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        head.add(btnStaff);

        JButton btnBill = new JButton("HÓA ĐƠN");
        btnBill.setForeground(new Color(90, 50, 30));
        btnBill.setBackground(Color.WHITE);
        btnBill.setBounds(750, 50, 375, 50);
        btnBill.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        head.add(btnBill);

        JButton btnReport = new JButton("THỐNG KÊ");
        btnReport.setForeground(new Color(90, 50, 30));
        btnReport.setBackground(Color.WHITE);
        btnReport.setBounds(1125, 50, 375, 50);
        btnReport.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        head.add(btnReport);

        pnMain.add(head, BorderLayout.NORTH);

        // ===== CENTER =====
        JPanel center = new JPanel();
        center.setLayout(null);
        center.setBorder(BorderFactory.createEtchedBorder());
        center.setBackground(new Color(255, 255, 255));
        center.setPreferredSize(new Dimension(1500, 900));

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/bg-home.jpg")));
        background.setBounds(0, 0, 1500, 900);
        center.add(background);

        pnMain.add(center, BorderLayout.CENTER);

        add(pnMain);
        setLocationRelativeTo(null);
        setVisible(true);

        // ----- click button sản phẩm -----
        btnMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnMenu.setForeground(Color.WHITE);
                btnMenu.setBackground(new Color(236, 177, 51));
                btnStaff.setBackground(Color.WHITE);
                btnStaff.setForeground(new Color(236, 177, 51));
                btnBill.setBackground(Color.WHITE);
                btnBill.setForeground(new Color(236, 177, 51));
                btnReport.setBackground(Color.WHITE);
                btnReport.setForeground(new Color(236, 177, 51));

                MenuManagement menu = new MenuManagement();
                switchPanel(center, menu);
            }
        });

        // ----- click button nhân viên -----
        btnStaff.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnStaff.setForeground(Color.WHITE);
                btnStaff.setBackground(new Color(236, 177, 51));
                btnMenu.setBackground(Color.WHITE);
                btnMenu.setForeground(new Color(236, 177, 51));
                btnBill.setBackground(Color.WHITE);
                btnBill.setForeground(new Color(236, 177, 51));
                btnReport.setBackground(Color.WHITE);
                btnReport.setForeground(new Color(236, 177, 51));

                StaffManagement staff = new StaffManagement();
                switchPanel(center, staff);
            }
        });

        // ----- click button hóa đơn -----
        btnBill.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnBill.setForeground(Color.WHITE);
                btnBill.setBackground(new Color(236, 177, 51));
                btnMenu.setBackground(Color.WHITE);
                btnMenu.setForeground(new Color(236, 177, 51));
                btnStaff.setBackground(Color.WHITE);
                btnStaff.setForeground(new Color(236, 177, 51));
                btnReport.setBackground(Color.WHITE);
                btnReport.setForeground(new Color(236, 177, 51));

                BillManagement bill = new BillManagement();
                switchPanel(center, bill);
            }
        });

        // ----- click button doanh thu -----
        btnReport.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnReport.setForeground(Color.WHITE);
                btnReport.setBackground(new Color(236, 177, 51));
                btnMenu.setBackground(Color.WHITE);
                btnMenu.setForeground(new Color(236, 177, 51));
                btnStaff.setBackground(Color.WHITE);
                btnStaff.setForeground(new Color(236, 177, 51));
                btnBill.setBackground(Color.WHITE);
                btnBill.setForeground(new Color(236, 177, 51));

                ReportManagement report = new ReportManagement();
                switchPanel(center, report);
            }
        });
    }

    // chuyển đổi panel
    public void switchPanel(JPanel fatherPanel, JPanel childPanel) {
        fatherPanel.removeAll();
        fatherPanel.repaint();  // vẽ lại các thành phần đã thay đổi
        fatherPanel.revalidate();  // tính toán lại bố cục

        fatherPanel.add(childPanel);
        fatherPanel.repaint();  // vẽ lại một thành phần con mà nó đã gọi
        fatherPanel.revalidate();
    }
}
