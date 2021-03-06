/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.horario;

import Datos.BDA;
import Datos.HorariosBDA;
import Modelo.Horario;
import Modelo.Incidencias;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import jfxtras.scene.control.CalendarTimeTextField;
import jfxtras.scene.control.LocalDateTextField;
import jfxtras.scene.control.LocalDateTimeTextField;
import jfxtras.scene.control.LocalTimeTextField;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class HorarioController implements Initializable {
    int idHorario;
    String fechaInicio;
    String fechaFin;
    String horaInicio;
    String horaFin;
    String fecha;
    Horario horario;
    BDA bdd;
    Alert a;
    HorariosBDA hBDA= new HorariosBDA();
    boolean entro;
    List<Horario> lista;
    private ObservableList<Horario> listaHorarios;

    @FXML
    private TableColumn<Horario, String> table_horaEntrada1;
    @FXML
    private TableColumn<Horario, String> table_HoraSalida1;
    @FXML
    private TableColumn<Horario, String> table_fechaInicio1;
    @FXML
    private TableColumn<Horario, String> table_fechaSalida1;
    @FXML
    private Button bt_cambiar;
    @FXML
    private TableView<Horario> tableView;
    @FXML
    private TableColumn<Horario, Integer> table_idHorario;
    @FXML
    private Button bt_guardar;
    @FXML
    private Button bt_guardarCambios;
    @FXML
    private Tab tab_nuevoCambiar;
    @FXML
    private TextField text_idHorario;
    @FXML
    private LocalDateTimeTextField ejemplo;
    @FXML
    private LocalDateTimeTextField ejemplo2;
    @FXML
    private Tab tab_infor;
    @FXML
    private TabPane tabPanel;
    @FXML
    private Button bt_eliminar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        entro = true;
        try {
            bdd = new BDA();
            lista = hBDA.listarHorarios();
            listaHorarios = FXCollections.observableArrayList(lista);

            tableView.setItems(listaHorarios);
            table_idHorario.setCellValueFactory(new PropertyValueFactory<>("idHorarios"));
            table_horaEntrada1.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));
            table_HoraSalida1.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
            table_fechaInicio1.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
            table_fechaSalida1.setCellValueFactory(new PropertyValueFactory<>("fechaSalida"));

            bt_guardarCambios.setVisible(true);

        } catch (SQLException ex) {

            Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void guardar(ActionEvent event) {

//        idHorario = Integer.valueOf(text_idHorario.getText());

        fecha = ejemplo.getLocalDateTime().toString();
        fecha = fecha + "T" + ejemplo2.getLocalDateTime().toString();

        String[] split2 = fecha.split("T");

        for (int i = 0; i < split2.length; i++) {

            if (i == 0) {
                fechaInicio = split2[i];
            }
            if (1 == i) {
                horaInicio = split2[i];
            }
            if (2 == i) {
                fechaFin = split2[i];
            }
            if (3 == i) {
                horaFin = split2[i];
            }

        }

        try {

            if (hBDA.insertarHorario( horaInicio, horaFin, fechaInicio, fechaFin) != 0) {
                a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Informacion");
                a.setHeaderText("Incidencia Insertada");
                a.show();
            }
        } catch (SQLException ex) {
            a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Datos introducidos erroneos");
            a.show();
        }

    }

    @FXML
    private void guardarCambios(ActionEvent event) throws SQLException {
        idHorario = Integer.valueOf(text_idHorario.getText());

        fecha = ejemplo.getLocalDateTime().toString();
        fecha = fecha + "T" + ejemplo2.getLocalDateTime().toString();

        String[] split2 = fecha.split("T");

        for (int i = 0; i < split2.length; i++) {

            if (i == 0) {
                fechaInicio = split2[i];
            }
            if (1 == i) {
                horaInicio = split2[i];
            }
            if (2 == i) {
                fechaFin = split2[i];
            }
            if (3 == i) {
                horaFin = split2[i];
            }

        }

        if (hBDA.consultarIDhorario(idHorario) == true) {

            if (hBDA.cambiarHorario(idHorario, horaInicio, horaFin, fechaInicio, fechaFin) != 0) {
                a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Informacion");
                a.setHeaderText("Horario modificada");
                a.show();
            }

        } else {
            a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Codigo Horario no encontrado");
            a.show();
        }

    }

    @FXML
    private void cambiarHorario(ActionEvent event) {
        tab_nuevoCambiar.getGraphic();
        SingleSelectionModel<Tab> selectionModel = tabPanel.getSelectionModel();
        selectionModel.select(tab_nuevoCambiar);

        horario = tableView.getSelectionModel().getSelectedItem();

        String id = String.valueOf(horario.getIdHorarios());
        if (id == null) {
            bt_guardarCambios.setVisible(false);
        }
        text_idHorario.setText(id);
        bt_guardar.setVisible(false);
        bt_guardarCambios.setVisible(true);

    }

    @FXML
    private void cambiosTab(Event event) {
        if (tab_nuevoCambiar.isSelected()) {

            bt_guardar.setVisible(true);
            bt_guardarCambios.setVisible(false);
            text_idHorario.clear();
            ejemplo.setText("");
            ejemplo2.setText("");
            
            
        }

        bt_guardar.setVisible(true);
        bt_guardarCambios.setVisible(false);
    }

    @FXML
    private void clicarInformacionHorario(Event event) throws SQLException {
        if (entro == true) {

            if (tab_infor.isSelected()) {
                listaHorarios.clear();
                lista = hBDA.listarHorarios();
                listaHorarios.addAll(lista);
            }
        }
    }

    @FXML
    private void eliminar(ActionEvent event) {
        horario = tableView.getSelectionModel().getSelectedItem();

        try {
            if (hBDA.consultarIDhorario(horario.getIdHorarios()) == true) {

                if (hBDA.borrarHorario(horario.getIdHorarios()) != 0) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Informacion");
                    a.setHeaderText("Horario borrada");
                    a.show();
                    listaHorarios.clear();
                    lista = hBDA.listarHorarios();
                    listaHorarios.addAll(lista);

                }

            } else {
                a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Id Horario no encontrada");
                a.show();
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
