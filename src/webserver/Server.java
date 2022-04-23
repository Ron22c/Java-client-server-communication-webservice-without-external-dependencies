package webserver;

import com.sun.net.httpserver.HttpServer;
import webserver.controllers.GetHeadersHandler;
import webserver.controllers.GetTaskHandler;
import webserver.controllers.PostTaskHandler;
import webserver.controllers.RootHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) {
        try {
            final int port = 8080;

            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
            System.out.println("SERVER IS UP AND RUNNING ON PORT 8080");

            server.createContext("/", new RootHandler());
            server.createContext("/headers", new GetHeadersHandler());
            server.createContext("/task", new GetTaskHandler());
            server.createContext("/addtask", new PostTaskHandler());

            server.setExecutor(null);
            server.start();

        } catch(IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
