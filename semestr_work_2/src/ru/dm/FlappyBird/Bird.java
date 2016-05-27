package ru.dm.FlappyBird;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * Created by Denis on 27.05.16.
 */
public class Bird extends Pane {

    boolean crashed = false;

    Point2D speed;
    public Rectangle rectangle;

    public Bird() {
        rectangle = new Rectangle();
        rectangle.setWidth(40);
        rectangle.setHeight(28);

        rectangle.setTranslateY(200);
        rectangle.setTranslateX(100);

        speed = new Point2D(0, 0);
        setTranslateY(200);
        setTranslateX(100);

        this.getChildren().addAll(rectangle);
    }

    public void moveX(int value) {

        for (int i = 0; i < value; i++) {

            setTranslateX(getTranslateX() + 1);

        }
    }

    public void moveY(int value) {

        int moveDown;
        if (value > 0) moveDown = 1;
        else moveDown = -1;

        for (int i = 0; i < Math.abs(value); i++) {

            this.setTranslateY(getTranslateY() + moveDown);

        }
    }

    public void jump() {
        speed = new Point2D(4, -16); // Прыжок
    }


}