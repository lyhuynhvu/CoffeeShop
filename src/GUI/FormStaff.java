package GUI;

import BUS.StaffBUS;
import DTO.StaffDTO;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormStaff extends JFrame {

    private JTextField txtFullname = new JTextField("", 20);
    private JTextField txtPhone = new JTextField("", 20);
    private ButtonGroup btgStt = new ButtonGroup();
    private JRadioButton rbtActive = new JRadioButton("Đang làm");
    private JRadioButton rbtInactive = new JRadioButton("Đã nghỉ");
    private ButtonGroup btgGender = new ButtonGroup();
    private JRadioButton rbtNam = new JRadioButton("Nam");
    private JRadioButton rbtNu = new JRadioButton("Nữ");
    private JTextField txtEmail = new JTextField("", 20);
    private JTextField txtAdd = new JTextField("", 20);

    private JPanel panel;
    private String actionForm;
    private DefaultTableModel model = new DefaultTableModel();

    public FormStaff(String action) {
        init();
        actionForm = action;
        if (action == "update") {
            loadForm();
        }
    }

    public void init() {
        setTitle("Form Staff");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 400);

        JPanel pnLeft = new JPanel();
        pnLeft.setLayout(null);
        pnLeft.setBounds(0, 0, 450, 250);

        JPanel pnLabel1 = new JPanel();
        pnLabel1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 35));
        pnLabel1.setBounds(40, 10, 100, 200);

        JPanel pnTextfield1 = new JPanel();
        pnTextfield1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        pnTextfield1.setBounds(140, 10, 290, 220);

        JLabel lblName = new JLabel("Tên đầy đủ:");
        lblName.setFont(new Font("Times New Roman", 0, 18));
        txtFullname.setPreferredSize(new Dimension(70, 40));

        JLabel lblPhone = new JLabel("Điện thoại:");
        lblPhone.setFont(new Font("Times New Roman", 0, 18));
        lblPhone.setBackground(Color.red);
        txtPhone.setPreferredSize(new Dimension(100, 40));

        JLabel lblGender = new JLabel("Giới tính:");
        lblGender.setFont(new Font("Times New Roman", 0, 18));
        btgGender.add(rbtNam);
        rbtNam.setSelected(true);
        rbtNam.setPreferredSize(new Dimension(100, 40));
        rbtNam.setFont(new Font("Times New Roman", 0, 18));
        btgGender.add(rbtNu);
        rbtNu.setPreferredSize(new Dimension(100, 40));
        rbtNu.setFont(new Font("Times New Roman", 0, 18));

        pnLabel1.add(lblName);
        pnLabel1.add(lblPhone);
        pnLabel1.add(lblGender);
        pnTextfield1.add(txtFullname);
        pnTextfield1.add(txtPhone);
        pnTextfield1.add(rbtNam);
        pnTextfield1.add(rbtNu);
        pnLeft.add(pnLabel1);
        pnLeft.add(pnTextfield1);

        JPanel pnRight = new JPanel();
        pnRight.setLayout(null);
        pnRight.setBounds(450, 0, 450, 250);

        JPanel pnLabel2 = new JPanel();
        pnLabel2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 35));
        pnLabel2.setBounds(20, 10, 100, 200);

        JPanel pnTextfield2 = new JPanel();
        pnTextfield2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        pnTextfield2.setBounds(120, 10, 290, 220);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Times New Roman", 0, 18));
        txtEmail.setPreferredSize(new Dimension(70, 40));

        JLabel lblAdd = new JLabel("Địa chỉ:");
        lblAdd.setFont(new Font("Times New Roman", 0, 18));
        txtAdd.setPreferredSize(new Dimension(70, 40));

        JLabel lblStt = new JLabel("Trạng thái:");
        lblStt.setFont(new Font("Times New Roman", 0, 18));
        btgStt.add(rbtActive);
        rbtActive.setSelected(true);
        rbtActive.setFont(new Font("Times New Roman", 0, 18));
        btgStt.add(rbtInactive);
        rbtInactive.setFont(new Font("Times New Roman", 0, 18));

        pnLabel2.add(lblEmail);
        pnLabel2.add(lblAdd);
        pnLabel2.add(lblStt);
        pnTextfield2.add(txtEmail);
        pnTextfield2.add(txtAdd);
        pnTextfield2.add(rbtActive);
        pnTextfield2.add(rbtInactive);
        pnRight.add(pnLabel2);
        pnRight.add(pnTextfield2);

        JPanel pnButton = new JPanel();
        pnButton.setLayout(new FlowLayout());
        pnButton.setBounds(200, 250, 450, 50);
        add(pnButton);

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

        add(pnLeft);
        add(pnRight);
        add(pnButton);
        setLocationRelativeTo(null);
        setVisible(true);

        btnOK.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btOKMouseClicked(evt);
            }
        });
        btnCancel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                setVisible(false);
            }
        });
        btnReset.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                txtFullname.setText("");
                txtPhone.setText("");
                txtEmail.setText("");
                txtAdd.setText("");
                txtFullname.requestFocus();
            }
        });

        //sự kiện phím enter
        txtFullname.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtPhone.requestFocus();
                }
            }
        });
        txtPhone.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtEmail.requestFocus();
                }
            }
        });
        txtEmail.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtAdd.requestFocus();
                }
            }
        });
    }

    public void loadForm() {
        try {
            int i = StaffManagement.tblStaff.getSelectedRow();
            txtFullname.setText(StaffManagement.tblStaff.getModel().getValueAt(i, 2).toString());
            txtPhone.setText(StaffManagement.tblStaff.getModel().getValueAt(i, 4).toString());
            txtEmail.setText(StaffManagement.tblStaff.getModel().getValueAt(i, 5).toString());
            txtAdd.setText(StaffManagement.tblStaff.getModel().getValueAt(i, 6).toString());
            String gen = StaffManagement.tblStaff.getModel().getValueAt(i, 3).toString();
            if (gen.equals("Nam")) {
                rbtNam.setSelected(true);
                rbtNu.setSelected(false);
            } else if (gen.equals("Nữ")) {
                rbtNam.setSelected(false);
                rbtNu.setSelected(true);
            }
            String stt = StaffManagement.tblStaff.getModel().getValueAt(i, 7).toString();
            if (stt.equals("Đang làm")) {
                rbtActive.setSelected(true);
                rbtInactive.setSelected(false);
            } else if (stt.equals("Đã nghỉ")) {
                rbtActive.setSelected(false);
                rbtInactive.setSelected(true);
            }
        } catch (Exception e) {
        }
    }

    private void btOKMouseClicked(MouseEvent evt) {
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.fullname = txtFullname.getText();
        staffDTO.phone = txtPhone.getText();
        staffDTO.email = txtEmail.getText();
        staffDTO.address = txtAdd.getText();
        String gender = "";
        if (rbtNam.isSelected()) {
            gender = "Nam";
        } else if (rbtNu.isSelected()) {
            gender = "Nữ";
        }
        staffDTO.gender = gender;
        String stt = "";
        if (rbtActive.isSelected()) {
            stt = "Đang làm";
        } else if (rbtInactive.isSelected()) {
            stt = "Đã nghỉ";
        }
        staffDTO.status = stt;

        StaffBUS staffBus = new StaffBUS();
        if (actionForm == "create") {
            boolean val = validate(0);
            if (val) {
                staffBus.create(staffDTO);
                JOptionPane.showMessageDialog(panel, "Thêm thành công!", "Lời nhắn", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            boolean val = validate(1);
            if (val) {
                int i = StaffManagement.tblStaff.getSelectedRow();
                staffDTO.id = Integer.parseInt(StaffManagement.tblStaff.getModel().getValueAt(i, 0).toString());
                staffBus.update(staffDTO);
                JOptionPane.showMessageDialog(panel, "Sửa thành công!", "Lời nhắn", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        setVisible(false);
        StaffManagement.smgt.loadTbl();
    }

    public boolean validate(int ts) {
        String name, email, phone, address;
        boolean kiemtra = false;
        String ThongBao = "";
        name = txtFullname.getText();
        email = txtEmail.getText();
        phone = txtPhone.getText();
        address = txtAdd.getText();

        if (name.equals("")) {
            ThongBao += "Chưa nhập tên\n";
            txtFullname.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 51)));
            txtFullname.requestFocus();
        }

        if (address.equals("")) {
            txtAdd.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 51)));
            ThongBao += "Chưa nhập địa Chỉ\n";
            txtAdd.requestFocus();
        }

        if (rbtNam.isSelected() == false && rbtNu.isSelected() == false) {
            ThongBao += "Chưa chọn giới tính\n";
        }

        if (phone.equals("")) {
            txtPhone.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 51)));
            ThongBao += "Chưa nhập Số ĐT \n";
            txtPhone.requestFocus();
        } else if (phone.length() != 10) {
            txtPhone.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 51)));
            ThongBao += "Số ĐT không hợp lệ. Vui lòng nhập lại! \n";
            txtPhone.requestFocus();
        }

        Pattern pt = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pt.matcher(email);
        if (email.equals("")) {
            txtEmail.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 51)));
            txtEmail.requestFocus();
            ThongBao += "Chưa nhập email\n";
        } else if (!matcher.matches()) {
            txtEmail.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 51)));
            ThongBao += "Email không hợp lệ\n";
            txtEmail.requestFocus();
        }

        if (ThongBao.equals("")) {
            kiemtra = true;
            txtFullname.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            txtPhone.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            txtEmail.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            txtAdd.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        } else {
            kiemtra = false;
            ThongBao(ThongBao, "lỗi nhập liệu", 2);
        }
        return kiemtra;
    }

    public void ThongBao(String noiDungThongBao, String tieuDeThongBao, int icon) {
        JOptionPane.showMessageDialog(new JPanel(), noiDungThongBao,
                tieuDeThongBao, icon);
    }
}
