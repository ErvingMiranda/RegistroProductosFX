package org.ezone.pae.registroproductos.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.ezone.pae.registroproductos.model.Producto;
import org.ezone.pae.registroproductos.repository.ProductoRepository;

import java.io.File;
import java.time.LocalDate;

public class ProductoController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtPrecio;

    @FXML
    private DatePicker dtpFechaRegistro;

    @FXML
    private ImageView imgProducto;

    @FXML
    private TableView<Producto> tblProductos;

    @FXML
    private TableColumn<Producto, Integer> colId;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, String> colCategoria;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, LocalDate> colFechaRegistro;

    private final ObservableList<Producto> productos = FXCollections.observableArrayList();
    private final ProductoRepository productoRepository = new ProductoRepository();
    private String selectedImagePath;

    @FXML
    private void initialize() {
        configureTable();
        configureDatePicker();
        loadInitialData();
    }

    private void configureTable() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colFechaRegistro.setCellValueFactory(new PropertyValueFactory<>("fechaRegistro"));

        tblProductos.setItems(productos);
    }

    private void configureDatePicker() {
        dtpFechaRegistro.setValue(LocalDate.now());
    }

    private void loadInitialData() {
        productos.clear();
        productos.setAll(productoRepository.findAll());
    }

    private void configureTableSelection() {
        tblProductos.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        loadProductoIntoForm(newValue);
                    }
                });
    }

    private void loadProductoIntoForm(Producto producto) {
    txtNombre.setText(producto.getNombre());
    txtCategoria.setText(producto.getCategoria());
    txtPrecio.setText(String.valueOf(producto.getPrecio()));
    selectedImagePath = producto.getImagePath();
    // Agregar el método de showImage
    }

    private boolean validateForm() {
        String nombre = txtNombre.getText().trim();
        String categoria = txtCategoria.getText().trim();
        String precio = txtPrecio.getText().trim();

        if (nombre.isEmpty() || categoria.isEmpty() || precio.isEmpty()) {
            showAlert(
                    Alert.AlertType.WARNING,
                    "Datos incompletos",
                    "Completa todos los campos para continuar"
            );
            return false;
        }

        return true;
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void agregarProducto() {
        if (!validateForm()){
            return;
        }

        Producto producto = new Producto(
                1,
                txtNombre.getText().trim(),
                txtCategoria.getText().trim(),
                Double.parseDouble(txtPrecio.getText()),
                dtpFechaRegistro.getValue(),
                selectedImagePath
        );

        productos.add(producto);
        showAlert(
                Alert.AlertType.INFORMATION,
                "Productos creados",
                "Creado con éxito"
        );
    }

    @FXML
    private void selectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccione la imagen del producto");

        fileChooser.getExtensionFilters().add(new
                FileChooser.ExtensionFilter("Imagenes", "*.jpg", "*.png", "*.jpeg"));

        File selectedFile = fileChooser.showOpenDialog(imgProducto.getScene().getWindow());
        if (selectedFile != null) {
            selectedImagePath = selectedFile.getAbsolutePath();
            showImage(selectedImagePath);
        }
    }

    private void showImage(String selectedImagePath) {
        if (selectedImagePath == null) {
            imgProducto.setImage(null);
            return;
        }
        Image image = new Image(selectedImagePath,
                180, 150, true, true);
        imgProducto.setImage(image);
    }

    public void actualizarProducto(ActionEvent actionEvent) {
    }

    public void limpiarControles(ActionEvent actionEvent) {
        txtNombre.clear();
        txtCategoria.clear();
        txtPrecio.clear();
        dtpFechaRegistro.setValue(LocalDate.now());
        selectedImagePath = null;
        imgProducto.setImage(null);
        tblProductos.getSelectionModel().clearSelection();
        txtNombre.requestFocus();
    }

    public void guardarImagen(ActionEvent actionEvent) {
    }
}