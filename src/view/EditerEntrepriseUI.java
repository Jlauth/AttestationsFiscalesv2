package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditerEntrepriseUI extends JFrame {

    public EditerEntrepriseUI() {

         /*
          Editer client
         */
        JPanel editerEntreprisePane = new JPanel();
        setTitle("Edition des données entreprise");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        editerEntreprisePane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(editerEntreprisePane);
        setLocationRelativeTo(null);
        editerEntreprisePane.setLayout(null);

        /*
          Btn enregistrer
         */
        JButton btnEnregistrer = new JButton("Enregistrer");
        btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEnregistrer.setBounds(50, 350, 120, 50);
        editerEntreprisePane.add(btnEnregistrer);
        btnEnregistrer.addActionListener(e -> {

        });

        /*
          Btn Accueil
         */
        JButton btnAccueil = new JButton("Accueil");
        btnAccueil.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnAccueil.setBounds(210, 350, 120, 50);
        editerEntreprisePane.add(btnAccueil);
        btnAccueil.addActionListener(e -> {
            AccueilUI accueilUI = new AccueilUI();
            accueilUI.setVisible(true);
            dispose();
        });

        /*
          Btn Quitter
         */
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnQuitter.setBounds(360, 350, 120, 50);
        editerEntreprisePane.add(btnQuitter);
        btnAccueil.addActionListener(e -> close());
    }

    public void close() {
        int n = JOptionPane.showOptionDialog(new JFrame(), "Fermer application?", "Quitter", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Oui", "Non"}, JOptionPane.YES_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            dispose();
        }
    }


}
