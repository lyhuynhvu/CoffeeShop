package GUI;

import BUS.LoginBUS;
import DTO.AccountDTO;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.ImageIcon;

public class Login extends JFrame {

    private final JTextField txtuser = new JTextField("", 20);
    private final JPasswordField txtpass = new JPasswordField("", 20);
    private final JCheckBox ckbSee = new JCheckBox();
    private JPanel panel;

    public Login() {
        init();
    }

    public void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1092, 728);
        setLayout(new BorderLayout());

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/coffee-background.jpg")));
        add(background);
        background.setLayout(null);

        JLabel lbuser = new JLabel("Tài khoản:");
        lbuser.setBounds(80, 200, 150, 40);
        lbuser.setFont(new Font("Tohoma", 1, 20));
        lbuser.setForeground(new Color(255, 255, 255));

        txtuser.setBounds(230, 200, 300, 40);
        txtuser.setFont(new Font("Tohoma", 0, 20));

        JLabel lbpass = new JLabel("Mật khẩu:");
        lbpass.setBounds(80, 260, 150, 40);
        lbpass.setFont(new Font("Tohoma", 1, 20));
        lbpass.setForeground(new Color(255, 255, 255));

        txtpass.setBounds(230, 260, 300, 40);
        txtpass.setFont(new Font("Tohoma", 0, 24));
        txtpass.setEchoChar('*');

        background.add(lbuser);
        background.add(txtuser);
        background.add(lbpass);
        background.add(txtpass);

        ckbSee.setBounds(230, 330, 20, 20);
        ckbSee.setBackground(new Color(63, 66, 71));
        ckbSee.setForeground(Color.white);
        background.add(ckbSee);

        JLabel lbShowPass = new JLabel("Hiện mật khẩu");
        lbShowPass.setBounds(255, 320, 150, 40);
        lbShowPass.setFont(new Font("Tohoma", 3, 20));
        lbShowPass.setForeground(new Color(255, 255, 255));
        background.add(lbShowPass);

        JButton btnReset = new JButton("Hủy");
        btnReset.setBounds(150, 400, 130, 40);
        btnReset.setPreferredSize(new Dimension(130, 40));
        btnReset.setFont(new Font("Tohoma", 1, 20));
        btnReset.setBackground(new java.awt.Color(90, 50, 30));
        btnReset.setForeground(Color.white);
        btnReset.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        JButton btnOK = new JButton("Đăng nhập");
        btnOK.setBounds(300, 400, 130, 40);
        btnOK.setFont(new Font("Tohoma", 1, 20));
        btnOK.setBackground(new Color(236, 177, 51));
        btnOK.setForeground(Color.white);
        btnOK.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        background.add(btnReset);
        background.add(btnOK);

        setLocationRelativeTo(null);
        setVisible(true);

        btnOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btOKMouseClicked(evt);
            }
        });

        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btResetMouseClicked(evt);
            }
        });

        ckbSee.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ckbSee.isSelected()) {
                    ckbSee.setText("Ẩn mật khẩu");
                    txtpass.setEchoChar((char) 0);
                } else {
                    ckbSee.setText("Hiện mật khẩu");
                    txtpass.setEchoChar('*');
                }
            }
        });
        txtuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtpass.requestFocus();
                }
            }
        });
    }

    private void btResetMouseClicked(java.awt.event.MouseEvent evt) {
        int ret = JOptionPane.showOptionDialog(this, "Bạn muốn đóng chương trình?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Close", "Cancel"}, "Close");
        if (ret == JOptionPane.YES_OPTION) {
            this.setVisible(false);            //chọn close
        } else {
            //trường hợp chon cancel
            panel = (JPanel) getContentPane();
            JOptionPane.showMessageDialog(
                    panel,
                    "Không thoát chương trình",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void btOKMouseClicked(java.awt.event.MouseEvent evt) {
        ArrayList<AccountDTO> acc = new ArrayList<>();
        String username = txtuser.getText();
        String password = txtpass.getText();

        if (username.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập username");
            txtuser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
            txtuser.requestFocus();
        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập password");
            txtpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
            txtpass.requestFocus();
        } else {
            try {
                LoginBUS loginBus = new LoginBUS();
                acc = loginBus.checkLogin(username, password);
                for (AccountDTO account : acc) {
                    if (account.roleId == 1) {
                        Home home = new Home();
                        this.setVisible(false);
                        home.setVisible(true);
                    } else if (account.roleId == 2) {
                        Order order = new Order();
                        this.setVisible(false);
                        order.setVisible(true);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
