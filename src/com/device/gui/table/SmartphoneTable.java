package com.device.gui.table;

import com.device.model.Smartphone;
import com.device.model.Device;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class SmartphoneTable{

    private static TableView<Smartphone> tableView;

    public static TableView<Smartphone> getTableView() {
        return SmartphoneTable.tableView;
    }

    public static void setTableView(TableView<Smartphone> tableView) {
        SmartphoneTable.tableView = tableView;
    }

    public static TableView<Smartphone> getTable(){
        if(SmartphoneTable.getTableView() == null){
            SmartphoneTable.tableView = new TableView<>();
            SmartphoneTable.setTableView(SmartphoneTable.tableView);
        }
        SmartphoneTable.tableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        SmartphoneTable.setTableColumns();
        return tableView;
    }

    private static void setTableColumns(){

        tableView.getColumns().clear();

        TableColumn<Smartphone, String> columnName = new TableColumn<>("Name");

        columnName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Smartphone, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Smartphone, String> param) {
                return new SimpleStringProperty(param.getValue().getName());
            }
        });
        SmartphoneTable.tableView.getColumns().add(columnName);

        TableColumn<Smartphone, String> columnType = new TableColumn<>("Type");
        columnType.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Smartphone, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Smartphone, String> param) {
                return new SimpleStringProperty(param.getValue().getType());
            }
        });
        SmartphoneTable.tableView.getColumns().add(columnType);

        TableColumn<Smartphone, String> columnScreenWidth = new TableColumn<>("Camera Strength");
        columnScreenWidth.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Smartphone, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Smartphone, String> param) {
                return new SimpleStringProperty(String.valueOf(param.getValue().getCameraStrength()));
            }
        });
        SmartphoneTable.tableView.getColumns().add(columnScreenWidth);
    }

    private static ObservableList<Smartphone> allSmartphones;

    public static ObservableList<Smartphone> getAllSmartphones() {
        return allSmartphones;
    }

    public static void setAllSmartphones(ObservableList<Smartphone> allSmartphones) {
        SmartphoneTable.allSmartphones = allSmartphones;
    }

    private static void populateTable(){
        if(SmartphoneTable.getAllSmartphones() == null || SmartphoneTable.getAllSmartphones().isEmpty()){
            ObservableList<Smartphone> desktops = FXCollections.observableArrayList();
            SmartphoneTable.setAllSmartphones(desktops);
            SmartphoneTable.getTable().getItems().clear();
        }
        else{
            SmartphoneTable.getTable().getItems().clear();
            SmartphoneTable.getTable().getItems().addAll(SmartphoneTable.getAllSmartphones());
        }


    }

    public static void AddToTable(Smartphone aSmartphone){
        if(SmartphoneTable.getAllSmartphones() == null || SmartphoneTable.getAllSmartphones().isEmpty()){
            ObservableList<Smartphone> desktops = FXCollections.observableArrayList();
            SmartphoneTable.setAllSmartphones(desktops);
            SmartphoneTable.getAllSmartphones().add(aSmartphone);
            populateTable();
        }else{
            SmartphoneTable.getAllSmartphones().add(aSmartphone);
            populateTable();
        }

    }

}
