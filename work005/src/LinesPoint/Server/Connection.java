package LinesPoint.Server;

import LinesPoint.Coordinates;
import LinesPoint.Step;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Denis on 29.11.15.
 */

class Connection implements Runnable {

    Socket socket1, socket2;
    Thread thread;
    Server server;

    boolean exit;

    Coordinates coordinates;

    ObjectInputStream in1, in2;
    ObjectOutputStream out1, out2;

    public Connection(Server server, Socket socket1, Socket socket2) {
        this.socket1 = socket1;
        this.socket2 = socket2;

        this.server = server;

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        try {

            out1 = new ObjectOutputStream(socket1.getOutputStream());
            in1 = new ObjectInputStream(socket1.getInputStream());
            out2 = new ObjectOutputStream(socket2.getOutputStream());
            in2 = new ObjectInputStream(socket2.getInputStream());

            out1.writeObject(Step.I);
            out2.writeObject(Step.Opponent);

            while (true) {

                coordinates = (Coordinates) in1.readObject(); // Принимаем сообщение

                try {
                    out2.reset();
                    out2.flush();
                    out2.writeObject(coordinates);
                }
                catch (SocketException s) {
                    socket1.close();
                    socket2.close();
                    System.out.print("closed");
                }

                coordinates = (Coordinates) in2.readObject(); // Принимаем сообщение

                try {
                    out1.reset();
                    out1.flush();
                    out1.writeObject(coordinates);
                }
                catch (SocketException s) {
                    socket1.close();
                    socket2.close();
                    System.out.print("closed");
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
