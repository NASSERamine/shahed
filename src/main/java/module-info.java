module org.shahed.Sahed {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires java.desktop;

    opens org.shahed.Sahed to javafx.fxml;
    opens Controller to javafx.fxml;
    exports org.shahed.Sahed;
}