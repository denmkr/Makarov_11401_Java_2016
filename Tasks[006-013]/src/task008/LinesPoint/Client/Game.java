package task008.LinesPoint.Client;

import task008.LinesPoint.Client.GComponents.GSquare;
import task008.LinesPoint.Coordinates;
import task008.LinesPoint.Step;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Denis on 22.12.15.
 */
public class Game {

    public static Step step;
    public static int countSteps;

    public Game() throws IOException, ClassNotFoundException {

        countSteps = 0;

    }


    public static void nextStep() {
        if (step.equals(Step.I)) step = Step.Opponent;
        else step = Step.I;

        countSteps++;
        System.out.print(countSteps);
        if (countSteps==Client.linesAndPoints.getFieldSize()*(Client.linesAndPoints.getFieldSize()-2)/2) whoWin();
    }

    private static void whoWin() { // Проверка кто выйграл
        int countI = 0, countOpponent = 0;
        for (int i=1; i<Client.linesAndPoints.getFieldSize() - 1; i++) {
            for (int j=1; j<Client.linesAndPoints.getFieldSize() - 1; j++) {
                if (i % 2 != 0 && j % 2 != 0) {
                    GSquare square = (GSquare) Client.linesAndPoints.gameFieldPanel.getComponent(i * Client.linesAndPoints.getFieldSize() + j);
                    if (square.whoFilled.equals(Step.I)) {
                        countI++;
                    }
                    else {
                        countOpponent++;
                    }
                }
            }
        }

        if (countI>countOpponent) {
            Client.linesAndPoints.infoLabel.setText("Вы выйграли");
            Client.linesAndPoints.infoLabel.setForeground(Color.GREEN);

            JOptionPane.showMessageDialog(null, "Начать игру заново?", null, JOptionPane.PLAIN_MESSAGE);


                    Client.linesAndPoints.dispose();
                    Client.linesAndPoints = new LinesAndPoints(1);

            try {
                Client.game = new Game();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Client.linesAndPoints.setEnabled(true);
            Client.linesAndPoints.infoLabel.setForeground(Color.red);
            Client.linesAndPoints.infoLabel.setText("Ход противника");

            setStep(Step.Opponent); // Кто ходит первый


        }
        else {
            Client.linesAndPoints.infoLabel.setText("Вы проиграли");
            Client.linesAndPoints.infoLabel.setForeground(Color.RED);
            JOptionPane.showMessageDialog(null, "Начать игру заново?", null, JOptionPane.PLAIN_MESSAGE);

            Client.linesAndPoints.dispose();
            Client.linesAndPoints = new LinesAndPoints(1);

            try {
                Client.game = new Game();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Client.linesAndPoints.setEnabled(true);
            Client.linesAndPoints.infoLabel.setForeground(Color.green);
            Client.linesAndPoints.infoLabel.setText("Ваш ход");

            setStep(Step.I); // Кто ходит первый


        }

    }

    public static Step getStep() {
        return step;
    }

    public static void setStep(Step myStep) {
        step = myStep;
    }

}
