package webserver.controllers;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GetHeadersHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "";
        Headers headers = httpExchange.getRequestHeaders();
        Set<Map.Entry<String, List<String>>> entries = headers.entrySet();

        for(Map.Entry<String, List<String>> entry: entries) {
            response += entry.toString()+"\n";
        }

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream res = httpExchange.getResponseBody();
        res.write(response.getBytes());
        res.close();
    }
}
