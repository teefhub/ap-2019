package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import javafx.scene.layout.GridPane;

public class CheckBuildController extends au.edu.uts.ap.javafx.Controller<model.Build>{
    @FXML private Text cpuTxt;
    @FXML private Text mothTxt;
    @FXML private Text ramTxt;
    @FXML private Text caseTxt;
    @FXML private Text stoTxt;
    @FXML private Text funTxt;
    @FXML private GridPane checkGp;
    
@FXML private void initialize() {
    cpuTxt.setText("The build is missing a CPU.");
    mothTxt.setText("The build is missing a motherboard.");
    ramTxt.setText("The build is missing RAM.");
    caseTxt.setText("The build is missing a case.");  
    stoTxt.setText("The build is missing storage.");
    if (model.hasPartOfType("CPU"))
    checkGp.getChildren().remove(cpuTxt);
    if (model.hasPartOfType("MOTHERBOARD"))
    checkGp.getChildren().remove(mothTxt);
    if (model.hasPartOfType("MEMORY"))
    checkGp.getChildren().remove(ramTxt);   
    if (model.hasPartOfType("CASE"))
    checkGp.getChildren().remove(caseTxt);  
    if (model.hasPartOfType("STORAGE"))
    checkGp.getChildren().remove(stoTxt);  
    if (model.hasPartOfType("CPU") && model.hasPartOfType("MOTHERBOARD") && model.hasPartOfType("MEMORY") && model.hasPartOfType("CASE") && model.hasPartOfType("STORAGE"))
    funTxt.setText("The build is functonal.\n");
}
    @FXML private void handleOkay(ActionEvent event) {
    stage.close();
    }
}
