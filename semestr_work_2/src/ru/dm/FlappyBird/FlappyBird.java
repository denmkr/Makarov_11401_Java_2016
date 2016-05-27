package ru.dm.FlappyBird;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
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
import java.util.Timer;

/**
 * Created by Denis on 20.05.16.
 */
public class FlappyBird extends Application {

    /* Панели */
    Pane appRoot;
    Pane gameRoot;

    Bird bird;

    AnimationTimer timer;


    /* Рисуем все элементы игры */
    public Parent createContent() throws Exception {

        appRoot = FXMLLoader.load(getClass().getResource("flappybird.fxml")); // Загрузка всех панелей и элементов из файла xml

        gameRoot = (Pane) appRoot.lookup("#gameRoot");
        bird = new Bird();



        gameRoot.getChildren().add(bird);

        return appRoot;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(createContent());

        /* Прыжок птички вверх */
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                timer.start();
                bird.jump();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        /* Таймер для обновления местоположения */
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
    }

    public void update() {

        if (bird.speed.getY() < 5) {
            bird.speed = bird.speed.add(0, 1);
        }

        bird.moveY((int) bird.speed.getY());
    }


    /* Запуск */
    public static void main(String[] args) {
        launch(args);
    }

}
