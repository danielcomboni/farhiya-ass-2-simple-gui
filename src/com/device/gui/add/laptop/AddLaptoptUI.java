package com.device.gui.add.laptop;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddLaptoptUI extends Stage {

    private BorderPane borderPane;
    private Scene scene;

    public AddLaptoptUI() {

    }

    public AddLaptoptUI(String stageTitle ) {

        this.initModality( Modality.APPLICATION_MODAL );

        this.setTitle( stageTitle );

        this.setResizable( true );

        this.borderPane = new BorderPane();
        this.borderPane.setId( "add-device" );
        this.borderPane.setCenter( new AddLaptopPopup(this) );

        scene = new Scene( borderPane );

        scene.getStylesheets().add( getClass().getResource( "add-laptop.css" ).toExternalForm() );

        this.setScene( scene );

    }

}
