package GUI;

import java.awt.*;
import javax.swing.*;

public class Order extends JFrame{
    public Order() {
        init();
    }
    
    public void init(){
        setTitle("Coffee shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 800);

        JLabel lbShop= new JLabel("Order page");
        lbShop.setForeground(Color.red);
        
        add(lbShop);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Order();
    }
}
