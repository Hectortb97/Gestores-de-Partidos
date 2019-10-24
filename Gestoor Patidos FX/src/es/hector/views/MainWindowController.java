package es.hector.views;


import es.hector.filters.FilterDivisiones;
import es.hector.logica.Logica;
import es.hector.models.Partido;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private FilterDivisiones filterDivision;

    @FXML
    private MenuItem menuAltaP;

    @FXML
    private TableView<Partido> tableViewPartidos;

    @FXML
    void modificarPartido(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DialogoPartido.fxml"));
            Parent root = fxmlLoader.load();
            DialogoPartidoController controller = fxmlLoader.getController();
            Partido partido = tableViewPartidos.getSelectionModel().getSelectedItem();
            controller.setPartidoModificar(partido);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root, 300, 275));
            stage.showAndWait();
            filtrar();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void altaNuevoPartido(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DialogoPartido.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root, 300, 275));
            stage.showAndWait();
            filtrar();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewPartidos.setItems(Logica.getInstance().getListaPartidos());
        filterDivision = new FilterDivisiones(Logica.getInstance().getListaPartidos());
        //Nos subscribimos a cambios en la propiedad text del textfield
        filterDivisionCBX.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                tableViewPartidos.setItems(filterDivision.filtrar(newValue));
            }
        });
    }

    private void filtrar()
    {
        tableViewPartidos.setItems(filterDivision.filtrar(filterDivisionCBX.getText()));
    }

}

