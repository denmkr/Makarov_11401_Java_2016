package LinesPoint.Client.GComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Denis on 23.11.15.
 */
public class GPoint extends JButton {

    protected int gridX;
    protected int gridY;

    public GPoint(int x, int y) {

        this.gridX = x - 1;
        this.gridY = y - 1;

        this.setPreferredSize(new Dimension(10, 10));

        this.setBackground(Color.darkGray);
        this.setOpaque(true);
        this.setBorderPainted(false);

    }
}
