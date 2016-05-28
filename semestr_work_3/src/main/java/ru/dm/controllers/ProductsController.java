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
import ru.dm.entity.Product;
import ru.dm.entity.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by Rus on 27.05.2016.
 */
public class ProductsController {
    @FXML
    private TableView<Product> productsTable;
    private ObservableList<Product> products = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Product, String> articule;
    @FXML
    private TableColumn<Product, String> name;
    @FXML
    private TableColumn<Product, String> stock;
    @FXML
    private TableColumn<Product, String> price;
    @FXML
    private TableColumn<Product, String> currency;
    @FXML
    private TableColumn<Product, String> group;

    private MainApplication mainApp;
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        initUsers();
        productsTable.setItems(products);
    }

    private void initUsers() {
        if (products.size() == 0) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String url = "http://localhost:8080/api/products";
                ObjectMapper objectMapper = new ObjectMapper();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization", mainApp.getUser().getHeader());
                HttpEntity<String> request = new HttpEntity<String>(headers);
                String json = restTemplate.exchange(url, HttpMethod.GET, request,String.class).getBody();
                List<Product> productList = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
                products.addAll(productList);
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
        name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName().toString()));
        articule.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArticule().toString()));
        stock.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStock().toString()));
        price.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrice().toString()));
        currency.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCurrency().toString()));
        group.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductGroup().getName().toString()));
    }
}
