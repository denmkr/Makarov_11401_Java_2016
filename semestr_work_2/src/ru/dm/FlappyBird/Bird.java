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

        speed = new Point2D(0, 0);
        setTranslateY(200);
        setTranslateX(200);

        this.getChildren().addAll(rectangle);
    }

    public void moveX(int value) {

        for (int i = 0; i < value; i++) {
            for (Wall wall : FlappyBird.walls) {
                if (this.getBoundsInParent().intersects(wall.getBoundsInParent())) {
                    if (getTranslateX() + 40 == wall.getTranslateX()) {
                        crashed = true;
                    }
                }

                if (getTranslateX() == wall.getTranslateX()) {
                    if (wall.getTranslateY() == 0)
                        FlappyBird.score++;
                }
            }

            setTranslateX(getTranslateX() + 1);

        }
    }

    public void moveY(int value) {

        int moveDown;
        if (value > 0) moveDown = 1;
        else moveDown = -1;

        for (int i = 0; i < Math.abs(value); i++) {

            /* Врежется в стену */
            for (Wall wall : FlappyBird.walls) {
                if (this.getBoundsInParent().intersects(wall.getBoundsInParent())) {
                    crashed = true;
                }
            }

            if (getTranslateY() < 0) {
                setTranslateY(0);
                crashed = true; // Врежется в потолок
            }
            if (getTranslateY() > (600-28-40)) {
                setTranslateY(600 - 28 - 40);
                crashed = true; // Врежется в пол
            }

            if (!crashed) this.setTranslateY(getTranslateY() + moveDown);

        }
    }

    public void jump() {
        speed = new Point2D(4, -16); // Прыжок
    }


}
