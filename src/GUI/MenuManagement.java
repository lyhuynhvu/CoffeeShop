package GUI;

import java.awt.Font;
import javax.swing.*;

public class MenuManagement extends JPanel {
    public MenuManagement() {
        init();
    }
    
    public void init(){
        setLayout(null);
        setSize(1500,900);
        
       
        JLabel lbQLSP = new JLabel("Quản lý sản phẩm");
        lbQLSP.setBounds(20, 5, 300, 40);
        lbQLSP.setFont(new Font("Tahoma",1,20));
//        lbQLSP.setIcon(new ImageIcon(getClass().getResource("/img/phone.png")));
        add(lbQLSP);
        
        //setLocationRelativeTo(null);
        setVisible(true);
    }
}
