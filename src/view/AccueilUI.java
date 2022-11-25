package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AccueilUI extends JFrame {

    private JPanel panel1;
    private JButton btnAttestation;
    private JButton btnEditerClient;

    public AccueilUI() {
        createUIComponents();
    }

    public void createUIComponents() {
         /*
          Création Accueil
         */
        setPanel1(new JPanel());
        setTitle("Attestation Fiscale");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        getPanel1().setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(getPanel1());
        setLocationRelativeTo(null);
        getPanel1().setLayout(null);

        /*
          Bouton nouvelle attestation
         */
        setBtnAttestation(new JButton("Nouvelle attestation"));
        getBtnAttestation().setFont(new Font("Tahoma", Font.BOLD, 14));
        getBtnAttestation().setBounds(30, 50, 200, 50);
        getPanel1().add(getBtnAttestation());
        getBtnAttestation().addActionListener(e -> {
            AttestationUI attestationUI = new AttestationUI();
            attestationUI.setVisible(true);
            dispose();
        });

        /*
          Bouton éditer client
         */
        setBtnEditerClient(new JButton("Editer client"));
        getBtnEditerClient().setFont(new Font("Tahoma", Font.BOLD, 14));
        getBtnEditerClient().setBounds(30, 150, 200, 50);
        getPanel1().add(getBtnEditerClient());
        getBtnEditerClient().addActionListener(e -> {
            EditerClientUI editerClientUI = new EditerClientUI();
            editerClientUI.setVisible(true);
            dispose();
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JButton getBtnAttestation() {
        return btnAttestation;
    }

    public void setBtnAttestation(JButton btnAttestation) {
        this.btnAttestation = btnAttestation;
    }

    public JButton getBtnEditerClient() {
        return btnEditerClient;
    }

    public void setBtnEditerClient(JButton btnEditerClient) {
        this.btnEditerClient = btnEditerClient;
    }
}



