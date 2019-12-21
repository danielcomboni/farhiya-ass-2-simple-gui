package com.device.gui.add.desktop;

import com.device.gui.table.DesktopTable;
import com.device.gui.utils.AlertUtils;
import com.device.model.Desktop;
import com.device.model.Device;
import com.device.utilities.DesktopData;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddDesktopPopup extends HBox {

    private Label labelName;
    private TextField fieldName;

    private Label labelType;
    private TextField fieldType;

    private Label labelScreenWidth;
    private TextField fieldScreenWidth;

    private Button buttonSaveDesktop;
    private Button buttonCancel;

    private GridPane gridPane;

    private void addToGrid(Node node,int col,int row){
        this.gridPane.add(node,col,row);
    }

    public AddDesktopPopup(Stage parentStage){

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

        this.labelScreenWidth = new Label("screen width");
        this.addToGrid(labelScreenWidth, 0, 2);;
        this.fieldScreenWidth = new TextField();
        this.addToGrid(fieldScreenWidth, 1, 2);

        this.buttonCancel = new Button("cancel");
        this.buttonSaveDesktop = new Button("save");

        HBox hBoxButtons = new HBox();
        hBoxButtons.setPadding(new Insets(5));
        hBoxButtons.setSpacing(5);
        hBoxButtons.getChildren().addAll(this.buttonCancel, this.buttonSaveDesktop);

        this.addToGrid(hBoxButtons, 1,3);

        // close the pop up
        this.buttonCancel.setOnAction(e -> parentStage.close());
        // save the new desktop
        this.buttonSaveDesktop.setOnAction(e -> this.saveANewDesktop());
    }

    private void saveANewDesktop(){

        String desktopName = this.fieldName.getText();

        if(desktopName == null || desktopName.equals("")){
            AlertUtils.alertWarning("empty name");
            return;
        }

        String desktopType = this.fieldType.getText();

        if(desktopType == null || desktopType.equals("")){
            AlertUtils.alertWarning("empty type");
            return;
        }

        String desktopScreenSize = this.fieldScreenWidth.getText();
        if(desktopScreenSize == null || desktopScreenSize.equals("")){
            AlertUtils.alertWarning("empty screen width");
            return;
        }


        Desktop aDesktop = new Desktop();
        aDesktop.setName(desktopName);
        aDesktop.setType(desktopType);
        aDesktop.setScreenWidth(desktopScreenSize);
        new DesktopData().addAnItemToStock(aDesktop);

        DesktopTable.AddToTable(aDesktop);

    }

}
