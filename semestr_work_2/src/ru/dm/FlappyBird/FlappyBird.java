package ru.dm.FlappyBird;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    public static List<Wall> walls;
    Bird bird;

    AnimationTimer timer;

    public static int score; // Счетчик очков


    /* Рисуем все элементы игры */
    public Parent createContent() throws Exception {

        appRoot = FXMLLoader.load(getClass().getResource("flappybird.fxml")); // Загрузка всех панелей и элементов из файла xml

        gameRoot = (Pane) appRoot.lookup("#gameRoot");
        bird = new Bird();
        walls = new ArrayList<Wall>();

        generateWalls();

        gameRoot.getChildren().add(bird);

        return appRoot;
    }

    /* Генерируем стены */
    private void generateWalls() {
        for (int i=0; i<100; i++) {
            int enter = 160 + new Random().nextInt(210 - 160 + 1); // min + (max - min + 1)
            int height = new Random().nextInt(600 - enter - 48);

            int distance = 550 + new Random().nextInt(700 - 550 + 1); // min + (max - min + 1)

            Wall wall = new Wall(height);
            wall.setTranslateX(i * distance + 100);
            wall.setTranslateY(0);

            walls.add(wall);

            Wall wall2 = new Wall(600 - enter - height);
            wall2.setTranslateX(i * distance + 100);
            wall2.setTranslateY(height + enter);

            walls.add(wall2);

            gameRoot.getChildren().addAll(wall, wall2);
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(createContent());

        /* Прыжок птички вверх */
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!bird.crashed) {
                    timer.start();
                    bird.jump();
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        /* Таймер для обновления местоположения */
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();

                if (bird.crashed) {
                    this.stop();
                }
            }
        };
    }

    public void update() {

        if (bird.speed.getY() < 5) {
            bird.speed = bird.speed.add(0, 1);
        }

        bird.moveX((int) bird.speed.getX());
        bird.moveY((int) bird.speed.getY());

        /* Движение панели, если птичка достигает 200 пикселей по оси X */
        bird.translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int offset = newValue.intValue();
                if (offset > 200) gameRoot.setLayoutX(-(offset - 200));
            }
        });
    }


    /* Запуск */
    public static void main(String[] args) {

        launch(args);
    }

}
