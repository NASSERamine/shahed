module org.shahed.Sahed {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.shahed.Sahed to javafx.fxml;
    opens Controller to javafx.fxml;
    exports org.shahed.Sahed;
}