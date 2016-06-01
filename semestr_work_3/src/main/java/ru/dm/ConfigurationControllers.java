package ru.dm;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ConfigurationControllers {
    @Bean(name = "usersLoader")
    public FXMLLoader getUsersLoader() {
        return loadView("Users.fxml");
    }
    @Bean(name = "addUserLoader")
    public FXMLLoader addUserLoader() {
        return loadView("UserAdd.fxml");
    }
    @Bean(name = "removeUserLoader")
    public FXMLLoader removeUserLoader() {
        return loadView("UserRemove.fxml");
    }
    @Bean(name = "loginLoader")
    public FXMLLoader getLoginLoader() {
        return loadView("Login.fxml");
    }
    @Bean(name = "menuLoader")
    public FXMLLoader getMenuLoader() {
        return loadView("Menu.fxml");
    }
    @Bean(name = "productsLoader")
    public FXMLLoader getProductsLoader() {
        return loadView("Products.fxml");
    }
    @Bean(name = "addProductLoader")
    public FXMLLoader addProductLoader() {
        return loadView("ProductAdd.fxml");
    }
    @Bean(name = "removeProductLoader")
    public FXMLLoader removeProductLoader() {
        return loadView("ProductRemove.fxml");
    }
    @Bean(name = "ordersLoader")
    public FXMLLoader getOrdersLoader() {
        return loadView("Orders.fxml");
    }

    protected FXMLLoader loadView(String url) {
        InputStream fxmlStream = null;
        try {
            fxmlStream = getClass().getClassLoader().getResourceAsStream(url);
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return loader;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fxmlStream != null) {
                try {
                    fxmlStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}