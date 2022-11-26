package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditerClientUI extends  JFrame{

    public EditerClientUI() {

        /*
          Editer client
         */
        JPanel editerClientPane = new JPanel();
        setTitle("Edition des données client");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        editerClientPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(editerClientPane);
        setLocationRelativeTo(null);
        editerClientPane.setLayout(null);

        /*
          Titre
         */
        JLabel lblTitre = new JLabel("Titre");
        lblTitre.setBounds(34, 36, 46, 14);
        editerClientPane.add(lblTitre);

        JComboBox<String> cmbTitre = new JComboBox<>();
        cmbTitre.setModel(new DefaultComboBoxModel<>(new String[]{"Madame", "Mademoiselle", "Monsieur", "Aucun titre"}));
        cmbTitre.setBounds(34, 61, 153, 22);
        editerClientPane.add(cmbTitre);

        /*
          Nom
         */
        JLabel lblNom = new JLabel("Nom");
        lblNom.setBounds(34, 100, 46, 14);
        editerClientPane.add(lblNom);

        JTextField txtNom = new JTextField();
        txtNom.setBounds(34, 125, 153, 20);
        editerClientPane.add(txtNom);
        txtNom.setColumns(10);

        /*
          Prénom
         */
        JLabel lblPrenom = new JLabel("Prénom");
        lblPrenom.setBounds(240, 100, 46, 14);
        editerClientPane.add(lblPrenom);

        JTextField txtPrenom = new JTextField();
        txtPrenom.setColumns(10);
        txtPrenom.setBounds(240, 125, 153, 20);
        editerClientPane.add(txtPrenom);

        /*
          Adresse
         */
        JLabel lblAdresse = new JLabel("Adresse");
        lblAdresse.setBounds(34, 156, 153, 14);
        editerClientPane.add(lblAdresse);

        JTextField txtAdresse = new JTextField();
        txtAdresse.setColumns(10);
        txtAdresse.setBounds(34, 178, 359, 20);
        editerClientPane.add(txtAdresse);

        /*
          Ville
         */
        JLabel lblVille = new JLabel("Ville");
        lblVille.setBounds(34, 209, 46, 14);
        editerClientPane.add(lblVille);

        JTextField txtVille = new JTextField();
        txtVille.setColumns(10);
        txtVille.setBounds(34, 234, 216, 20);
        editerClientPane.add(txtVille);

        /*
          Code Postal
         */
        JLabel lblCP = new JLabel("Code Postal");
        lblCP.setBounds(298, 209, 95, 14);
        editerClientPane.add(lblCP);

        JTextField txtCP = new JTextField();
        txtCP.setColumns(10);
        txtCP.setBounds(298, 234, 95, 20);
        editerClientPane.add(txtCP);


        /*
          Btn enregistrer
         */
        JButton btnEnregistrer = new JButton("Enregistrer");
        btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEnregistrer.setBounds(50, 350, 120, 50);
        editerClientPane.add(btnEnregistrer);
        btnEnregistrer.addActionListener(e -> {

        });

        /*
          Btn Accueil
         */
        JButton btnAccueil = new JButton("Accueil");
        btnAccueil.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnAccueil.setBounds(210, 350, 120, 50);
        editerClientPane.add(btnAccueil);
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
        editerClientPane.add(btnQuitter);
        btnAccueil.addActionListener(e -> close());
    }

    public void close() {
        int n = JOptionPane.showOptionDialog(new JFrame(), "Fermer application?", "Quitter", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Oui", "Non"}, JOptionPane.YES_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
}
