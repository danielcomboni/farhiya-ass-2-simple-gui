package com.device.gui.add.tablet;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddTabletUI extends Stage {

    private BorderPane borderPane;
    private Scene scene;

    public AddTabletUI() {

    }

    public AddTabletUI(String stageTitle ) {

        this.initModality( Modality.APPLICATION_MODAL );

        this.setTitle( stageTitle );

        this.setResizable( true );

        this.borderPane = new BorderPane();
        this.borderPane.setId( "add-device" );
        this.borderPane.setCenter( new AddTabletPopup(this) );

        scene = new Scene( borderPane );

        scene.getStylesheets().add( getClass().getResource( "addDevice.css" ).toExternalForm() );

        this.setScene( scene );

    }

}
