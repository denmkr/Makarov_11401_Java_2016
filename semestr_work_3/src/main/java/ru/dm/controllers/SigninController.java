package ru.dm.controllers;

import javafx.scene.control.*;
import ru.dm.MainApplication;
import ru.dm.entity.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Rus on 20.05.2016.
 */
public class SigninController {
    private MainApplication mainApp;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleLogin() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/login";
        HttpHeaders headers = new HttpHeaders();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
            params.add("username", usernameField.getText());
            params.add("password", passwordField.getText());
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);

            String json = restTemplate.postForEntity(url, request, String.class, params).getBody();
            User user;
            if (json != null) {
                user = objectMapper.readValue(json, User.class);
                mainApp.setUser(user);
                mainApp.getUser().setPassword(passwordField.getText());
                mainApp.showUsers();

                mainApp.getMenuController().loginMenuItem.setText("Выйти");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Неправильный логин или пароль");
                alert.setContentText("Неправильный логин или пароль");
                alert.showAndWait();
            }
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
