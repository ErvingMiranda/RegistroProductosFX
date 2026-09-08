package org.ezone.pae.registroproductos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.ezone.pae.registroproductos.RegistroProductosApplication;

import java.io.IOException;

public class MenuPrincipalController {

    @FXML
    private void abrirMenuProductos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                RegistroProductosApplication.class.getResource("registro-productos.fxml")
        );

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setTitle("Menú Productos");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void abrirMenuReporte1(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                RegistroProductosApplication.class.getResource("hello-view.fxml")
        );

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setTitle("Reporte de Productos");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void abrirMenuClientes(ActionEvent event) {
    }
}