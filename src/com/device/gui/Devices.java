/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.device.gui;

import com.device.gui.add.desktop.AddDesktopPopup;
import com.device.gui.add.desktop.AddDesktopUI;
import com.device.gui.add.laptop.AddLaptoptUI;
import com.device.gui.add.smartphone.AddSmartphonePopup;
import com.device.gui.add.smartphone.AddSmartphoneUI;
import com.device.gui.add.tablet.AddTabletUI;
import com.device.gui.table.DesktopTable;
import com.device.gui.table.LaptopTable;
import com.device.gui.table.SmartphoneTable;
import com.device.gui.table.TabletTable;
import com.device.gui.utils.AlertUtils;
import com.device.model.Desktop;
import com.device.model.Laptop;
import com.device.model.Smartphone;
import com.device.model.Tablet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author farhi
 */
public class Devices extends BorderPane {
   
    private HBox deviceNames;
    private ComboBox<String> comboxDeviceNames;
    private void deviceNamesInList(ComboBox<String> comboBoxNames){
        
        ObservableList<String> devices = FXCollections.observableArrayList();
        devices.add(Tablet.class.getSimpleName());
        devices.add(Smartphone.class.getSimpleName());
        devices.add(Desktop.class.getSimpleName());
        devices.add(Laptop.class.getSimpleName());
        comboBoxNames.setItems(devices);
        
    }
    
    private void buildDevicesUI(){
        
        this.deviceNames = new HBox();
        this.setTop(this.deviceNames);
        
        this.comboxDeviceNames = new ComboBox<>();        
        this.deviceNames.getChildren().add(this.comboxDeviceNames);
        this.deviceNamesInList(this.comboxDeviceNames);

        Button addNewDeviceButton = new Button("Add device");
        this.deviceNames.getChildren().add((addNewDeviceButton));

        addNewDeviceButton.setOnAction(e -> {


            if (comboxDeviceNames.getSelectionModel().getSelectedIndex() < 0){
                AlertUtils.alertWarning("please choose a device from the list on the left");
            }else {

                if(comboxDeviceNames.getSelectionModel().getSelectedItem().equals("Tablet")){
                    new AddTabletUI("add new tablet").showAndWait();
                }

                if(comboxDeviceNames.getSelectionModel().getSelectedItem().equals("Desktop")){
                    new AddDesktopUI("add new desktop").showAndWait();
                }

                if(comboxDeviceNames.getSelectionModel().getSelectedItem().equals("Smartphone")){
                    new AddSmartphoneUI("add new smartphone").showAndWait();
                }

                if(comboxDeviceNames.getSelectionModel().getSelectedItem().equals("Laptop")){
                    new AddLaptoptUI("add new laptop").showAndWait();
                }

            }

        });

        this.setTop(this.deviceNames);
    
    }

    private void setTables(){

        VBox hBox = new VBox();

        VBox vBoxDesktop = new VBox();
        vBoxDesktop.getChildren().add(new Label("Desktops"));
        vBoxDesktop.getChildren().add(DesktopTable.getTable());

        VBox vBoxLaptop = new VBox();
        vBoxLaptop.getChildren().add(new Label("Laptops"));
        vBoxLaptop.getChildren().add(new LaptopTable().getTable());

        VBox vBoxTablet = new VBox();
        vBoxTablet.getChildren().add(new Label("Tablets"));
        vBoxTablet.getChildren().add(new TabletTable().getTable());

        VBox vBoxSmartphone = new VBox();
        vBoxSmartphone.getChildren().add(new Label("Smartphones"));
        vBoxSmartphone.getChildren().add(new SmartphoneTable().getTable());

        hBox.getChildren().add(vBoxDesktop);
        hBox.getChildren().add(vBoxSmartphone);
        hBox.getChildren().add(vBoxLaptop);
        hBox.getChildren().add(vBoxTablet);
        this.setCenter(hBox);
    }

    public Devices() {
        this.buildDevicesUI();
        setTables();
    }
    
    
    
}
