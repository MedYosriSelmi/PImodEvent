/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yosri;

import Entite.Evenement;
import Service.ServiceEvenement;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Yosrio
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfDesc;
    @FXML
    private TextField ph;
    @FXML
    private TextField nbp;
    @FXML
    private DatePicker cldd;
    @FXML
    private DatePicker cldf;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
        ServiceEvenement SE=new ServiceEvenement();
        Evenement ev = new Evenement();
        
        
        java.sql.Date date1 = java.sql.Date.valueOf(cldd.getValue());
         java.sql.Date date2 = java.sql.Date.valueOf(cldf.getValue());
        ev.setNom(tfNom.getText());
        ev.setDescription(tfDesc.getText());
        ev.setUser_id(1);
        ev.setDate_debut(date1);
        ev.setDate_fin(date2);
        ev.setValidite("");
        ev.setNbre_places(Integer.parseInt(nbp.getText()));
        ev.setPhoto(ph.getText());
        /*java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Evenement ev=new Evenement("nom","description",date,date,"", 3,"photo");
        ServiceEvenement SE=new ServiceEvenement();
        */
        SE.ajouter(ev);
       //SE.update(41, 2, "nog", "dec",date,date,"",10,"yosri");
       //SE.delete(ev);
       //System.out.println(SE.readAll());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
