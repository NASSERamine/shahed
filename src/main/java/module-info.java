module org.shahed.Sahed {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.media;

    opens org.shahed.Sahed to javafx.fxml;
    opens Controller to javafx.fxml;
    exports org.shahed.Sahed;
}