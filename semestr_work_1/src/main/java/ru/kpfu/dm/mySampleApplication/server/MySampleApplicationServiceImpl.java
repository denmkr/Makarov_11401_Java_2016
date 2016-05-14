package ru.kpfu.dm.mySampleApplication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.kpfu.dm.mySampleApplication.client.MySampleApplicationService;

import java.util.Random;


public class MySampleApplicationServiceImpl extends RemoteServiceServlet implements MySampleApplicationService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
    public String getLabelText() {
        return "Hello";
    }
    public String getLuckyDay() {
        Random random = new Random();
        int answer = random.nextInt(10) + 1;
        if (answer < 5) return "Bad day";
        else return "Lucky Day";
    }
}