package es.hector.filters;

import es.hector.models.Partido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FilterDivisiones
{
    private ObservableList<Partido> listaPartidos;
    private ObservableList<Partido> listaFiltrada;

    public FilterDivisiones(ObservableList<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
        listaFiltrada = FXCollections.observableArrayList();
    }

    public ObservableList<Partido> filtrar(String apellidosFiltrar)
    {
        if (apellidosFiltrar!=null && !"".equals(apellidosFiltrar))
        {
            //Necesitamos filtrar
            listaFiltrada.clear();
            for (Partido persona : listaPartidos)
            {
                if (persona.getApellidos().contains(apellidosFiltrar))
                    listaFiltrada.add(persona);
            }
            return listaFiltrada;
        }
        else
        {
            //Tenemos que mostrar todos los registros
            return listaPartidos;
        }

    }
}
