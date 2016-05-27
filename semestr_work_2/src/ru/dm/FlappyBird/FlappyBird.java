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
    Pane informationRoot;

    /* Таймер и таймлайн для анимаций */
    AnimationTimer timer;
    Timeline timeline;

    /* Вспомогательные элементы */
    Button againButton;
    Label endLabel;
    Label scoreLabel;

    /* Элементы игры */
    public static List<Wall> walls;
    Bird bird;

    public static int score; // Счетчик очков


    /* Обнуляем и инициализируем элементы */
    private void initialization() {
        score = 0;
        walls = new ArrayList<Wall>();
        bird = new Bird();

        gameRoot = (Pane) appRoot.lookup("#gameRoot");
        againButton = (Button) appRoot.lookup("#againButton");
        endLabel = (Label) appRoot.lookup("#resultLabel");
        scoreLabel = (Label) appRoot.lookup("#scoreLabel");
        informationRoot = (Pane)  appRoot.lookup("#informationRoot");
    }

    /* Генерируем стены */
    private void generateWalls() {
        for (int i=0; i<100; i++) {
            int enter = 160 + new Random().nextInt(210 - 160 + 1); // min + (max - min + 1)
            int height = new Random().nextInt(600 - enter - 48);

            int distance = 550 + new Random().nextInt(700 - 550 + 1); // min + (max - min + 1)

            Wall wall = new Wall(height);
            wall.setTranslateX(i * distance + 800);
            wall.setTranslateY(0);

            walls.add(wall);

            Wall wall2 = new Wall(600 - enter - height - 48);
            wall2.setTranslateX(i * distance + 800);
            wall2.setTranslateY(height + enter);

            walls.add(wall2);

            gameRoot.getChildren().addAll(wall, wall2);
        }
    }


    /* Рисуем все элементы игры */
    public Parent createContent() throws Exception {

        appRoot = FXMLLoader.load(getClass().getResource("flappybird.fxml")); // Загрузка всех панелей и элементов из файла xml

        initialization();

        Image image = new Image("ru/dm/FlappyBird/images/background.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(300, 600, true, true, true, false);
        appRoot.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize)));

        generateWalls();

        /* Анимация полета птички перед стартом */
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);

        final KeyValue kv2 = new KeyValue(bird.translateYProperty(), 300, Interpolator.EASE_BOTH);
        final KeyValue kv3 = new KeyValue(bird.translateYProperty(), -300, Interpolator.EASE_BOTH);
        final KeyFrame kf2 = new KeyFrame(Duration.millis(1000), kv2);
        final KeyFrame kf3 = new KeyFrame(Duration.millis(1000), kv3);

        timeline.getKeyFrames().add(kf2);
        timeline.getKeyFrames().add(kf3);
        timeline.play();

        gameRoot.getChildren().add(bird);

        return appRoot;
    }

    /* Обновляем положение и скорость птички */
    public void update() {

        /* После прыжка птичка должна начать опускаться вниз */
        if (bird.speed.getY() < 5) {
            bird.speed = bird.speed.add(0, 1);
        }

        /* Двигаем птичку */
        bird.moveX((int) bird.speed.getX());
        bird.moveY((int) bird.speed.getY());

        scoreLabel.setText("" + score); // Обновляем счетчик очков

        /* Движение панели, если птичка достигает 200 пикселей по оси X */
        bird.translateXProperty().addListener((obs, old, newValue) -> {
            int offset = newValue.intValue();
            if (offset > 200) gameRoot.setLayoutX(-(offset - 200));
        });

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(createContent());

        /* Прыжок птички вверх */
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!bird.crashed) {
                    timeline.stop();
                    timer.start();
                    bird.jump();
                }
            }
        });

        /* Начать заново */
        againButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
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

                    endLabel.setText("Ваш результат: " + score);

                    FadeTransition ft = new FadeTransition(Duration.millis(1000), bird);
                    ft.setFromValue(1.0);
                    ft.setToValue(0.1);
                    ft.setCycleCount(1);
                    ft.setAutoReverse(true);
                    ft.play();

                    timeline = new Timeline();
                    timeline.setCycleCount(1);
                    timeline.setAutoReverse(true);
                    final KeyValue kv = new KeyValue(bird.translateYProperty(), -50, Interpolator.EASE_BOTH);
                    final KeyFrame kf = new KeyFrame(Duration.millis(2000), kv);
                    timeline.getKeyFrames().add(kf);

                    informationRoot.setDisable(false);
                    FadeTransition ft2 = new FadeTransition(Duration.millis(1000), informationRoot);
                    ft2.setFromValue(0);
                    ft2.setToValue(1);
                    ft2.setCycleCount(1);
                    ft2.setAutoReverse(true);
                    ft2.play();

                    timeline.play();
                }
            }
        };

    }

    /* Запуск */
    public static void main(String[] args) {
        launch(args);
    }

}
