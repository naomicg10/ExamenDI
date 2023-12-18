package com.example.examendi;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.ResourceBundle;

public class ParkingCesur implements Initializable {
    @javafx.fxml.FXML
    private TextField txtMatricula;
    @javafx.fxml.FXML
    private ChoiceBox<Cliente> choiceCliente;
    @javafx.fxml.FXML
    private ComboBox<String> comboModelo;
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
    private Label labelInfo;
    @FXML
    private ToggleGroup tarifa;


    @FXML
    public void añadir(ActionEvent actionEvent) {
        if(!txtMatricula.getText().isEmpty() && comboModelo.getValue() != null && choiceCliente.getValue() != null
        && dateEntrada.getValue() != null && dateSalida.getValue() != null && (radioStandard.isSelected()
        || radioOferta.isSelected() || radioLargaDuracion.isSelected())){
            LocalDate fechaSeleccionada = dateEntrada.getValue();
            LocalDate fechaSeleccionada2 = dateSalida.getValue();
            Period periodo = Period.between(fechaSeleccionada, fechaSeleccionada2);
            Integer dias = periodo.getDays();
            double precio = 0;
            String tarifaSeleccionada = "";
            if (radioStandard.isSelected()) {
                precio = 8;
                tarifaSeleccionada = "Standard";
            } else if (radioOferta.isSelected()) {
                precio = 6;
                tarifaSeleccionada = "Oferta";
            } else if (radioLargaDuracion.isSelected()) {
                precio = 2;
                tarifaSeleccionada = "Larga Duración";
            }
            double coste = dias * precio;

            Parking parking = new Parking();
            parking.setMatricula(txtMatricula.getText());
            parking.setModelo(comboModelo.getSelectionModel().getSelectedItem());
            parking.setCliente(choiceCliente.getSelectionModel().getSelectedItem());
            parking.setTarifa(tarifaSeleccionada);
            parking.setCoste((int) coste);
            parking.setEntrada(fechaSeleccionada);
            parking.setSalida(fechaSeleccionada2);
            tabla.getItems().add(parking);

            labelCoste.setText(coste +" €");

            limpiar();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("¡ERROR!");
            alert.setContentText("Campos incompletos");
            alert.showAndWait();
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

        comboModelo.getItems().addAll("Bmw", "Audi", "Cupra");

        Cliente cliente1 = new Cliente(1, "Naomi", "naomicg4@gmail.com");
        Cliente cliente2 = new Cliente(2, "Carlos", "carlos@gmail.com");
        Cliente cliente3 = new Cliente(3, "Jose", "jose@gmail.com");
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
        choiceCliente.getItems().addAll(cliente1, cliente2, cliente3);
    }

    private void limpiar() {
        txtMatricula.clear();
        comboModelo.setValue(null);
        choiceCliente.setValue(null);
        dateEntrada.setValue(null);
        dateSalida.setValue(null);
        radioStandard.setSelected(false);
        radioOferta.setSelected(false);
        radioLargaDuracion.setSelected(false);
    }

    @javafx.fxml.FXML
    public void info(Event event) {
        Alert alerta=new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setHeaderText("Naomi Camuña González 2ºDAM");
        alerta.showAndWait();
    }
}
