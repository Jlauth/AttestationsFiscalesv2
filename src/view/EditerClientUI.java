package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditerClientUI extends  JFrame{

    public EditerClientUI() {

        /*
          Editer client
         */
        JPanel contentPane = new JPanel();
        setTitle("Edition des données client");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        contentPane.setLayout(null);

        JLabel lblImg = new JLabel();
        lblImg.setIcon(new ImageIcon("src/media/en-construction.jpg"));
        Dimension sizeImg = lblImg.getPreferredSize();
        lblImg.setBounds(0, 0, sizeImg.width,sizeImg.height);
        contentPane.add(lblImg);
    }
}
