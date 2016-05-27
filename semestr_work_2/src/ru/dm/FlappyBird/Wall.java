package ru.dm.FlappyBird;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * Created by Denis on 27.05.16.
 */
public class Wall extends Pane {

    Rectangle rectangle;
    public int height;

    public Wall(int height) {
        this.height = height;

        rectangle = new Rectangle();

        rectangle.setWidth(44);
        rectangle.setHeight(height);

        this.getChildren().add(rectangle);
    }

}
