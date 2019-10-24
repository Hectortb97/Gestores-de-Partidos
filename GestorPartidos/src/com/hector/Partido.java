package com.hector;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Partido implements Serializable ,Comparable<Partido>{

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String eLocal;
    private String eVisitante;
    private String division;
    private int resultado; //cambiar
    private Date fecha;

    public Partido(String eLocal, String eVisitante, String division, int resultado, Date fecha) {//cambiar res
        this.eLocal = eLocal;
        this.eVisitante = eVisitante;
        this.division = division;
        this.resultado = resultado;
        this.fecha = fecha;
    }

    public String geteLocal() {
        return eLocal;
    }

    public void seteLocal(String eLocal) {
        this.eLocal = eLocal;
    }

    public String geteVisitante() {
        return eVisitante;
    }

    public void seteVisitante(String eVisitante) {
        this.eVisitante = eVisitante;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public int getResultado() {
        return resultado;
    }//cambiar

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }//cambiar

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "Equipo Local='" + eLocal + '\'' +
                ", Equipo Visitante='" + eVisitante + '\'' +
                ", Division='" + division + '\'' +
                ", Resultado=" + resultado +
                ", Fecha='" + sdf.format(fecha) + '\'' +
                '}';
    }

    @Override
    public int compareTo(Partido o) {
        return getFecha().compareTo(o.getFecha());
    }
}