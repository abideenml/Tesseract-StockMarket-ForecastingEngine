module com.project.projectcrypto {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.project.projectcrypto to javafx.fxml;
    exports com.project.projectcrypto;
}