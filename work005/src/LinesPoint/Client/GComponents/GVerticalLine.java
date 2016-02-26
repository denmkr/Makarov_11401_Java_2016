package LinesPoint.Client.GComponents;

import LinesPoint.Client.Client;
import LinesPoint.Coordinates;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Denis on 23.11.15.
 */
public class GVerticalLine extends GLine {

    public GVerticalLine(int x, int y) {

        gridX = x-1;
        gridY = y-1;

        this.setPreferredSize(new Dimension(10, 100));

        this.setBackground(Color.LIGHT_GRAY);

        this.setOpaque(true);
        this.setBorderPainted(false);

        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (!isSelected) {

                    changeBackground(new Color(255, 51, 51));

                    if ((gridX-1) >= 0) {
                        GSquare squarePanelLeft = (GSquare) Client.linesAndPoints.gameFieldPanel.getComponent(gridY * Client.linesAndPoints.getFieldSize() + (gridX - 1));
                        squarePanelLeft.addLine(Client.game.getStep());
                    }

                    if ((gridX+1) < Client.linesAndPoints.getFieldSize()-1) {
                        GSquare squarePanelRight = (GSquare) Client.linesAndPoints.gameFieldPanel.getComponent(gridY * Client.linesAndPoints.getFieldSize() + (gridX + 1));
                        squarePanelRight.addLine(Client.game.getStep());
                    }

                    isSelected = true;

                    Client.sendCoordinates(new Coordinates(gridX, gridY));

                    Client.linesAndPoints.infoLabel.setForeground(Color.red);
                    Client.linesAndPoints.infoLabel.setText("Ход противника");
                    Client.linesAndPoints.setEnabled(false);

                    Client.game.nextStep();

                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isSelected) {
                    changeBackground(new Color(255, 204, 204));
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isSelected) {
                    changeBackground(Color.LIGHT_GRAY); // Вернуть изначальный цвет
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

    }

}
