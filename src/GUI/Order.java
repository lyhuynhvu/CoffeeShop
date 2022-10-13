package GUI;

import BUS.BillBUS;
import BUS.BillDetailBUS;
import BUS.MenuBUS;
import DTO.DetailBillMenuDTO;
import DTO.MenuDTO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class Order extends JFrame {

    private JPanel pnBill = new JPanel();
    private JPanel pnCenter = new JPanel();
    private ArrayList<MenuDTO> listMenu = new ArrayList<>();
    DetailBillMenuDTO[] orderList = new DetailBillMenuDTO[1];
    private int orderTime = 0;
    private JLabel lbTotal = new JLabel("0");

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

        pnBill.setLayout(new BoxLayout(pnBill, 1));
        pnBill.setBounds(10, 100, 464, 550);
        addBill.add(pnBill);

        JLabel lbTotalTitle = new JLabel("Tổng tiền:");
        lbTotalTitle.setForeground(new Color(90, 50, 30));
        lbTotalTitle.setBounds(20, 650, 200, 50);
        lbTotalTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        addBill.add(lbTotalTitle);

        lbTotal.setForeground(new Color(90, 50, 30));
        lbTotal.setBounds(400, 650, 200, 50);
        lbTotal.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        addBill.add(lbTotal);

        JButton btnAdd = new JButton("TẠO HÓA ĐƠN");
        btnAdd.setForeground(new Color(90, 50, 30));
        btnAdd.setBackground(Color.WHITE);
        btnAdd.setBounds(150, 720, 200, 50);
        btnAdd.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        addBill.add(btnAdd);

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
        
        btnAdd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int sum = Integer.parseInt(lbTotal.getText());
                BillBUS bill = new BillBUS();
                bill.create(sum);
                
                int parentId = bill.getTheLast();
                for (int i = 0; i < orderList.length; i++) {
                    int itemId = orderList[i].getIdItem();
                    int quantity = orderList[i].getQuantity();
                    int sub = orderList[i].getPrice() * orderList[i].getQuantity();
                    BillDetailBUS billDetail = new BillDetailBUS();
                    billDetail.create(parentId, itemId, quantity, sub);
                }
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
                    handleOrderList(menu.id, menu.name, menu.price);
                }
            });
        }
        switchPanel(pnCenter, pnView);
    }

    public void handleOrderList(int id, String name, int price) {
        boolean trung = false;
        if (orderTime == 0) {
            orderList = new DetailBillMenuDTO[1];
            orderList[0] = new DetailBillMenuDTO(id, name, price, 1);
            orderTime++;
        } else {
            int len = orderList.length;
            for (int i = 0; i < len; i++) {
                if (orderList[i].getIdItem() == id) {
                    int quan = orderList[i].getQuantity();
                    orderList[i].setQuantity(quan + 1);
                    trung = true;
                    break;
                } else {
                    trung = false;
                }
            }

            if (trung == false) {
                orderList = Arrays.copyOf(orderList, len + 1);
                orderList[len] = new DetailBillMenuDTO(id, name, price, 1);
            }
        }

        renderOrder();
    }

    public void renderOrder() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, 1));
        panel.setPreferredSize(new Dimension(464, 600));
        int tong = 0;

        for (int i = 0; i < orderList.length; i++) {
            JPanel pnItem = new JPanel();
            pnItem.setLayout(null);

            JLabel lbName = new JLabel(orderList[i].getName());
            lbName.setBounds(0, 0, 150, 50);
            lbName.setBackground(Color.pink);
            JLabel lbQuan = new JLabel(String.valueOf(orderList[i].getQuantity()));
            lbQuan.setBounds(220, 0, 20, 50);
            lbQuan.setBackground(Color.lightGray);
            JButton btnIncrease = new JButton("+");
            btnIncrease.setBounds(250, 0, 50, 40);
            btnIncrease.setBackground(Color.white);
            JButton btnDecrease = new JButton("-");
            btnDecrease.setBounds(160, 0, 50, 40);
            btnDecrease.setBackground(Color.white);
            int subPrice = orderList[i].getPrice() * orderList[i].getQuantity();
            JLabel lbPrice = new JLabel(String.valueOf(subPrice));
            lbPrice.setBackground(Color.cyan);
            lbPrice.setBounds(400, 0, 100, 50);
            pnItem.add(lbName);
            pnItem.add(btnIncrease);
            pnItem.add(lbQuan);
            pnItem.add(btnDecrease);
            pnItem.add(lbPrice);
            panel.add(pnItem);

            tong += subPrice;

            final int y = i;
            btnIncrease.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    clickBtnPlus(lbQuan, y, lbPrice);
                }
            });

            btnDecrease.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    int itemQuan = Integer.parseInt(lbQuan.getText()) - 1;
                    if (itemQuan == 0) {
                        removeItem(y);
                    } else {
                        clickBtnTru(lbQuan, y, lbPrice);
                    }
                }
            });
        }

        lbTotal.setText(String.valueOf(tong));
        switchPanel(pnBill, panel);
    }

    public void clickBtnPlus(JLabel lbQuan, int y, JLabel lbPrice) {
        int itemQuan = Integer.parseInt(lbQuan.getText()) + 1;
        lbQuan.setText(String.valueOf(itemQuan));
        orderList[y].setQuantity(itemQuan);
        int subPrice = orderList[y].getPrice() * orderList[y].getQuantity();
        lbPrice.setText(String.valueOf(subPrice));
        
        int tong =0;
        for(int i = 0; i < orderList.length; i++) {
            int sub = orderList[i].getPrice() * orderList[i].getQuantity();
            tong += sub;
        }
        lbTotal.setText(String.valueOf(tong));
    }

    public void clickBtnTru(JLabel lbQuan, int y, JLabel lbPrice) {
        int itemQuan = Integer.parseInt(lbQuan.getText()) - 1;
        lbQuan.setText(String.valueOf(itemQuan));
        orderList[y].setQuantity(itemQuan);
        int subPrice = orderList[y].getPrice() * orderList[y].getQuantity();
        lbPrice.setText(String.valueOf(subPrice));
        
        int tong =0;
        for(int i = 0; i < orderList.length; i++) {
            int sub = orderList[i].getPrice() * orderList[i].getQuantity();
            tong += sub;
        }
        lbTotal.setText(String.valueOf(tong));
    }

    public void removeItem(int i) {
        int len = orderList.length;
        DetailBillMenuDTO[] tmp = new DetailBillMenuDTO[len - 1];

        System.arraycopy(orderList, 0, tmp, 0, i);
        System.arraycopy(orderList, i + 1, tmp, i, len - i - 1);

        orderList = Arrays.copyOf(tmp, len - 1);

        renderOrder();
    }

    public void switchPanel(JPanel fatherPanel, JPanel childPanel) {
        fatherPanel.removeAll();
        fatherPanel.repaint();  // vẽ lại các thành phần đã thay đổi
        fatherPanel.revalidate();  // tính toán lại bố cục

        fatherPanel.add(childPanel);
        fatherPanel.repaint();  // vẽ lại một thành phần con mà nó đã gọi
        fatherPanel.revalidate();
    }

    public static void main(String arg[]) {
        new Order();
    }
}
