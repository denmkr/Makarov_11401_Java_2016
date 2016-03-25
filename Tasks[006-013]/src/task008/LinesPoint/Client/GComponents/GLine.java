package task008.LinesPoint.Client.GComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Denis on 06.12.15.
 */
public class GLine extends JButton {

    public Color color;

    public int gridX;
    public int gridY;

    /* Состояние палочки (была ли нажата) */
    public boolean isSelected;

    public void changeBackground(Color color) {
        this.color = color;
        setBackground(color);
    }

}
