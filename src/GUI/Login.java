package GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

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
        setSize(700, 500);

        JPanel pnLayout = new JPanel();
        pnLayout.setLayout(new BorderLayout());
        add(pnLayout);

        JPanel pnTop = new JPanel();
        pnTop.setPreferredSize(new Dimension(700, 70));
        pnTop.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
        pnTop.setBackground(new Color(255, 153, 51));
        JLabel lbLogin = new JLabel("Đăng nhập hệ thống");
        lbLogin.setFont(new Font("Segoe UI", 1, 30));
        lbLogin.setForeground(Color.white);
        pnTop.add(lbLogin);
        pnLayout.add(pnTop, BorderLayout.NORTH);

        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(null);
        pnCenter.setBackground(new Color(23, 62, 78));
        pnLayout.add(pnCenter, BorderLayout.CENTER);

        JPanel pnForm = new JPanel();
        pnForm.setLayout(null);
        pnForm.setBounds(90, 40, 370, 200);
        pnCenter.add(pnForm);
        JPanel pnLabel = new JPanel();
        pnLabel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 45));
        pnLabel.setBackground(new Color(23, 62, 78));
        pnLabel.setBounds(0, 0, 120, 200);
        pnForm.add(pnLabel);

        JPanel pnText = new JPanel();
        pnText.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 35));
        pnText.setBackground(new Color(23, 62, 78));
        pnText.setBounds(120, 0, 250, 200);
        pnForm.add(pnText);

        JLabel lbuser = new JLabel("Tài khoản:");
        lbuser.setFont(new Font("Tohoma", 1, 18));
        lbuser.setForeground(new Color(204, 204, 204));
        txtuser.setPreferredSize(new Dimension(70, 40));
        txtuser.setFont(new Font("Tohoma", 0, 18));
        JLabel lbpass = new JLabel("Mật khẩu:");
        lbpass.setFont(new Font("Tohoma", 1, 18));
        lbpass.setForeground(new Color(204, 204, 204));
        txtpass.setPreferredSize(new Dimension(70, 40));
        txtpass.setFont(new Font("Tohoma", 0, 24));
        txtpass.setEchoChar('*');
        pnLabel.add(lbuser);
        pnText.add(txtuser);
        pnLabel.add(lbpass);
        pnText.add(txtpass);

        JLabel lbImg = new JLabel();
        lbImg.setBounds(480, 50, 150, 150);
//        lbImg.setIcon(new ImageIcon(getClass().getResource("/img/key.png")));
        pnCenter.add(lbImg);

        ckbSee.setBounds(220, 227, 200, 40);
        ckbSee.setText("Hiện mật khẩu");
        ckbSee.setBackground(new Color(23, 62, 78));
        ckbSee.setFont(new Font("Tohoma", 2, 18));
        ckbSee.setForeground(Color.white);
        pnCenter.add(ckbSee);

        JPanel pnButton = new JPanel();
        pnButton.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
        pnButton.setBounds(170, 290, 300, 50);
        pnButton.setBackground(new Color(23, 62, 78));
        pnCenter.add(pnButton);

        JButton btnReset = new JButton("Hủy");
        btnReset.setFont(new Font("Tohoma", 1, 18));
        btnReset.setBackground(Color.red);
        btnReset.setPreferredSize(new Dimension(130, 40));
        btnReset.setForeground(Color.white);
        btnReset.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        JButton btnOK = new JButton("Đăng nhập");
        btnOK.setFont(new Font("Tohoma", 1, 18));
        btnOK.setBackground(new Color(102, 204, 255));
        btnOK.setPreferredSize(new Dimension(130, 40));
        btnOK.setForeground(Color.white);
        btnOK.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnButton.add(btnReset);
        pnButton.add(btnOK);

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
        String username = txtuser.getText();
        String password = txtpass.getText();
        String user = "root";
        String pass = "123456";
        String url = "jdbc:mysql://localhost:3306/qlbanhang?useUnicode=yes&characterEncoding=UTF-8";
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
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = (Connection) DriverManager.getConnection(url, user, pass);
                String qry = "select * from users where Username='" + username + "' and Password='" + password + "'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(qry);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(panel, "Đăng nhập thành công!", "Lời nhắn", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/img/thanhcong.png")));
                    Home home = new Home();
                    this.setVisible(false);
                    home.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(panel, "Username hoặc Password sai. Vui lòng nhập lại!", "Lời nhắn", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/img/message.jpg")));
                    txtuser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
                    txtpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
                    txtuser.requestFocus();
                }
                conn.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
