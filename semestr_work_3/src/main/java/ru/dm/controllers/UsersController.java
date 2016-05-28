package ru.dm.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.dm.MainApplication;
import ru.dm.entity.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by Rus on 27.05.2016.
 */
public class UsersController {
    @FXML
    private TableView<User> usersTable;
    private ObservableList<User> users = FXCollections.observableArrayList();
    @FXML
    private TableColumn<User, String> name;
    @FXML
    private TableColumn<User, String> email;
    @FXML
    private TableColumn<User, String> date;

    private MainApplication mainApp;
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        initUsers();
        usersTable.setItems(users);
    }

    private void initUsers() {
        if (users.size() == 0) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String url = "http://localhost:8080/api/users";
                ObjectMapper objectMapper = new ObjectMapper();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization", mainApp.getUser().getHeader());
                HttpEntity<String> request = new HttpEntity<String>(headers);
                String json = restTemplate.exchange(url, HttpMethod.GET, request,String.class).getBody();
                List<User> usersList = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
                users.addAll(usersList);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ResourceAccessException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Нет соединения с сервером");
                alert.setContentText("Внимание!Ошибка соединения с сервером!");
                alert.showAndWait();
                mainApp.showLogin();
            }
        }
    }

    @FXML
    public void initialize() {
        name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsername().toString()));
        email.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail().toString()));
        date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
    }
}
