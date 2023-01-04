module com.example.bakeryinformationsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires xstream;

    opens com.example.bakeryinformationsystem to javafx.fxml;
    exports com.example.bakeryinformationsystem;
    exports com.example.bakeryinformationsystem.Controllers;
    opens com.example.bakeryinformationsystem.Controllers to javafx.fxml;
}