package GUI;

import java.awt.*;
import javax.swing.*;

public class Home extends JFrame {

    public Home() {
        init();
    }

    public void init(){
        setTitle("Coffee shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 800);

        JLabel lbShop= new JLabel("Management page");
        lbShop.setForeground(Color.blue);
        
        add(lbShop);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Home();
    }
}
