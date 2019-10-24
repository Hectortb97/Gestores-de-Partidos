package es.hector.views;


import es.hector.logica.Logica;
import es.hector.models.Partido;
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

    @FXML
    private MenuItem menuAltaP;

    @FXML
    private TableView<Partido> tableViewPersonas;

    @FXML
    void altaNuevaPersona(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DialogoPersona.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(new Scene(root, 300, 275));
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewPersonas.setItems(Logica.getInstance().getListaPartidos());
    }
}

