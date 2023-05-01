package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        int client = 0;
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted " + (++client));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String request = reader.readLine();
            String response = client +  ", your message length is " + request.length() + "\n";
            writer.write(response);
            writer.flush();
            reader.close();
            writer.close();


            clientSocket.close();
        }
        //serverSocket.close();
    }
}
