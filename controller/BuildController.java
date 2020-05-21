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
import au.edu.uts.ap.javafx.Controller;
import java.text.DecimalFormat;
import model.*;

public class BuildController extends Controller<model.Build>{
   @FXML private TableView<Part> partsTv;
   @FXML private TableColumn<Part, String> priceClm;
   @FXML private Button remBtn;
   @FXML private Text totalTxt;
   DecimalFormat df = new DecimalFormat("####.00");
   
   private final Double getTotal() { return model.totalPrice(); }
 
   @FXML private void initialize() {
       totalTxt.setText(String.format("$%.2f", getTotal()));
       partsTv.setItems(model.getParts());
       partsTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       priceClm.setCellValueFactory(cellData ->
       cellData.getValue().priceProperty().asString("$%.2f"));
       partsTv.getSelectionModel().selectedItemProperty().addListener(
       (type, name, price) -> remBtn.setDisable(model == null));
       model.getParts().addListener((ListChangeListener.Change<? extends Part> newTotal) ->
       {totalTxt.setText(String.format("$%.2f", getTotal()));});
    }
   
   private ObservableList<Part> getSelectedPart() {
        return partsTv.getSelectionModel().getSelectedItems();
    }
   
   @FXML private void handleCheck(ActionEvent event) throws Exception {
       ViewLoader.showStage(model, "/view/buildcheck.fxml", "Build Validity Status", new Stage());
    }

    @FXML private void handleRem(ActionEvent event) {
        model.remove(getSelectedPart());
    }
    
   @FXML private void handleClose(ActionEvent event) {
        stage.close();
    }
}
