package ru.dm;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.dm.controllers.*;
import ru.dm.entity.Product;
import ru.dm.entity.ProductGroup;
import ru.dm.entity.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import ru.dm.entity.UserRole;

import java.io.IOException;
import java.util.List;

@Lazy
@SpringBootApplication
public class MainApplication extends AbstractJavaFxApplicationSupport {
    Page currentPage = Page.LOGIN;

    @Qualifier("usersLoader")
    @Autowired
    private FXMLLoader usersLoader;

    @Qualifier("addUserLoader")
    @Autowired
    private FXMLLoader addUserLoader;

    @Qualifier("removeUserLoader")
    @Autowired
    private FXMLLoader removeUserLoader;

    @Qualifier("productsLoader")
    @Autowired
    private FXMLLoader productsLoader;

    @Qualifier("addProductLoader")
    @Autowired
    private FXMLLoader addProductLoader;

    @Qualifier("removeProductLoader")
    @Autowired
    private FXMLLoader removeProductLoader;

    @Qualifier("ordersLoader")
    @Autowired
    private FXMLLoader ordersLoader;

    @Qualifier("loginLoader")
    @Autowired
    private FXMLLoader loginLoader;

    @Qualifier("menuLoader")
    @Autowired
    private FXMLLoader menuLoader;

    private User user;
    private MenuController menuController;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<ProductGroup> groups = FXCollections.observableArrayList();
    private ObservableList<User> users = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launchApp(MainApplication.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Admin");
        initRootLayout(); // Рисуем изначальный вид
        showLogin(); // Показываем панель авторизации
    }

    public void initRootLayout() {
        rootLayout = menuLoader.getRoot();
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

        menuController = menuLoader.getController();
        menuController.setMainApp(this);
    }

    public void showLogin() {
        user = null;
        currentPage = Page.LOGIN;
        AnchorPane loginPage = (AnchorPane) loginLoader.getRoot();
        rootLayout.setCenter(loginPage);
        SigninController controller = loginLoader.getController();
        controller.setMainApp(this);
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ObservableList<ProductGroup> getGroups() {
        initGroups();
        return groups;
    }

    public ObservableList<User> getUsers() {
        initUsers();
        return users;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public void initGroups() {
        if (groups.size() == 0) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String url = "http://localhost:8080/api/groups";
                ObjectMapper objectMapper = new ObjectMapper();
                String json = restTemplate.getForEntity(url, String.class).getBody();
                List<ProductGroup> groupList = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, ProductGroup.class));

                groups.addAll(groupList);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ResourceAccessException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(getPrimaryStage());
                alert.setTitle("Нет соединения с сервером");
                alert.setContentText("Внимание!Ошибка соединения с сервером!");
                alert.showAndWait();
                showLogin();
            }
        }
    }

    public void initUsers() {
            try {
                users = FXCollections.observableArrayList();
                RestTemplate restTemplate = new RestTemplate();
                String url = "http://localhost:8080/api/users";
                ObjectMapper objectMapper = new ObjectMapper();
                String json = restTemplate.getForEntity(url, String.class).getBody();
                List<User> userList = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));

                users.addAll(userList);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ResourceAccessException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(getPrimaryStage());
                alert.setTitle("Нет соединения с сервером");
                alert.setContentText("Внимание!Ошибка соединения с сервером!");
                alert.showAndWait();
                showLogin();
            }
    }

    public void showUsers() {
        if (user != null) {
            currentPage = Page.USERS;
            AnchorPane testPage = usersLoader.getRoot();
            rootLayout.setCenter(testPage);
            UsersController controller = usersLoader.getController();
            controller.setMainApp(this);
        }
        else showLogin(); // Панель авторизации
    }

    public void showAddUser() {
        if (user != null) {
            currentPage = Page.ADDUSER;
            AnchorPane testPage = addUserLoader.getRoot();
            rootLayout.setCenter(testPage);
            AddUserController controller = addUserLoader.getController();
            controller.setMainApp(this);

        }
        else showLogin(); // Панель авторизации
    }

    public void showRemoveUser() {
        if (user != null) {
            currentPage = Page.REMOVEUSER;
            AnchorPane testPage = removeUserLoader.getRoot();
            rootLayout.setCenter(testPage);
            RemoveUserController controller = removeUserLoader.getController();
            controller.setMainApp(this);

        }
        else showLogin(); // Панель авторизации
    }

    public void showProducts() {
        if (user != null) {
            currentPage = Page.PRODUCTS;
            AnchorPane testPage = productsLoader.getRoot();
            rootLayout.setCenter(testPage);
            ProductsController controller = productsLoader.getController();
            controller.productsTable.getColumns().get(0).setVisible(false);
            controller.productsTable.getColumns().get(0).setVisible(true);
            controller.setMainApp(this);
        }
        else showLogin(); // Панель авторизации
    }

    public void showAddProduct() {
        if (user != null) {
            currentPage = Page.ADDPRODUCT;
            AnchorPane testPage = addProductLoader.getRoot();
            rootLayout.setCenter(testPage);
            AddProductController controller = addProductLoader.getController();
            controller.setMainApp(this);

        }
        else showLogin(); // Панель авторизации
    }

    public void showRemoveProduct() {
        if (user != null) {
            currentPage = Page.REMOVEPRODUCT;
            AnchorPane testPage = removeProductLoader.getRoot();
            rootLayout.setCenter(testPage);
            RemoveProductController controller = removeProductLoader.getController();
            controller.setMainApp(this);

        }
        else showLogin(); // Панель авторизации
    }

    public void showOrders() {
        if (user != null) {
            currentPage = Page.ORDERS;
            AnchorPane testPage = ordersLoader.getRoot();
            rootLayout.setCenter(testPage);
            OrdersController controller = ordersLoader.getController();
            controller.setMainApp(this);
        }
        else showLogin(); // Панель авторизации
    }

}
