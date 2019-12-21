package com.device.gui.table;

import com.device.model.Laptop;
import com.device.model.Device;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class LaptopTable{

    private static TableView<Laptop> tableView;

    public static TableView<Laptop> getTableView() {
        return LaptopTable.tableView;
    }

    public static void setTableView(TableView<Laptop> tableView) {
        LaptopTable.tableView = tableView;
    }

    public static TableView<Laptop> getTable(){
        if(LaptopTable.getTableView() == null){
            LaptopTable.tableView = new TableView<>();
            LaptopTable.setTableView(LaptopTable.tableView);
        }
        LaptopTable.tableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        LaptopTable.setTableColumns();
        return tableView;
    }

    private static void setTableColumns(){

        tableView.getColumns().clear();

        TableColumn<Laptop, String> columnName = new TableColumn<>("Name");

        columnName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Laptop, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Laptop, String> param) {
                return new SimpleStringProperty(param.getValue().getName());
            }
        });
        LaptopTable.tableView.getColumns().add(columnName);

        TableColumn<Laptop, String> columnType = new TableColumn<>("Type");
        columnType.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Laptop, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Laptop, String> param) {
                return new SimpleStringProperty(param.getValue().getType());
            }
        });
        LaptopTable.tableView.getColumns().add(columnType);

        TableColumn<Laptop, String> columnScreenWidth = new TableColumn<>("Core");
        columnScreenWidth.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Laptop, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Laptop, String> param) {
                return new SimpleStringProperty(String.valueOf(param.getValue().getCore()));
            }
        });
        LaptopTable.tableView.getColumns().add(columnScreenWidth);
    }

    private static ObservableList<Laptop> allLaptops;

    public static ObservableList<Laptop> getAllLaptops() {
        return allLaptops;
    }

    public static void setAllLaptops(ObservableList<Laptop> allLaptops) {
        LaptopTable.allLaptops = allLaptops;
    }

    private static void populateTable(){
        if(LaptopTable.getAllLaptops() == null || LaptopTable.getAllLaptops().isEmpty()){
            ObservableList<Laptop> desktops = FXCollections.observableArrayList();
            LaptopTable.setAllLaptops(desktops);
            LaptopTable.getTable().getItems().clear();
        }
        else{
            LaptopTable.getTable().getItems().clear();
            LaptopTable.getTable().getItems().addAll(LaptopTable.getAllLaptops());
        }


    }

    public static void AddToTable(Laptop aLaptop){
        if(LaptopTable.getAllLaptops() == null || LaptopTable.getAllLaptops().isEmpty()){
            ObservableList<Laptop> desktops = FXCollections.observableArrayList();
            LaptopTable.setAllLaptops(desktops);
            LaptopTable.getAllLaptops().add(aLaptop);
            populateTable();
        }else{
            LaptopTable.getAllLaptops().add(aLaptop);
            populateTable();
        }

    }

}
