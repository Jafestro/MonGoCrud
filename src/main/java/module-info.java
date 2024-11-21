module org.example.mongocrud {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.mongocrud to javafx.fxml;
    exports org.example.mongocrud;
}