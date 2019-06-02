module INTERFACE {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;
    requires postgresql;
    requires j.text.utils;
    requires commons.lang;
    requires java.desktop;
    opens sample;
}
