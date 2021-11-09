module com.example.adrianomelquiades_comp228lab04 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.adrianomelquiades_comp228lab04 to javafx.fxml;
    exports com.example.adrianomelquiades_comp228lab04;
}