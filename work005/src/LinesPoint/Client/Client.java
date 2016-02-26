package LinesPoint.Client;

import LinesPoint.Client.GComponents.GLine;
import LinesPoint.Client.GComponents.GSquare;
import LinesPoint.Coordinates;
import LinesPoint.Step;

import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by Denis on 29.11.15.
 */

public class Client {

    public static LinesAndPoints linesAndPoints;
    public static ObjectOutputStream os;
    public static ObjectInputStream is;
    public static Socket socket;

    public static Game game;

    public Client() throws IOException, ClassNotFoundException {

        getIpDialog(); // Вызываем окно для ввода ip адреса

        linesAndPoints = new LinesAndPoints(3); // Создаем фрэйм клиента

        os = new ObjectOutputStream(socket.getOutputStream());
        is = new ObjectInputStream(socket.getInputStream());

        game = new Game();

        game.setStep((Step) is.readObject()); // Кто ходит первый

        if (game.getStep().equals(Step.I)) {
            linesAndPoints.setEnabled(true);
            linesAndPoints.infoLabel.setForeground(Color.green);
            linesAndPoints.infoLabel.setText("Ваш ход");
        }
        else {
            linesAndPoints.infoLabel.setForeground(Color.red);
            linesAndPoints.infoLabel.setText("Ход противника");

        }

        go(); // Запускаем цикл клиента

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Client client = new Client();

    }

    public static void sendCoordinates(Coordinates coordinates) {
        try {
            os.writeObject(coordinates);
            os.flush();
            os.reset();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getIpDialog() throws IOException {

        boolean writeIp = false;

        while (!writeIp) {
            String input = JOptionPane.showInputDialog(null, "Введите ip адрес сервера", null, JOptionPane.CLOSED_OPTION);
            if (input.length() > 0) {
                try {
                    socket = new Socket(input, 3400);
                    writeIp = true;
                } catch (SocketException s) {

                } catch (UnknownHostException u) {

                } catch (IOException e) {

                }
            }
        }
    }

    private void go() throws IOException, ClassNotFoundException {

        while (true) {

            try {
                Coordinates coordinates = (Coordinates) is.readObject(); // Принимаем ход противника
                if (coordinates.getX()==-1) {
                    System.exit(0);
                }
                acceptStep(coordinates); // Обрабатываем ход противника
            }
            catch (EOFException e) {
                System.exit(0);
            }


        }
    }

    private void acceptStep(Coordinates coordinates) throws IOException, ClassNotFoundException {

        GLine line = (GLine) linesAndPoints.gameFieldPanel.getComponent(coordinates.getY()*linesAndPoints.getFieldSize() + coordinates.getX());
        line.isSelected = true;
        line.changeBackground(new Color(10, 50, 255));

        if (line.gridX % 2 == 0) {
            if ((line.gridX-1) >= 0) {
                GSquare squarePanelLeft = (GSquare) linesAndPoints.gameFieldPanel.getComponent(line.gridY * linesAndPoints.getFieldSize() + (line.gridX - 1));
                squarePanelLeft.addLine(game.getStep());
            }

            if ((line.gridX+1) < linesAndPoints.getFieldSize()-1) {
                GSquare squarePanelRight = (GSquare) linesAndPoints.gameFieldPanel.getComponent(line.gridY * linesAndPoints.getFieldSize() + (line.gridX + 1));
                squarePanelRight.addLine(game.getStep());
            }
        }
        else {
            if ((line.gridY-1) >= 0) {
                GSquare squarePanelTop = (GSquare) linesAndPoints.gameFieldPanel.getComponent((line.gridY - 1)*linesAndPoints.getFieldSize() + line.gridX);
                squarePanelTop.addLine(game.getStep());
            }

            if ((line.gridY+1) < linesAndPoints.getFieldSize()-1) {
                GSquare squarePanelBottom = (GSquare) linesAndPoints.gameFieldPanel.getComponent((line.gridY + 1) * linesAndPoints.getFieldSize() + line.gridX);
                squarePanelBottom.addLine(game.getStep());
            }
        }

        linesAndPoints.setEnabled(true);
        linesAndPoints.infoLabel.setForeground(Color.green);
        linesAndPoints.infoLabel.setText("Ваш ход");

        game.nextStep();

    }


}
