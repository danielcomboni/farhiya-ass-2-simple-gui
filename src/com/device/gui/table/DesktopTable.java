package com.device.gui.table;

import com.device.model.Desktop;
import com.device.model.Device;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class DesktopTable{

    private static TableView<Desktop> tableView;

    public static TableView<Desktop> getTableView() {
        return DesktopTable.tableView;
    }

    public static void setTableView(TableView<Desktop> tableView) {
        DesktopTable.tableView = tableView;
    }

    public static TableView<Desktop> getTable(){
        if(DesktopTable.getTableView() == null){
            DesktopTable.tableView = new TableView<>();
            DesktopTable.setTableView(DesktopTable.tableView);
        }
        DesktopTable.tableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        DesktopTable.setTableColumns();
        return tableView;
    }

    private static void setTableColumns(){

        tableView.getColumns().clear();

        TableColumn<Desktop, String> columnName = new TableColumn<>("Name");

        columnName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Desktop, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Desktop, String> param) {
                return new SimpleStringProperty(param.getValue().getName());
            }
        });
        DesktopTable.tableView.getColumns().add(columnName);

        TableColumn<Desktop, String> columnType = new TableColumn<>("Type");
        columnType.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Desktop, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Desktop, String> param) {
                return new SimpleStringProperty(param.getValue().getType());
            }
        });
        DesktopTable.tableView.getColumns().add(columnType);

        TableColumn<Desktop, String> columnScreenWidth = new TableColumn<>("Screen width");
        columnScreenWidth.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Desktop, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Desktop, String> param) {
                return new SimpleStringProperty(param.getValue().getScreenWidth());
            }
        });
        DesktopTable.tableView.getColumns().add(columnScreenWidth);
    }

    private static ObservableList<Desktop> allDesktops;

    public static ObservableList<Desktop> getAllDesktops() {
        return allDesktops;
    }

    public static void setAllDesktops(ObservableList<Desktop> allDesktops) {
        DesktopTable.allDesktops = allDesktops;
    }

    private static void populateTable(){
        if(DesktopTable.getAllDesktops() == null || DesktopTable.getAllDesktops().isEmpty()){
            ObservableList<Desktop> desktops = FXCollections.observableArrayList();
            DesktopTable.setAllDesktops(desktops);
            DesktopTable.getTable().getItems().clear();
        }
        else{
            DesktopTable.getTable().getItems().clear();
            DesktopTable.getTable().getItems().addAll(DesktopTable.getAllDesktops());
        }


    }

    public static void AddToTable(Desktop aDesktop){
        if(DesktopTable.getAllDesktops() == null || DesktopTable.getAllDesktops().isEmpty()){
            ObservableList<Desktop> desktops = FXCollections.observableArrayList();
            DesktopTable.setAllDesktops(desktops);
            DesktopTable.getAllDesktops().add(aDesktop);
            populateTable();
        }else{
            DesktopTable.getAllDesktops().add(aDesktop);
            populateTable();
        }

    }

}
