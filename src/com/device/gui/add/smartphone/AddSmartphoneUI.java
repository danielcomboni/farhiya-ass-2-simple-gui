package com.device.gui.add.smartphone;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddSmartphoneUI extends Stage {

    private BorderPane borderPane;
    private Scene scene;

    public AddSmartphoneUI() {

    }

    public AddSmartphoneUI(String stageTitle ) {

        this.initModality( Modality.APPLICATION_MODAL );

        this.setTitle( stageTitle );

        this.setResizable( true );

        this.borderPane = new BorderPane();
        this.borderPane.setId( "add-device" );
        this.borderPane.setCenter( new AddSmartphonePopup(this) );

        scene = new Scene( borderPane );

        scene.getStylesheets().add( getClass().getResource( "add-smartphone.css" ).toExternalForm() );

        this.setScene( scene );

    }

}
