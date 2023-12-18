package com.example.examendi;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class ParkingCesur implements Initializable {
    @javafx.fxml.FXML
    private TextField txtMatricula;
    @javafx.fxml.FXML
    private ChoiceBox<String> choiceModelo;
    @javafx.fxml.FXML
    private ChoiceBox<Cliente> choiceCliente;
    @javafx.fxml.FXML
    private RadioButton radioStandard;
    @javafx.fxml.FXML
    private RadioButton radioOferta;
    @javafx.fxml.FXML
    private RadioButton radioLargaDuracion;
    @javafx.fxml.FXML
    private DatePicker dateEntrada;
    @javafx.fxml.FXML
    private DatePicker dateSalida;
    @javafx.fxml.FXML
    private Label labelCoste;
    @javafx.fxml.FXML
    private Button btnAñadir;
    @javafx.fxml.FXML
    private Button btnSalir;
    @javafx.fxml.FXML
    private TableColumn<Parking, String> cMatricula;
    @javafx.fxml.FXML
    private TableColumn<Parking, String> cModelo;
    @javafx.fxml.FXML
    private TableColumn<Parking, String> cEntrada;
    @javafx.fxml.FXML
    private TableColumn<Parking, String> cSalida;
    @javafx.fxml.FXML
    private TableColumn<Parking, String> cCliente;
    @javafx.fxml.FXML
    private TableColumn<Parking, String> cTarifa;
    @javafx.fxml.FXML
    private TableColumn<Parking, String> cCoste;
    @javafx.fxml.FXML
    private TableView tabla;


    @javafx.fxml.FXML
    public void añadir(ActionEvent actionEvent) {
        LocalDate fechaSeleccionada = dateEntrada.getValue();
        Date fechaParseada = java.sql.Date.valueOf(fechaSeleccionada);
        LocalDate fechaSeleccionada2 = dateSalida.getValue();
        Date fechaParseada2 = java.sql.Date.valueOf(fechaSeleccionada2);
        if(!txtMatricula.getText().isEmpty()){
            Parking parking = new Parking();
            parking.setMatricula(txtMatricula.getText());
            parking.setModelo(choiceModelo.getSelectionModel().getSelectedItem());
            parking.setCliente(choiceCliente.getSelectionModel().getSelectedItem());
            if (radioStandard.isSelected()) {
                parking.setTarifa(radioStandard.getText());
            } else if (radioOferta.isSelected()) {
                parking.setTarifa(radioOferta.getText());
            } else if (radioLargaDuracion.isSelected()) {
                parking.setTarifa(radioLargaDuracion.getText());
            }
            parking.setEntrada(fechaParseada);
            parking.setSalida(fechaParseada2);
            tabla.getItems().add(parking);
        }
    }

    @javafx.fxml.FXML
    public void salir(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cMatricula.setCellValueFactory( (fila) -> {
            String matricula = fila.getValue().getMatricula();
            return new SimpleStringProperty( matricula );
        });
        cModelo.setCellValueFactory( (fila) -> {
            String modelo = fila.getValue().getModelo();
            return new SimpleStringProperty( modelo );
        });
        cEntrada.setCellValueFactory( (fila) -> {
            String entrada = String.valueOf(fila.getValue().getEntrada());
            return new SimpleStringProperty( entrada );
        });
        cSalida.setCellValueFactory( (fila) -> {
            String salida = String.valueOf(fila.getValue().getSalida());
            return new SimpleStringProperty( salida );
        });
        cCliente.setCellValueFactory( (fila) -> {
            String cliente = fila.getValue().getCliente().getNombre();
            return new SimpleStringProperty( cliente );
        });
        cTarifa.setCellValueFactory( (fila) -> {
            String tarifa = fila.getValue().getTarifa();
            return new SimpleStringProperty( tarifa );
        });
        cCoste.setCellValueFactory( (fila) -> {
            String coste = String.valueOf(fila.getValue().getCoste());
            return new SimpleStringProperty( coste );
        });

        Cliente cliente1 = new Cliente(1, "Naomi", "naomicg4@gmail.com");
        Cliente cliente2 = new Cliente(2, "Carlos", "carlos@gmail.com");
        Cliente cliente3 = new Cliente(3, "Jose", "jose@gmail.com");

        choiceModelo.getItems().addAll("Bmw", "Audi", "Cupra");
        choiceCliente.getItems().addAll(cliente1, cliente2, cliente3);

        choiceCliente.setConverter(new StringConverter<Cliente>() {
            @Override
            public String toString(Cliente cliente) {
                if (cliente != null) return cliente.getNombre();
                else return null;
            }

            @Override
            public Cliente fromString(String s) {
                return null;
            }
        });
        ToggleGroup tarifaToggleGroup = new ToggleGroup();

        RadioButton radioStandard = new RadioButton("Tarifa Estándar");
        radioStandard.setToggleGroup(tarifaToggleGroup);

        RadioButton radioOferta = new RadioButton("Tarifa de Oferta");
        radioOferta.setToggleGroup(tarifaToggleGroup);

        RadioButton radioLargaDuracion = new RadioButton("Tarifa Larga Duración");
        radioLargaDuracion.setToggleGroup(tarifaToggleGroup);


    }
}
