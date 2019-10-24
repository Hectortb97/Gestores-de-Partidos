module Gestoor.Patidos.FX {
    requires javafx.base;
    requires javafx.controls;
    requires java.desktop;
    requires javafx.fxml;

    exports es.hector;
    exports es.hector.logica;
    exports es.hector.models;
    exports es.hector.views;

    opens es.hector.views to javafx.fxml;

}