package task008.LinesPoint.Client.GComponents;

import task008.LinesPoint.Client.Client;
import task008.LinesPoint.Step;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Denis on 23.11.15.
 */
public class GSquare extends JButton {

    public Step whoFilled = null;

    protected int gridX;
    protected int gridY;

    protected int lineCount;

    protected Color background;

    public GSquare(int x, int y) {

        this.gridX = x - 1;
        this.gridY = y - 1;

        this.setPreferredSize(new Dimension(100, 100));

        this.setOpaque(true);
        this.setBorderPainted(false);

    }


    public void addLine(Step step) {
        this.lineCount++;
        if (this.lineCount == 4) {

            if (step.equals(Step.I)) {
                this.setBackground(new Color(255, 204, 204));
            }
            else {
                this.setBackground(new Color(160, 180, 255));
            }

            whoFilled = step;

           // Client.linesAndPoints.setStep(Step.I);

        }
    }

    public boolean isFull() {
        if (lineCount == 4) {
            return true;
        }
        else {
            return false;
        }
    }

}