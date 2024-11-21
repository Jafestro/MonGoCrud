module org.example.mongocrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;

    opens org.example.mongocrud to javafx.fxml;
    exports org.example.mongocrud;
}