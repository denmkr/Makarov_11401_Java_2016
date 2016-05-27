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

    Rectangle bird;

    Point2D speed;
    AnimationTimer timer;


    /* Рисуем все элементы игры */
    public Parent createContent() throws Exception {

        appRoot = FXMLLoader.load(getClass().getResource("flappybird.fxml")); // Загрузка всех панелей и элементов из файла xml

        gameRoot = (Pane) appRoot.lookup("#gameRoot");
        bird = new Rectangle(20, 20, Color.RED);

        bird.setLayoutY(400);


        gameRoot.getChildren().add(bird);

        return appRoot;
    }

    public void jump() {
        speed = new Point2D(4, -16); // Прыжок
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(createContent());

        /* Прыжок птички вверх */
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                timer.start();
                jump();
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

        if (speed.getY() < 5) {
            speed = speed.add(0, 1);
        }

        moveY((int) speed.getY());
    }

    public void moveY(int value) {

        int moveDown;
        if (value > 0) moveDown = 1;
        else moveDown = -1;

        for (int i = 0; i < Math.abs(value); i++) {

            bird.setTranslateY(bird.getTranslateY() + moveDown);

        }
    }

    /* Запуск */
    public static void main(String[] args) {
        launch(args);
    }

}
