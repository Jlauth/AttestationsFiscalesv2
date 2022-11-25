package model;

import org.apache.poi.hslf.blip.Metafile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import view.AttestationUI;

import javax.swing.*;
import java.io.*;
import java.math.BigInteger;

public class AttestationModel {


    private static final String CHEAT = "                ";
    private static final String ENTREPRISE_HOLDER = "Adelino Araujo";
    private static final String ENTREPRISE_NAME = "Arkadia PC";
    private static final String ENTREPRISE_STREET = "4, rue des Pyrénées";
    private static final String ENTREPRISE_CITY = "92500 Rueil Malmaison";
    private static final String ENTREPRISE_PHONE = "+33 (1) 47 08 98 38";
    private static final String ENTREPRISE_MAIL = "contact@arkadia-pc.fr";
    private static final String ENTREPRISE_ID = "Agrément N° SAP524160330";

    // Appel de la classe View
    protected AttestationUI attestationUI;

    // Création de XWPFDocument
    XWPFDocument document = new XWPFDocument();

    /**
     * Constructeur de la classe Attestation
     */
    public AttestationModel(AttestationUI attestationUI) {
        this.attestationUI = attestationUI;
        // Création de la table
        XWPFTable tableGlobal = document.createTable();
        // Enlever les bordures de la table
        tableGlobal.removeBorders();
        // Custom des marges du document
        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        CTPageMar pageMar = sectPr.addNewPgMar();
        pageMar.setTop(BigInteger.valueOf(550L));
        pageMar.setBottom(BigInteger.valueOf(550L));
        pageMar.setLeft(BigInteger.valueOf(1000L));
        pageMar.setRight(BigInteger.valueOf(1000L));

        /*
          Header
         */
        // Header gauche (table pos0)
        // infos entreprise
        XWPFHeader header = document.createHeader(HeaderFooterType.DEFAULT);
        XWPFTable headerTable = header.createTable(1, 3);
        headerTable.removeBorders();
        XWPFTableRow rowHeader = headerTable.getRow(0);
        XWPFTableCell cellHeader = rowHeader.getCell(0);
        XWPFParagraph paragraphHeader = cellHeader.getParagraphArray(0);
        XWPFRun runHeader = paragraphHeader.createRun();
        runHeader.setText(ENTREPRISE_HOLDER);
        runHeader.addBreak();
        runHeader.setText(ENTREPRISE_NAME);
        runHeader.addBreak();
        runHeader.setText(ENTREPRISE_CITY);
        runHeader.addBreak();
        runHeader.setText(ENTREPRISE_MAIL);
        runHeader.addBreak();
        runHeader.setText(ENTREPRISE_ID);
        paragraphHeader.setAlignment(ParagraphAlignment.LEFT);

        cellHeader = rowHeader.getCell(2);
        paragraphHeader = cellHeader.getParagraphArray(0);
        runHeader = paragraphHeader.createRun();
        InputStream is;
        try {
            File imgLogo = new File("src/media/logofinal.jpg");
            String imgLogoAbsolute = imgLogo.getAbsolutePath();
            is = new FileInputStream(imgLogoAbsolute);
            runHeader.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imgLogoAbsolute, Units.toEMU(110), Units.toEMU(80));
            paragraphHeader.setAlignment(ParagraphAlignment.RIGHT);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        // TODO trouver une méthode pour aller à la ligne sans utiliser le "cheat"
       /*
        row.getCell(0).setText(ENTREPRISE_NAME + CHEAT + CHEAT + CHEAT);
        row.getCell(0).setText(ENTREPRISE_STREET + CHEAT + CHEAT);
        row.getCell(0).setText(ENTREPRISE_CITY + CHEAT);
        row.getCell(0).setText(CHEAT + ENTREPRISE_PHONE);
        row.getCell(0).setText(CHEAT + ENTREPRISE_MAIL + CHEAT);
        row.getCell(0).setText(ENTREPRISE_ID);
        row.addNewTableCell();
        row.addNewTableCell();
*/
        // TODO mieux aligner le logo
        // Header droit (table pos2)
        // logo


        /*
        Body
         */
        // Infos client (right)
        XWPFParagraph paragraph2 = document.createParagraph();
        XWPFRun run2 = paragraph2.createRun();
        run2.addBreak();
        run2.setText(attestationUI.getTxtNom() + " " + attestationUI.getTxtPrenom());
        run2.addBreak();
        run2.setText(attestationUI.getTxtAdresse());
        run2.addBreak();
        run2.setText(attestationUI.getTxtCP() + " " + attestationUI.getTxtVille());
        run2.addBreak();
        run2.addBreak();
        run2.setText("le " + attestationUI.getDateAttestation() + ",");
        run2.addBreak();
        run2.addBreak();
        run2.setFontFamily("Calibri");
        paragraph2.setAlignment(ParagraphAlignment.RIGHT);

        // Titre (top center)
        XWPFParagraph paragraph3 = document.createParagraph();
        XWPFRun run3 = paragraph3.createRun();
        run3.setText("Attestation destinée au Centre des Impôts");
        run3.setFontSize(20);
        run3.addBreak();
        run3.setFontFamily("Calibri");
        run3.setUnderline(UnderlinePatterns.SINGLE);
        paragraph3.setAlignment(ParagraphAlignment.CENTER);

        // Body (middle center)
        XWPFParagraph paragraph4 = document.createParagraph();
        XWPFRun run4 = paragraph4.createRun();
        run4.addBreak();
        run4.addBreak();
        run4.addTab();
        run4.setText("Je soussigné Monsieur " + ENTREPRISE_HOLDER + " gérant de l'organisme agréé " + ENTREPRISE_NAME + " certifie que " + attestationUI.getCmbTitre() + " " + attestationUI.getTxtPrenom() + " " + attestationUI.getTxtNom() + " a bénéficié d'assistance informatique à domicile, service à la personne :");
        run4.addBreak();
        run4.addBreak();
        run4.addTab();
        run4.addTab();
        run4.setText("Montant total des factures pour l'année fiscale " + attestationUI.getExerciceFiscal() + " : " + attestationUI.getTxtMontantAttest() + " euros");
        run4.addBreak();
        run4.addTab();
        run4.addTab();
        run4.addBreak();
        run4.addBreak();
        run4.setText("Intervenants : ");
        run4.addBreak();
        run4.addBreak();
        run4.addTab();
        run4.addTab();
        run4.setText(ENTREPRISE_HOLDER);
        run4.addBreak();
        run4.addBreak();
        run4.setText("Prestations :");
        run4.addBreak();
        run4.addBreak();
        run4.addTab();
        run4.setText("Les sommes perçues pour financer les services à la personne sont à déduire de la valeur indiquée précédemment.");
        run4.addBreak();
        run4.addBreak();
        run4.addTab();
        run4.setText("La déclaration engage la responsabilité du seul contribuable");
        run4.addBreak();
        run4.addBreak();
        // écriture font size différent : 10
        XWPFParagraph paragraph04 = document.createParagraph();
        XWPFRun run04 = paragraph04.createRun();
        run04.setText("* Pour les personnes utilisant le Chèque Emploi Service Universel, seul le montant financé personnellement est déductible. " + "Une attestation est délivrée par les établissements qui préfinancent le CESU.");
        run04.setFontSize(10);
        XWPFParagraph paragraph004 = document.createParagraph();
        XWPFRun run004 = paragraph004.createRun();
        run004.addBreak();
        run004.addBreak();
        run004.addTab();
        run004.setText("Fait pour valoir ce que de droit,");
        run004.addBreak();
        run004.addBreak();
        run004.addBreak();
        run004.addBreak();
        run004.setText(ENTREPRISE_HOLDER + ", gérant.");
        run004.setFontFamily("Calibri");
        paragraph004.setIndentationLeft(0);
        paragraph004.setIndentationHanging(100);

        // import de la signature
        XWPFParagraph paragraph5 = document.createParagraph();
        XWPFRun run5 = paragraph5.createRun();
        try {
            File imgSignature = new File("src/media/signature.jpg");
            String imgSignatureAbsolute = imgSignature.getAbsolutePath();
            is = new FileInputStream(imgSignatureAbsolute);
            run5.addBreak();
            run5.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imgSignatureAbsolute, Units.toEMU(200), Units.toEMU(70));
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        paragraph5.setAlignment(ParagraphAlignment.RIGHT);
    }

    // Méthode de création du Document
    public void createDoc() {
        try {
            document = new XWPFDocument();
            System.out.println("CREATED.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Méthode de sauvegarde du Document
    public void saveDoc() throws IOException {
        // Constructeurs
        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Enregistrer sous");
        // création du fichier
        fileChooser.setSelectedFile(new File("Attestation-Fiscale" + attestationUI.getYearChooser() + "-" + attestationUI.getTxtPrenom() + "-" + attestationUI.getTxtNom() + ".doc"));
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            FileOutputStream output;
            try {
                output = new FileOutputStream(fileToSave.getAbsolutePath());
                document.write(output);
                output.close();
                System.out.println("Sauvegarde du document: " + fileToSave);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}


