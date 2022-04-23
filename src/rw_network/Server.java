package rw_network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        Socket socket = server.accept();

        DataInputStream socketInput = new DataInputStream(socket.getInputStream());
        DataOutputStream socketOutput = new DataOutputStream(socket.getOutputStream());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String clientText = "";
        String serverText = "";
        while(!clientText.equalsIgnoreCase("stop")) {
            clientText = socketInput.readUTF();
            System.out.println("CLIENT MESSAGE: "+clientText);

            serverText = reader.readLine();
            socketOutput.writeUTF(serverText);
            socketOutput.flush();
        }

        reader.close();
        socket.close();
        server.close();
    }
}
