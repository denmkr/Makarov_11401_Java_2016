package ru.dm.FlappyBird;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Denis on 20.05.16.
 */
public class FlappyBird extends Application {

    /* Панели */
    Pane appRoot;
    Pane gameRoot;

    Rectangle rectangle;


    /* Рисуем все элементы игры */
    public Parent createContent() throws Exception {

        appRoot = FXMLLoader.load(getClass().getResource("flappybird.fxml")); // Загрузка всех панелей и элементов из файла xml

        gameRoot = (Pane) appRoot.lookup("#gameRoot");
        rectangle = new Rectangle(20, 20, Color.RED);

        rectangle.setLayoutY(400);


        gameRoot.getChildren().add(rectangle);

        return appRoot;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(createContent());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /* Запуск */
    public static void main(String[] args) {
        launch(args);
    }

}
