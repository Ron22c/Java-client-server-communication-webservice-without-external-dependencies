package webserver.controllers;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class RootHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "<h1>SERVER IS UP AND RUNNING ON PORT 8080</h1>";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream res = httpExchange.getResponseBody();
        res.write(response.getBytes());
        res.close();
    }
}
