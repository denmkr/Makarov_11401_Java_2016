package task008.LinesPoint.Server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Denis on 29.11.15.
 */

public class Server {

    ArrayList<Connection> connections;
    static ApplicationContext appContext;

    public Server() throws IOException {
        System.out.print("Server is on");

        connections = (ArrayList) appContext.getBean("connections");
        ServerSocket s = (ServerSocket) appContext.getBean("s");

        while (true) {
            Socket client1 = s.accept();
            Socket client2 = s.accept();
            connections.add(new Connection(this, client1, client2));
        }
    }

    public static void main(String[] args) throws IOException {
        appContext = new ClassPathXmlApplicationContext("task008/LinesPoint/Server/spring-config-task008-server.xml");
        new Server();
    }

}
