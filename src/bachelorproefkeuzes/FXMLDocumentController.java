/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bachelorproefkeuzes;

import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private TextField titel;

    @FXML
    private TextArea beschrijvingen;

    @FXML
    private Button voegBPtoe;

    @FXML
    private TableView<BP> bpTabel;
    
    @FXML
    private TableColumn<BP, String> titelKolom;

    @FXML
    private TableColumn<BP, String> beschrijvingKolom;
    
    
    private BachelorproevenDB model;

    @FXML
    void initialize() {
        model = new BachelorproevenDB();
        voegBPtoe.setOnAction(event -> voegBPToe());
        vulTabel();

    }
    
    public void voegBPToe(){
        Bachelorproef nieuw = new Bachelorproef(titel.getText(), 
                                                beschrijvingen.getText());
        model.voegToe(nieuw);
        ArrayList<Bachelorproef> alles = model.getProeven();
        voegBPtoe.setText(alles.size() + " proeven");
        vulTabel();
    }
    
    
    public void vulTabel() {
        ArrayList<Bachelorproef> alles = model.getProeven();
        ObservableList<BP> bps = FXCollections.observableArrayList();
        for(Bachelorproef bp : alles) {
            bps.add(new BP(bp.getTitel(), bp.getBeschrijving()));
        }
        titelKolom.setCellValueFactory(rij -> rij.getValue().titelProperty());
        beschrijvingKolom.setCellValueFactory(rij -> rij.getValue().beschrijvingProperty());
        
        bpTabel.setItems(bps);
    }
}

