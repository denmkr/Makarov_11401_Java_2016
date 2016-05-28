package ru.dm.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.dm.MainApplication;
import ru.dm.entity.Order;
import ru.dm.entity.Product;
import ru.dm.entity.ProductGroup;

import java.io.IOException;
import java.util.List;

/**
 * Created by Denis on 28.05.2016.
 */
public class GroupsController {

    private ObservableList<ProductGroup> groups = FXCollections.observableArrayList();

    private MainApplication mainApp;
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        initGroups();
    }

    private void initGroups() {
        if (groups.size() == 0) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String url = "http://localhost:8080/api/groups";
                ObjectMapper objectMapper = new ObjectMapper();
                HttpHeaders headers = new HttpHeaders();
                System.out.println(mainApp.getUser().getUsername());
                headers.add("Authorization", mainApp.getUser().getHeader());
                HttpEntity<String> request = new HttpEntity<String>(headers);
                String json = restTemplate.exchange(url, HttpMethod.GET, request,String.class).getBody();
                List<ProductGroup> groupList = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, ProductGroup.class));

                groups.addAll(groupList);
            } catch (IOException e) {
                e.printStackTrace();
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

    public ObservableList<ProductGroup> getGroups() {
        initGroups();
        return groups;
    }
}
