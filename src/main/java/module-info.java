module com.example.transport {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.commons.lang3;


    opens gui to javafx.fxml;
    exports gui;
}