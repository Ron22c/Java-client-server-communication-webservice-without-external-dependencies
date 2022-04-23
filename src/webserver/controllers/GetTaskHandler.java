package webserver.controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class GetTaskHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "";
        URI uri = httpExchange.getRequestURI();
        String query = uri.getRawQuery();
        response+=query;
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream res = httpExchange.getResponseBody();
        res.write(response.getBytes());
        res.close();
    }
}
