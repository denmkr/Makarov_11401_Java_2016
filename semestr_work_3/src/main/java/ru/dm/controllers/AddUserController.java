package ru.dm.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.dm.MainApplication;
import ru.dm.entity.ProductGroup;
import ru.dm.entity.UserRole;

/**
 * Created by Denis on 28.05.2016.
 */
public class AddUserController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;

    @FXML
    private ChoiceBox<String> roles;

    private MainApplication mainApp;
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;

        ObservableList<String> rolesList = FXCollections.observableArrayList();
        rolesList.add("Обычный пользователь");
        rolesList.add("Партнер");
        rolesList.add("Администратор");

        roles.setItems(rolesList);
        roles.setValue(rolesList.get(0));
    }

    private void showOk() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("Пользователь удален");
        alert.setContentText("Пользователь удален");
        alert.showAndWait();
    }

    @FXML
    private void handleAddUser() {

        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8080/api/users/add";

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", mainApp.getUser().getHeader());

            MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
            params.add("name", nameField.getText());
            params.add("email", emailField.getText());
            params.add("password", passwordField.getText());

            params.add("role", roles.getValue());

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);

            Boolean added = restTemplate.postForEntity(url, request, Boolean.class).getBody();

            if (added) {
                mainApp.showAddUser();
                showOk();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Ошибка сервера");
                alert.setContentText("Ошибка сервера");
                alert.showAndWait();
            }

        } catch (ResourceAccessException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Нет соединения с сервером");
            alert.setContentText("Нет соединения с сервером");
            alert.showAndWait();
            mainApp.showLogin();
        }
    }

}
