package ru.dm.FlappyBird;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * Created by Denis on 27.05.16.
 */
public class Wall extends Pane {

    ImageView image;
    public int height;

    public Wall(int height) {
        this.height = height;

        image = new ImageView(new Image("ru/dm/FlappyBird/images/wall.jpg"));
        image.setFitWidth(44);
        image.setFitHeight(height);


        this.getChildren().add(image);
    }

}
