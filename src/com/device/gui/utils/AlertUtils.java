package com.device.gui.utils;

import javafx.scene.control.Alert;

public class AlertUtils {

    public static void alertWarning(String header){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(header);
        alert.setTitle(header);
        alert.showAndWait();
    }

}
