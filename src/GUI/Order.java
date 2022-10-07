package GUI;

import BUS.MenuBUS;
import DTO.MenuDTO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class Order extends JFrame {
    private JPanel pnCenter = new JPanel();
    private ArrayList<MenuDTO> listMenu = new ArrayList<>();

    public Order() {
        init();
    }

    public void init() {
        setTitle("Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 900);

        JPanel pnOrder = new JPanel();
        pnOrder.setLayout(new BorderLayout());
        pnOrder.setBounds(0, 0, 1500, 900);

        // ===== Header =====
        JPanel type = new JPanel();
        type.setLayout(null);
        type.setBorder(BorderFactory.createEtchedBorder());
        type.setPreferredSize(new Dimension(1500, 50));

        JButton btnCoffee = new JButton("Cà phê");
        btnCoffee.setForeground(new Color(90, 50, 30));
        btnCoffee.setBackground(Color.WHITE);
        btnCoffee.setBounds(0, 0, 250, 50);
        btnCoffee.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        type.add(btnCoffee);

        JButton btnTea = new JButton("Trà");
        btnTea.setForeground(new Color(90, 50, 30));
        btnTea.setBackground(Color.WHITE);
        btnTea.setBounds(250, 0, 250, 50);
        btnTea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        type.add(btnTea);

        JButton btnMilkTea = new JButton("Trà sữa");
        btnMilkTea.setForeground(new Color(90, 50, 30));
        btnMilkTea.setBackground(Color.WHITE);
        btnMilkTea.setBounds(500, 0, 250, 50);
        btnMilkTea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        type.add(btnMilkTea);

        JButton btnSmoothie = new JButton("Đá xay/Sinh tố");
        btnSmoothie.setForeground(new Color(90, 50, 30));
        btnSmoothie.setBackground(Color.WHITE);
        btnSmoothie.setBounds(750, 0, 250, 50);
        btnSmoothie.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        type.add(btnSmoothie);

        JButton btnJuice = new JButton("Nước ép");
        btnJuice.setForeground(new Color(90, 50, 30));
        btnJuice.setBackground(Color.WHITE);
        btnJuice.setBounds(1000, 0, 250, 50);
        btnJuice.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        type.add(btnJuice);

        JButton btnFizzy = new JButton("Nước ngọt");
        btnFizzy.setForeground(new Color(90, 50, 30));
        btnFizzy.setBackground(Color.WHITE);
        btnFizzy.setBounds(1250, 0, 250, 50);
        btnFizzy.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        type.add(btnFizzy);

        pnOrder.add(type, BorderLayout.NORTH);

        // ===== CENTER =====
        
        pnCenter.setLayout(new GridLayout(2, 2));
        pnCenter.setPreferredSize(new Dimension(1000, 850));
        pnCenter.setBackground(new Color(255, 255, 255));
        pnOrder.add(pnCenter, BorderLayout.CENTER);

        // ===== RIGHT =====
        JPanel addBill = new JPanel();
        addBill.setLayout(null);
        addBill.setBorder(BorderFactory.createEtchedBorder());
        addBill.setPreferredSize(new Dimension(484, 850));

        JLabel lblAdd = new JLabel("THÊM HÓA ĐƠN MỚI");
        lblAdd.setForeground(new Color(90, 50, 30));
        lblAdd.setBounds(150, 30, 200, 50);
        lblAdd.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        addBill.add(lblAdd);

        JButton btnAdd = new JButton("TẠO HÓA ĐƠN");
        btnAdd.setForeground(new Color(90, 50, 30));
        btnAdd.setBackground(Color.WHITE);
        btnAdd.setBounds(150, 720, 200, 50);
        btnAdd.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        addBill.add(btnAdd);
        
        JPanel pnBill = new JPanel();
        pnBill.setLayout(new BoxLayout(pnBill, 1));
        pnBill.setBounds(10, 100, 464, 600);
        addBill.add(pnBill);

        pnOrder.add(addBill, BorderLayout.EAST);

        add(pnOrder);
        setLocationRelativeTo(null);
        setVisible(true);

        btnCoffee.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnCoffee.setForeground(Color.WHITE);
                btnCoffee.setBackground(new Color(236, 177, 51));
                btnTea.setBackground(Color.WHITE);
                btnTea.setForeground(new Color(236, 177, 51));
                btnMilkTea.setBackground(Color.WHITE);
                btnMilkTea.setForeground(new Color(236, 177, 51));
                btnSmoothie.setBackground(Color.WHITE);
                btnSmoothie.setForeground(new Color(236, 177, 51));
                btnJuice.setBackground(Color.WHITE);
                btnJuice.setForeground(new Color(236, 177, 51));
                btnFizzy.setBackground(Color.WHITE);
                btnFizzy.setForeground(new Color(236, 177, 51));
                getMenuData(1);
                renderView();
            }
        });

        btnTea.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnTea.setForeground(Color.WHITE);
                btnTea.setBackground(new Color(236, 177, 51));
                btnCoffee.setBackground(Color.WHITE);
                btnCoffee.setForeground(new Color(236, 177, 51));
                btnMilkTea.setBackground(Color.WHITE);
                btnMilkTea.setForeground(new Color(236, 177, 51));
                btnSmoothie.setBackground(Color.WHITE);
                btnSmoothie.setForeground(new Color(236, 177, 51));
                btnJuice.setBackground(Color.WHITE);
                btnJuice.setForeground(new Color(236, 177, 51));
                btnFizzy.setBackground(Color.WHITE);
                btnFizzy.setForeground(new Color(236, 177, 51));
                getMenuData(2);
                renderView();
            }
        });
        
        btnMilkTea.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnMilkTea.setForeground(Color.WHITE);
                btnMilkTea.setBackground(new Color(236, 177, 51));
                btnTea.setBackground(Color.WHITE);
                btnTea.setForeground(new Color(236, 177, 51));
                btnCoffee.setBackground(Color.WHITE);
                btnCoffee.setForeground(new Color(236, 177, 51));
                btnSmoothie.setBackground(Color.WHITE);
                btnSmoothie.setForeground(new Color(236, 177, 51));
                btnJuice.setBackground(Color.WHITE);
                btnJuice.setForeground(new Color(236, 177, 51));
                btnFizzy.setBackground(Color.WHITE);
                btnFizzy.setForeground(new Color(236, 177, 51));
                getMenuData(3);
                renderView();
            }
        });
        
        btnSmoothie.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnSmoothie.setForeground(Color.WHITE);
                btnSmoothie.setBackground(new Color(236, 177, 51));
                btnTea.setBackground(Color.WHITE);
                btnTea.setForeground(new Color(236, 177, 51));
                btnMilkTea.setBackground(Color.WHITE);
                btnMilkTea.setForeground(new Color(236, 177, 51));
                btnCoffee.setBackground(Color.WHITE);
                btnCoffee.setForeground(new Color(236, 177, 51));
                btnJuice.setBackground(Color.WHITE);
                btnJuice.setForeground(new Color(236, 177, 51));
                btnFizzy.setBackground(Color.WHITE);
                btnFizzy.setForeground(new Color(236, 177, 51));
                getMenuData(4);
                renderView();
            }
        });
        
        btnJuice.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnJuice.setForeground(Color.WHITE);
                btnJuice.setBackground(new Color(236, 177, 51));
                btnTea.setBackground(Color.WHITE);
                btnTea.setForeground(new Color(236, 177, 51));
                btnMilkTea.setBackground(Color.WHITE);
                btnMilkTea.setForeground(new Color(236, 177, 51));
                btnSmoothie.setBackground(Color.WHITE);
                btnSmoothie.setForeground(new Color(236, 177, 51));
                btnCoffee.setBackground(Color.WHITE);
                btnCoffee.setForeground(new Color(236, 177, 51));
                btnFizzy.setBackground(Color.WHITE);
                btnFizzy.setForeground(new Color(236, 177, 51));
                getMenuData(5);
                renderView();
            }
        });
        
        btnFizzy.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnFizzy.setForeground(Color.WHITE);
                btnFizzy.setBackground(new Color(236, 177, 51));
                btnTea.setBackground(Color.WHITE);
                btnTea.setForeground(new Color(236, 177, 51));
                btnMilkTea.setBackground(Color.WHITE);
                btnMilkTea.setForeground(new Color(236, 177, 51));
                btnSmoothie.setBackground(Color.WHITE);
                btnSmoothie.setForeground(new Color(236, 177, 51));
                btnJuice.setBackground(Color.WHITE);
                btnJuice.setForeground(new Color(236, 177, 51));
                btnCoffee.setBackground(Color.WHITE);
                btnCoffee.setForeground(new Color(236, 177, 51));
                getMenuData(6);
                renderView();
            }
        });
    }

    public void getMenuData(int type) {
        MenuBUS menuBus = new MenuBUS();
        listMenu = menuBus.getMenuByType(type);
    }

    public void renderView() {
        JPanel pnView = new JPanel();
        pnView.setLayout(new GridLayout(2, 2, 20, 20));
        pnView.setBackground(Color.white);
        pnView.setSize(1000, 850);

        for (MenuDTO menu : listMenu) {
            JButton btnItem = new JButton();
            btnItem.setBackground(Color.white);
            btnItem.setLayout(null);
            if (menu.status == "Ngừng Bán") {
                btnItem.setSelected(false);
            }
            JLabel lbImg = new JLabel();
            lbImg.setBounds(30, 30, 150, 150);
            lbImg.setIcon(new ImageIcon(getClass().getResource("/images/" + menu.image)));
            JLabel lbName = new JLabel(menu.name);
            lbName.setBounds(200, 50, 250, 40);
            lbName.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
            String price = String.valueOf(menu.price);
            JLabel lbPrice = new JLabel();
            lbPrice.setBounds(200, 100, 100, 40);
            lbPrice.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 18));
            lbPrice.setText(price);

            btnItem.add(lbImg);
            btnItem.add(lbName);
            btnItem.add(lbPrice);
            pnView.add(btnItem);

            btnItem.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    System.out.println(menu.name);
                }
            });
        }
        switchPanel(pnCenter, pnView);
    }

    public void switchPanel(JPanel fatherPanel, JPanel childPanel) {
        fatherPanel.removeAll();
        fatherPanel.repaint();  // vẽ lại các thành phần đã thay đổi
        fatherPanel.revalidate();  // tính toán lại bố cục

        fatherPanel.add(childPanel);
        fatherPanel.repaint();  // vẽ lại một thành phần con mà nó đã gọi
        fatherPanel.revalidate();
    }
}
