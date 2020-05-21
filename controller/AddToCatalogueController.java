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

public class AddToCatalogueController extends au.edu.uts.ap.javafx.Controller<model.Catalogue>{
    @FXML private Button addBtn;
    @FXML private TextField typeTf;
    @FXML private TextField nameTf;
    @FXML private TextField priceTf;
    
    private String getType() { return typeTf.getText();}
    private String getName() { return nameTf.getText();}
    private Double getPrice() { return Double.parseDouble(priceTf.getText());}
    
    @FXML private void initialize() {
 
    }
    
    @FXML private void handleAdd(ActionEvent event) throws IOException {
        try {
            model.addPart(getName(), getType(), getPrice());
            stage.close();
        } catch (Exception e) {
            ViewLoader.showStage(e, "/view/error.fxml", "Incorrect Input", new Stage());
        } finally {
            getPrice();
        }
    }
}
