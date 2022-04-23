package rw_network;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        DataInputStream inputInSocket = new DataInputStream(socket.getInputStream());
        DataOutputStream outputFromSocketToServer = new DataOutputStream(socket.getOutputStream());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String clientInput = "";
        String serverSaid = "";

        while(!clientInput.equalsIgnoreCase("stop")) {
            clientInput = reader.readLine();
            outputFromSocketToServer.writeUTF(clientInput);
            outputFromSocketToServer.flush();

            serverSaid = inputInSocket.readUTF();
            System.out.println("SERVER: " + serverSaid);

        }
        reader.close();
        socket.close();
    }
}
