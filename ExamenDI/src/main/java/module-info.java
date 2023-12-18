module com.example.examendi {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;


    opens com.example.examendi to javafx.fxml;
    exports com.example.examendi;
}