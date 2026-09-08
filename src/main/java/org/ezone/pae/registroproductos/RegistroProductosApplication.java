package org.ezone.pae.registroproductos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistroProductosApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                RegistroProductosApplication.class.getResource("registro-productos.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Registro de productos");
        stage.setScene(scene);
        stage.show();
    }
}