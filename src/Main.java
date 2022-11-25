import model.AttestationModel;
import view.AttestationUI;

public class Main {

    public static void main(String[] args) {
        try {
            AttestationUI attestationUI = new AttestationUI();
            AttestationModel attestationModel = new AttestationModel(attestationUI);
            attestationModel.createDoc();
            attestationUI.setLocationRelativeTo(null); // centrer l'application
            attestationUI.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}