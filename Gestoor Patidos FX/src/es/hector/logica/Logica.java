package es.hector.logica;

import es.hector.models.Partido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Logica {

    private static Logica INSTANCE = null;

    private ObservableList<Partido> listaPartidos;

    private Logica() {
        listaPartidos = FXCollections.observableArrayList();
        listaPartidos.add(new Partido("Madrid", "Barsa", "Primera", 1, 4, "09-11-2030"));
        listaPartidos.add(new Partido("Sporting", "Oviedo", "Segunda", 3, 0, "11-06-1997"));
        listaPartidos.add(new Partido("LaCaridad", "Viavelez", "Tercera", 2, 5, "09-11-2030"));
        listaPartidos.add(new Partido("Prueba", "Prueba", "Primera", 1, 1, "11-11-1111"));
    }

    public static Logica getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Logica();

        return INSTANCE;
    }

    public void addPartido(Partido partido) {
        listaPartidos.add(partido);
    }


    public ObservableList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public void borrarPartido(int indiceBorrar) {
        listaPartidos.remove(indiceBorrar);
    }

    public void modificarPartido(Partido partidoM, int posicion) {
        listaPartidos.set(posicion, partidoM);
    }


}
