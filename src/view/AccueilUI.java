package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AccueilUI extends JFrame {

    public AccueilUI() {

         /*
          Création Accueil
         */
        JPanel accueilPane = new JPanel();
        setTitle("Attestation Fiscale");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        accueilPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(accueilPane);
        setLocationRelativeTo(null);
        accueilPane.setLayout(null);

        /*
          Bouton nouvelle attestation
         */
        JButton btnAttestation = new JButton("Nouvelle attestation");
        btnAttestation.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnAttestation.setBounds(30, 50, 200, 50);
        accueilPane.add(btnAttestation);
        btnAttestation.addActionListener(e -> {
            AttestationUI attestationUI = new AttestationUI();
            attestationUI.setVisible(true);
            dispose();
        });

        /*
          Bouton éditer client
         */
        JButton btnEditerClient = new JButton("Editer client");
        btnEditerClient.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEditerClient.setBounds(30, 150, 200, 50);
        accueilPane.add(btnEditerClient);
        btnEditerClient.addActionListener(e -> {
            EditerClientUI editerClientUI = new EditerClientUI();
            editerClientUI.setVisible(true);
            dispose();
        });

         /*
          Bouton éditer entreprise
         */
        JButton btnEditerEntreprise = new JButton("Editer entreprise");
        btnEditerEntreprise.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEditerEntreprise.setBounds(30,350,200, 50);
        accueilPane.add(btnEditerEntreprise);
        btnEditerEntreprise.addActionListener(e -> {
            EditerEntrepriseUI editerEntrepriseUI = new EditerEntrepriseUI();
            editerEntrepriseUI.setVisible(true);
            dispose();
        });
    }
}



