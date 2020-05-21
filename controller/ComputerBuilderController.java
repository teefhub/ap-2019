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
import javafx.application.Platform;

public class ComputerBuilderController extends Controller<model.ComputerBuilder>{
    @FXML private Button catBtn;
    @FXML private Button buildBtn;
    @FXML private Button quitBtn;
    model.Build build = new model.Build();
    model.Catalogue catalogue = new model.Catalogue(build);
    
private model.Build getBuild() {
    return build;
}

private model.Catalogue getCat() {
    return catalogue;
}
    
    public final model.ComputerBuilder getComputerBuilder(){return model;}
    
@FXML private void initialize() {
    catBtn.setText("View\nCatalogue");
    buildBtn.setText("View\nBuild");
    }
@FXML private void handleViewCat(ActionEvent event) throws Exception{
    ViewLoader.showStage(catalogue, "/view/catalogue.fxml", "Catalogue", new Stage());
}

@FXML private void handleViewBuild(ActionEvent event) throws Exception {
    ViewLoader.showStage(build, "/view/build.fxml", "Current Build", new Stage());
}

@FXML private void handleQuit(ActionEvent event) {
    Platform.exit();
}
}
