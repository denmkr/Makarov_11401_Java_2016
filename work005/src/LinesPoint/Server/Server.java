package LinesPoint.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Denis on 29.11.15.
 */

public class Server {

    ArrayList<Connection> connections;

    public Server() throws IOException {

        connections = new ArrayList<Connection>();
        System.out.print("Server is on");

        ServerSocket s = new ServerSocket(3400);

        while (true) {
            Socket client1 = s.accept();
            Socket client2 = s.accept();
            connections.add(new Connection(this, client1, client2));
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }

}
