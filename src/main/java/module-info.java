module org.ezone.pae.registroproductos {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.ezone.pae.registroproductos to javafx.fxml;
    opens org.ezone.pae.registroproductos.controller to javafx.fxml;

    // Necesario para PropertyValueFactory
    opens org.ezone.pae.registroproductos.model to javafx.base;

    exports org.ezone.pae.registroproductos;
    exports org.ezone.pae.registroproductos.controller;
    exports org.ezone.pae.registroproductos.model;
}