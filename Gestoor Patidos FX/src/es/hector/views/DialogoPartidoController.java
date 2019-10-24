package es.hector.views;

import es.hector.logica.Logica;
import es.hector.models.Partido;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DialogoPartidoController {

    @FXML
    private Button altaButton;

    @FXML
    private TextField localTf;

    @FXML
    private TextField visitanteTf;

    @FXML
    private ComboBox divisionCb;

    @FXML
    private TextField resultadoTf;

    @FXML
    private TextField fehaTf;

    @FXML
    void altaPersona(ActionEvent event) {
        Partido partido = new Partido(localTf.getText(),visitanteTf.getText(),divisionCb.);
        Logica.getInstance().addPartido(partido);
        //Como obtener un Stage desde un evento
        Stage stage = ((Stage)((Node)event.getSource()).getScene().getWindow());// ActionEvent nos trae lo que genera
        stage.close();
    }

}
