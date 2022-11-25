import model.AttestationModel;
import view.AccueilUI;
import view.AttestationUI;

public class Main {

    public static void main(String[] args) {
        try {
            AttestationUI attestationUI = new AttestationUI();
            AccueilUI accueilUI = new AccueilUI();
            AttestationModel attestationModel = new AttestationModel(attestationUI);
            attestationModel.createDoc();
            accueilUI.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}