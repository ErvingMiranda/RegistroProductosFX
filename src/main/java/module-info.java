module org.ezone.pae.registroproductos {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.ezone.pae.registroproductos to javafx.fxml;
    exports org.ezone.pae.registroproductos;
}