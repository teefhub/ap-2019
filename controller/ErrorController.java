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

public class ErrorController extends au.edu.uts.ap.javafx.Controller<model.Catalogue>{
    @FXML private Button okayBtn;
    
    @FXML private void initialize() {
    }
    
    @FXML private void handleOkay(ActionEvent event) {
    stage.close();
    }
}
