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
import ru.dm.entity.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by Rus on 27.05.2016.
 */
public class OrdersController {
    @FXML
    private TableView<Order> ordersTable;
    private ObservableList<Order> orders = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Order, String> id;
    @FXML
    private TableColumn<Order, String> count;
    @FXML
    private TableColumn<Order, String> date;
    @FXML
    private TableColumn<Order, String> product;
    @FXML
    private TableColumn<Order, String> user;

    private MainApplication mainApp;
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        initOrders();
        ordersTable.setItems(orders);
    }

    private void initOrders() {
        if (orders.size() == 0) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String url = "http://localhost:8080/api/orders";
                ObjectMapper objectMapper = new ObjectMapper();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization", mainApp.getUser().getHeader());
                HttpEntity<String> request = new HttpEntity<String>(headers);
                String json = restTemplate.exchange(url, HttpMethod.GET, request,String.class).getBody();
                List<Order> orderList = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Order.class));

                orders.addAll(orderList);
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
        id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));
        count.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCount().toString()));
        date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
        product.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProduct().getName()));
        user.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Order, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Order, String> param) {
                if (param.getValue().getUser() != null) return new SimpleStringProperty(param.getValue().getUser().getUsername());
                return new SimpleStringProperty("");
            }
        });

    }
}
