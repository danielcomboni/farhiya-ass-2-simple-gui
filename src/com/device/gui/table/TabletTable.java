package com.device.gui.table;

import com.device.model.Tablet;
import com.device.model.Device;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class TabletTable{

    private static TableView<Tablet> tableView;

    public static TableView<Tablet> getTableView() {
        return TabletTable.tableView;
    }

    public static void setTableView(TableView<Tablet> tableView) {
        TabletTable.tableView = tableView;
    }

    public static TableView<Tablet> getTable(){
        if(TabletTable.getTableView() == null){
            TabletTable.tableView = new TableView<>();
            TabletTable.setTableView(TabletTable.tableView);
        }
        TabletTable.tableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        TabletTable.setTableColumns();
        return tableView;
    }

    private static void setTableColumns(){

        tableView.getColumns().clear();

        TableColumn<Tablet, String> columnName = new TableColumn<>("Name");

        columnName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Tablet, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Tablet, String> param) {
                return new SimpleStringProperty(param.getValue().getName());
            }
        });
        TabletTable.tableView.getColumns().add(columnName);

        TableColumn<Tablet, String> columnType = new TableColumn<>("Type");
        columnType.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Tablet, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Tablet, String> param) {
                return new SimpleStringProperty(param.getValue().getType());
            }
        });
        TabletTable.tableView.getColumns().add(columnType);

        TableColumn<Tablet, String> columnScreenWidth = new TableColumn<>("Camera Strength");
        columnScreenWidth.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Tablet, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Tablet, String> param) {
                return new SimpleStringProperty(String.valueOf(param.getValue().getCameraStrength()));
            }
        });
        TabletTable.tableView.getColumns().add(columnScreenWidth);
    }

    private static ObservableList<Tablet> allTablets;

    public static ObservableList<Tablet> getAllTablets() {
        return allTablets;
    }

    public static void setAllTablets(ObservableList<Tablet> allTablets) {
        TabletTable.allTablets = allTablets;
    }

    private static void populateTable(){
        if(TabletTable.getAllTablets() == null || TabletTable.getAllTablets().isEmpty()){
            ObservableList<Tablet> desktops = FXCollections.observableArrayList();
            TabletTable.setAllTablets(desktops);
            TabletTable.getTable().getItems().clear();
        }
        else{
            TabletTable.getTable().getItems().clear();
            TabletTable.getTable().getItems().addAll(TabletTable.getAllTablets());
        }


    }

    public static void AddToTable(Tablet aTablet){
        if(TabletTable.getAllTablets() == null || TabletTable.getAllTablets().isEmpty()){
            ObservableList<Tablet> desktops = FXCollections.observableArrayList();
            TabletTable.setAllTablets(desktops);
            TabletTable.getAllTablets().add(aTablet);
            populateTable();
        }else{
            TabletTable.getAllTablets().add(aTablet);
            populateTable();
        }

    }

}
