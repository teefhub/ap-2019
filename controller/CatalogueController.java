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
import model.*;
import au.edu.uts.ap.javafx.Controller;

public class CatalogueController extends Controller<model.Catalogue>    {
   @FXML private TableView<Part> partsTv;
   @FXML private TableColumn<Part, String> priceClm;
   @FXML private TextField typeTf;
   @FXML private TextField minTf;
   @FXML private TextField maxTf;
   @FXML public Button addBtn;
   @FXML private Button remBtn;
   
   private String getType() { return typeTf.getText();}
   private String getMin() { return minTf.getText();}
   private String getMax() { return maxTf.getText();}
   
   @FXML private void initialize() {
       partsTv.setItems(model.getCurrentView());
       priceClm.setCellValueFactory(cellData ->
       cellData.getValue().priceProperty().asString("$%.2f"));
       partsTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       partsTv.getSelectionModel().selectedItemProperty().addListener(
               (type, name, price) -> addBtn.setDisable(model == null));
       partsTv.getSelectionModel().selectedItemProperty().addListener(
               (type, name, price) -> remBtn.setDisable(model == null));
       typeTf.textProperty().addListener((o, oldText, newText) -> 
       filter());
       minTf.textProperty().addListener((o, oldText, newText) -> 
       filter());
       maxTf.textProperty().addListener((o, oldText, newText) -> 
       filter());
    }
   private ObservableList<Part> getSelectedPart() {
        return partsTv.getSelectionModel().getSelectedItems();
    }
   
   @FXML private void handleClose(ActionEvent event) {
        stage.close();
    }
   
   private void filter(){
       model.filterList(getType(), getMin(), getMax());
   }
   
   @FXML private void handleAddBuild(ActionEvent event) {
       model.addToBuild(getSelectedPart());
   }
   
      @FXML private void handleRemBuild(ActionEvent event) {
       model.remove(getSelectedPart());
   }
   
   @FXML private void handleAddPart(ActionEvent event) throws Exception {
       ViewLoader.showStage(model, "/view/addtocatalogue.fxml", "Add New Part to Catalogue", new Stage());
   }
}


