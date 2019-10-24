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

import java.text.SimpleDateFormat;

public class DialogoPartidoController {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private Partido partidoModificar;

    @FXML
    private Button altaButton;

    @FXML
    private TextField localTf;

    @FXML
    private TextField visitanteTf;

    @FXML
    private ComboBox<String> divisionCb;

    @FXML
    private TextField golesLocalTf;

    @FXML
    private TextField golesVisitanteTf;

    @FXML
    private TextField fechaTf;

    @FXML
    void altaModificarPartido(ActionEvent event) {
        if (partidoModificar!=null)
        {
            partidoModificar.setLocal(localTf.getText());
            partidoModificar.setVisitante(visitanteTf.getText());
            partidoModificar.setDivision(divisionCb.getSelectionModel().getSelectedItem().toString());
            partidoModificar.setGolesLocal(Integer.parseInt(golesLocalTf.getText()));
            partidoModificar.setGolesVisitante(Integer.parseInt(golesVisitanteTf.getText()));
            partidoModificar.setFecha(sdf.parse(partidoModificar.getFecha()));
            Logica.getInstance().modificarPartido(partidoModificar);
        }
        else {
            Partido partido = new Partido(localTf.getText(),visitanteTf.getText(),divisionCb.getSelectionModel().getSelectedItem().toString(),Integer.parseInt(golesLocalTf.getText()),Integer.parseInt(golesVisitanteTf.getText()),fechaTf.getText());
            Logica.getInstance().addPartido(partido);
        }
        //Como obtener un Stage desde un evento
        Stage stage = ((Stage)((Node)event.getSource()).getScene().getWindow());
        stage.close();
    }

    public void setPartidoModificar(Partido partidoModificar)
    {
        this.partidoModificar = partidoModificar;
        localTf.setText(partidoModificar.getLocal());
        visitanteTf.setText(partidoModificar.getVisitante());
        divisionCb.setSe;
        golesLocalTf.setText(Integer.toString(partidoModificar.getGolesLocal()));
        golesVisitanteTf.setText(Integer.toString(partidoModificar.getGolesVisitante()));
        fechaTf.setText(partidoModificar.getFecha());
    }
}
