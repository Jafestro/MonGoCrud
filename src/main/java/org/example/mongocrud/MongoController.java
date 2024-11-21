package org.example.mongocrud;

import com.mongodb.client.MongoCursor;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.bson.Document;

public class MongoController {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField cityField;

    @FXML
    private void onAdd() {
        String id = idField.getText();
        String name = nameField.getText();
        String age = ageField.getText();
        String city = cityField.getText();

        try {
            MongoDbUtil.createPerson(id, name, age, city);
            showAlert("Success", "Person added successfully!");
            clearFields();
        } catch (Exception e) {
            showAlert("Error", "Failed to add person: " + e.getMessage());
        }
    }

    @FXML
    private void onRead() {
        String id = idField.getText();

        try {
            Document person = MongoDbUtil.readPerson(id);
            if (person != null) {
                nameField.setText(person.getString("name"));
                ageField.setText(person.getString("age"));
                cityField.setText(person.getString("city"));
            } else {
                showAlert("Error", "No person found with ID: " + id);
            }
        } catch (Exception e) {
            showAlert("Error", "Failed to read person: " + e.getMessage());
        }
    }

    @FXML
    private void onUpdate() {
        String id = idField.getText();
        String name = nameField.getText();
        String age = ageField.getText();
        String city = cityField.getText();

        try {
            MongoDbUtil.updatePerson(id, name, age, city);
            showAlert("Success", "Person updated successfully!");
            clearFields();
        } catch (Exception e) {
            showAlert("Error", "Failed to update person: " + e.getMessage());
        }
    }

    @FXML
    private void onDelete() {
        String id = idField.getText();

        try {
            MongoDbUtil.deletePerson(id);
            showAlert("Success", "Person deleted successfully!");
            clearFields();
        } catch (Exception e) {
            showAlert("Error", "Failed to delete person: " + e.getMessage());
        }
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        ageField.clear();
        cityField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}