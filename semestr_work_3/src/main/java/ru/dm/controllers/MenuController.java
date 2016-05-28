package ru.dm.controllers;

import javafx.scene.control.MenuItem;
import ru.dm.MainApplication;
import javafx.fxml.FXML;
import ru.dm.Page;

/**
 * Created by Rus on 25.05.2016.
 */
public class MenuController {
    private MainApplication mainApp;

    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    MenuItem loginMenuItem;

    @FXML
    private void handleProducts() {
        if (mainApp.getCurrentPage() != Page.PRODUCTS) {
            mainApp.showProducts();
        }
    }

    @FXML
    private void handleOrders() {
        if (mainApp.getCurrentPage() != Page.ORDERS) {
            mainApp.showOrders();
        }
    }

    @FXML
    private void handleLogin() {
        if (mainApp.getCurrentPage() != Page.LOGIN) {
            mainApp.showLogin();
        }
    }

    @FXML
    private void handleUsers() {
        if (mainApp.getCurrentPage() != Page.USERS) {
            mainApp.showUsers();
        }
    }

    @FXML
    private void handleAddUser() {
        mainApp.showAddUser();

    }

    @FXML
    private void handleRemoveUser() {

        mainApp.showRemoveUser();

    }

    @FXML
    private void handleAddProduct() {

        mainApp.showAddProduct();

    }

    @FXML
    private void handleRemoveProduct() {

        mainApp.showRemoveProduct();

    }

}
