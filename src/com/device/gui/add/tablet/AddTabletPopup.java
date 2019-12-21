package com.device.gui.add.tablet;

import com.device.gui.table.TabletTable;
import com.device.gui.utils.AlertUtils;
import com.device.model.Desktop;
import com.device.model.Tablet;
import com.device.utilities.DesktopData;
import com.device.utilities.TabletsData;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddTabletPopup extends HBox {

    private Label labelName;
    private TextField fieldName;

    private Label labelType;
    private TextField fieldType;

    private Label labelCameraStrength;
    private TextField fieldCameraStrength;

    private Button buttonSaveTablet;
    private Button buttonCancel;

    private GridPane gridPane;

    private void addToGrid(Node node,int col,int row){
        this.gridPane.add(node,col,row);
    }

    public AddTabletPopup(Stage parentStage){

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

        this.labelCameraStrength = new Label("camera strength");
        this.addToGrid(labelCameraStrength, 0, 2);;
        this.fieldCameraStrength = new TextField();
        this.addToGrid(fieldCameraStrength, 1, 2);

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
        this.buttonSaveTablet.setOnAction(e -> this.saveANewTablet());
    }

    private void saveANewTablet(){

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

        String tabletCameraStrength = this.fieldCameraStrength.getText();
        if(tabletCameraStrength == null || tabletCameraStrength.equals("")){
            AlertUtils.alertWarning("empty camera strength");
            return;
        }


        Tablet aTablet = new Tablet();

        aTablet.setCameraStrength(Double.parseDouble(tabletCameraStrength));
        aTablet.setType(tabletType);
        aTablet.setName(tabletName);

        new TabletsData().addAnItemToStock(aTablet);

        TabletTable.AddToTable(aTablet);

    }

}
