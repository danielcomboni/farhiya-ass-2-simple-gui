package com.device.gui.add.laptop;

import com.device.gui.table.LaptopTable;
import com.device.gui.utils.AlertUtils;
import com.device.model.Laptop;
import com.device.model.Tablet;
import com.device.utilities.LaptopData;
import com.device.utilities.TabletsData;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddLaptopPopup extends HBox {

    private Label labelName;
    private TextField fieldName;

    private Label labelType;
    private TextField fieldType;

    private Label labelCore;
    private TextField fieldCore;

    private Button buttonSaveTablet;
    private Button buttonCancel;

    private GridPane gridPane;

    private void addToGrid(Node node,int col,int row){
        this.gridPane.add(node,col,row);
    }

    public AddLaptopPopup(Stage parentStage){

        this.gridPane = new GridPane();
        this.gridPane.setHgap(5);
        this.gridPane.setVgap(5);
        this.gridPane.setPadding(new Insets((5)));
        this.getChildren().add(this.gridPane);

        this.labelName = new Label("Name");
        this.addToGrid(labelName,0,0);
        this.fieldName = new TextField();
        this.addToGrid(fieldName,1,0);

        this.labelType = new Label("Type");
        this.addToGrid(labelType, 0, 1);
        this.fieldType = new TextField();
        this.addToGrid(fieldType,1,1);

        this.labelCore = new Label("core");
        this.addToGrid(labelCore, 0, 2);;
        this.fieldCore = new TextField();
        this.addToGrid(fieldCore, 1, 2);

        this.buttonCancel = new Button("cancel");
        this.buttonSaveTablet = new Button("save");

        HBox hBoxButtons = new HBox();
        hBoxButtons.setPadding(new Insets(5));
        hBoxButtons.setSpacing(5);
        hBoxButtons.getChildren().addAll(this.buttonCancel, this.buttonSaveTablet);

        this.addToGrid(hBoxButtons, 1,3);

        // close the pop up
        this.buttonCancel.setOnAction(e -> parentStage.close());
        // save the new tablet
        this.buttonSaveTablet.setOnAction(e -> this.saveANewLaptop());
    }

    private void saveANewLaptop(){

        String tabletName = this.fieldName.getText();

        if(tabletName == null || tabletName.equals("")){
            AlertUtils.alertWarning("empty name");
            return;
        }

        String tabletType = this.fieldType.getText();

        if(tabletType == null || tabletType.equals("")){
            AlertUtils.alertWarning("empty type");
            return;
        }

        String tabletCore = this.fieldCore.getText();
        if(tabletCore == null || tabletCore.equals("")){
            AlertUtils.alertWarning("empty core");
            return;
        }


        Laptop aLaptop = new Laptop();

        aLaptop.setCore(tabletCore);
        aLaptop.setType(tabletType);
        aLaptop.setName(tabletName);

        new LaptopData().addAnItemToStock(aLaptop);

        LaptopTable.AddToTable(aLaptop);

    }

}
