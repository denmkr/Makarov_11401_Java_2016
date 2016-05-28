package ru.dm.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.dm.MainApplication;
import ru.dm.entity.Product;
import ru.dm.entity.ProductGroup;
import ru.dm.entity.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by Denis on 28.05.2016.
 */
public class AddProductController {

    @FXML
    private TextField articuleField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField stockField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField currencyField;

    @FXML
    private ChoiceBox<ProductGroup> groups;

    private MainApplication mainApp;
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;

        groups.setItems(mainApp.getGroups());
        groups.setValue(mainApp.getGroups().get(0));
    }

    private void showOk() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("Товар добавлен");
        alert.setContentText("Товар добавлен");
        alert.showAndWait();
    }

    @FXML
    private void handleAddProduct() {

        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8080/api/products/add";

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", mainApp.getUser().getHeader());

            MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
            params.add("articule", articuleField.getText());
            params.add("name", nameField.getText());
            params.add("stock", stockField.getText());
            params.add("price", priceField.getText());
            params.add("currency", currencyField.getText());
            params.add("groupId", groups.getValue().getId().toString());

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);

            Boolean added = restTemplate.postForEntity(url, request, Boolean.class).getBody();

            if (added) {
                 mainApp.showAddProduct();
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
