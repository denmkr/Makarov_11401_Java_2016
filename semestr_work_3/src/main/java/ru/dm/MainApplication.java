package ru.dm;

import ru.dm.controllers.MenuController;
import ru.dm.controllers.SigninController;
import ru.dm.controllers.UsersController;
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

@Lazy
@SpringBootApplication
public class MainApplication extends AbstractJavaFxApplicationSupport {
    Page currentPage = Page.LOGIN;

    @Qualifier("usersLoader")
    @Autowired
    private FXMLLoader usersLoader;

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

    public Page getCurrentPage() {
        return currentPage;
    }

    public MenuController getMenuController() {
        return menuController;
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

}
