package task008.LinesPoint.Client.GComponents;

import task008.LinesPoint.Client.*;
import task008.LinesPoint.Coordinates;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Denis on 23.11.15.
 */
public class GHorizontalLine extends GLine {

    public GHorizontalLine(int x, int y) {
        gridX = x - 1;
        gridY = y - 1;

        this.setPreferredSize(new Dimension(100, 10));

        this.setBackground(Color.LIGHT_GRAY);

        this.setOpaque(true);
        this.setBorderPainted(false);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClick();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mouseEnter();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseExit();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

    }

    public void mouseClick() {
        if (!isSelected) {

            changeBackground(new Color(255, 51, 51));

            if ((gridY-1) >= 0) {
                GSquare squarePanelTop = (GSquare) Client.linesAndPoints.gameFieldPanel.getComponent((gridY - 1)* Client.linesAndPoints.getFieldSize() + gridX);
                squarePanelTop.addLine(Client.game.getStep());
            }

            if ((gridY+1) < Client.linesAndPoints.getFieldSize()-1) {
                GSquare squarePanelBottom = (GSquare) Client.linesAndPoints.gameFieldPanel.getComponent((gridY + 1) * Client.linesAndPoints.getFieldSize() + gridX);
                squarePanelBottom.addLine(Client.game.getStep());
            }

            isSelected = true;

            Client.sendCoordinates(new Coordinates(gridX, gridY));

            Client.linesAndPoints.infoLabel.setForeground(Color.red);
            Client.linesAndPoints.infoLabel.setText("Ход противника");
            Client.linesAndPoints.setEnabled(false);

            Client.game.nextStep();


        }
    }

    public void mouseEnter() {
        if (!isSelected) {
            changeBackground(new Color(255, 204, 204));
        }
    }

    public void mouseExit() {
        if (!isSelected) {
            changeBackground(Color.LIGHT_GRAY); // Вернуть изначальный цвет
        }
    }


}