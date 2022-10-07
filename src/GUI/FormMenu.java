package GUI;

import BUS.MenuBUS;
import DTO.MenuDTO;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class FormMenu extends JFrame {

    private DefaultTableModel model = new DefaultTableModel();
    private ArrayList<MenuDTO> listSP = new ArrayList<>();

    private JTextField txtName = new JTextField("", 20);
    private JTextField txtPrice = new JTextField("", 20);
    public static JTextField txtType = new JTextField("", 20);
    private ButtonGroup btgStt = new ButtonGroup();
    private JRadioButton rbtActive = new JRadioButton("Đang Bán");
    private JRadioButton rbtInactive = new JRadioButton("Ngừng Bán");
    private JTextField txtImage = new JTextField("", 20);
    private JLabel lblImg = new JLabel();
    private String linkImg;
    private JPanel panel;
    private String actionForm;

    public FormMenu(String action) {
        init();
        actionForm = action;
        if (action == "update") {
            loadForm();
        }
    }

    public void init() {
        setTitle("Form Menu");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 400);

        JPanel pnSP = new JPanel();
        pnSP.setLayout(null);
        pnSP.setBounds(0, 0, 900, 550);

        JPanel pnLabel = new JPanel();
        pnLabel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 35));
        pnLabel.setBounds(30, 10, 115, 240);

        JPanel pnTextfield = new JPanel();
        pnTextfield.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        pnTextfield.setBounds(140, 10, 300, 260);

        JLabel lblName = new JLabel("Tên sản phẩm:");
        lblName.setFont(new Font("Times New Roman", 0, 18));
        txtName.setPreferredSize(new Dimension(70, 40));

        JLabel lblPrice = new JLabel("Đơn giá:");
        lblPrice.setFont(new Font("Times New Roman", 0, 18));
        lblPrice.setBackground(Color.red);
        txtPrice.setPreferredSize(new Dimension(100, 40));

        JLabel lblType = new JLabel("Loại:");
        lblType.setFont(new Font("Times New Roman", 0, 18));
        txtType.setPreferredSize(new Dimension(100, 40));
        txtType.setEditable(false);
        JButton btnType = new JButton("...");
        btnType.setPreferredSize(new Dimension(40, 30));
        btnType.setBackground(Color.white);

        JLabel lblStt = new JLabel("Trạng thái:");
        lblStt.setFont(new Font("Times New Roman", 0, 18));
        btgStt.add(rbtActive);
        rbtActive.setSelected(true);
        rbtActive.setFont(new Font("Times New Roman", 0, 18));
        btgStt.add(rbtInactive);
        rbtInactive.setFont(new Font("Times New Roman", 0, 18));

        pnLabel.add(lblName);
        pnLabel.add(lblPrice);
        pnLabel.add(lblType);
        pnLabel.add(lblStt);
        pnTextfield.add(txtName);
        pnTextfield.add(txtPrice);
        pnTextfield.add(txtType);
        pnTextfield.add(btnType);
        pnTextfield.add(rbtActive);
        pnTextfield.add(rbtInactive);
        pnSP.add(pnLabel);
        pnSP.add(pnTextfield);

        JPanel pnButton = new JPanel();
        pnButton.setLayout(new FlowLayout());
        pnButton.setBounds(130, 280, 450, 50);
        pnSP.add(pnButton);

        JButton btnReset = new JButton("Nhập lại");
        btnReset.setBackground(Color.white);
        btnReset.setPreferredSize(new Dimension(130, 40));
        JButton btnOK = new JButton("Cập nhật");
        btnOK.setBackground(Color.white);
        btnOK.setPreferredSize(new Dimension(130, 40));
        btnOK.setForeground(new Color(69, 138, 0));
        JButton btnCancel = new JButton("Bỏ chọn");
        btnCancel.setBackground(Color.white);
        btnCancel.setPreferredSize(new Dimension(130, 40));
        btnCancel.setForeground(Color.red);
        pnButton.add(btnReset);
        pnButton.add(btnOK);
        pnButton.add(btnCancel);

        lblImg.setBounds(510, 20, 125, 125);
        lblImg.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        pnSP.add(lblImg);

        JButton btnChooseImg = new JButton("Chọn file");
        btnChooseImg.setBounds(510, 150, 125, 40);
        btnChooseImg.setForeground(new Color(255, 149, 43));
        btnChooseImg.setBackground(Color.white);
        pnSP.add(btnChooseImg);
        txtImage.setBounds(470, 200, 200, 40);
        txtImage.setEditable(false);
        pnSP.add(txtImage);

        JFileChooser file = new JFileChooser();

        add(pnSP);
        setLocationRelativeTo(null);
        setVisible(true);

        btnOK.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btOKMouseClicked(evt);
            }
        });
        
        btnChooseImg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btChooseImgMouseClicked(evt);
            }
        });
        
        btnCancel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                setVisible(false);
            }
        });
        
        btnType.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                TableMenuType tbl = new TableMenuType();
                tbl.setVisible(true);
            }
        });
        
        btnReset.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                txtName.setText("");
                txtPrice.setText("");
                txtType.setText("");
                txtName.requestFocus();
            }
        });

        //sự kiện phím enter
        txtName.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtPrice.requestFocus();
                }
            }
        });
    }

    public void loadForm() {
        try {
            int i = MenuManagement.tblNV.getSelectedRow();
            txtName.setText(MenuManagement.tblNV.getModel().getValueAt(i, 1).toString());
            txtPrice.setText(MenuManagement.tblNV.getModel().getValueAt(i, 2).toString());
            txtType.setText(MenuManagement.tblNV.getModel().getValueAt(i, 3).toString());
            String stt = MenuManagement.tblNV.getModel().getValueAt(i, 4).toString();
            if (stt.equals("Đang Bán")) {
                rbtActive.setSelected(true);
                rbtInactive.setSelected(false);
            } else if (stt.equals("Ngừng Bán")) {
                rbtActive.setSelected(false);
                rbtInactive.setSelected(true);
            }
            String img = MenuManagement.tblNV.getModel().getValueAt(i, 5).toString();
            txtImage.setText(img.substring(62));
            lblImg.setIcon(new ImageIcon(getClass().getResource("/images/" + img.substring(62))));
        } catch (Exception e) {
        }
    }

    private void btChooseImgMouseClicked(MouseEvent evt) {
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = file.getSelectedFile();
                Image i = ImageIO.read(selectedFile);
                File tempfile = new File(selectedFile.getPath());
                linkImg = selectedFile.getName();
                tempfile.renameTo(new File("D:\\lyvu\\DoAnChuyenNgannh\\CoffeeShop\\src\\images\\" + linkImg));
                lblImg.setIcon(new ImageIcon(i.getScaledInstance(125, 125, Image.SCALE_SMOOTH)));
                txtImage.setText(linkImg);
            } catch (Exception e) {
            }
        }
    }

    private void btOKMouseClicked(MouseEvent evt) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.name = txtName.getText();
        menuDTO.price = Integer.parseInt(txtPrice.getText());
        menuDTO.type = Integer.parseInt(txtType.getText());
        String stt = "";
        if (rbtActive.isSelected()) {
            stt = "Đang Bán";
        } else if (rbtInactive.isSelected()) {
            stt = "Ngừng Bán";
        }
        menuDTO.status = stt;
        menuDTO.image = txtImage.getText();
        listSP.add(menuDTO);

        MenuBUS menuBus = new MenuBUS();
        if (actionForm == "create") {
            boolean val = validate(0);
            if (val) {
                menuBus.create(menuDTO);
                JOptionPane.showMessageDialog(panel, "Thêm thành công!", "Lời nhắn", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(panel, "Thêm thất bại!", "Lời nhắn", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            boolean val = validate(1);
            if (val) {
                int i = MenuManagement.tblNV.getSelectedRow();
                menuDTO.id = Integer.parseInt(MenuManagement.tblNV.getModel().getValueAt(i, 0).toString());
                menuBus.update(menuDTO);
                JOptionPane.showMessageDialog(panel, "Sửa thành công!", "Lời nhắn", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(panel, "Sửa thất bại!", "Lời nhắn", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        setVisible(false);
        MenuManagement.mngt.loadtblSP();
    }

    public boolean validate(int ts) {
        String name, img, price, type;
        boolean kiemtra = false;
        String ThongBao = "";
        name = txtName.getText();
        price = txtPrice.getText();
        type = txtType.getText();
        img = txtImage.getText();

        if (name.equals("")) {
            ThongBao += "Bạn chưa nhập tên sản phẩm\n";
            txtName.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 51)));
            txtName.requestFocus();
        }

        Pattern patternDG = Pattern.compile("\\d*");
        Matcher matcherDG = patternDG.matcher(price);
        
        if (price.equals("")) {
            txtPrice.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 51)));
            ThongBao += "Bạn chưa nhập đơn giá \n";
            txtPrice.requestFocus();
        } else if (!matcherDG.matches()) {
            txtPrice.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 51)));
            ThongBao += "Dữ liệu nhập không hợp lệ\n";
            txtPrice.requestFocus();
        }
        if (type.equals("")) {
            txtType.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 51)));
            ThongBao += "Bạn chưa nhập mã loại sp \n";
            txtType.requestFocus();
        }
        if (img.equals("")) {
            txtImage.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 51)));
            ThongBao += "Bạn chưa chọn hình \n";
            txtImage.requestFocus();
        }
        if (ThongBao.equals("")) {
            kiemtra = true;
            txtName.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            txtPrice.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            txtType.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            txtImage.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        } else {
            kiemtra = false;
            ThongBao(ThongBao, "lỗi nhập liệu", 2);
        }
        return kiemtra;
    }

    public void ThongBao(String noiDungThongBao, String tieuDeThongBao, int icon) {
        JOptionPane.showMessageDialog(new JFrame(), noiDungThongBao,
                tieuDeThongBao, icon);
    }
}
