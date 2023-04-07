package javaLab4;

import java.io.*;
import java.net.*;

class ClientHandler extends Thread {
    Socket clientSocket;
    DataInputStream dis = null; DataOutputStream dos = null;

    ClientHandler(Socket s) {
        this.clientSocket = s;
    }

    public void run() {
        try {
            dis = new DataInputStream(this.clientSocket.getInputStream());
            dos = new DataOutputStream(this.clientSocket.getOutputStream());

            double clientRadius = dis.readDouble();
            System.out.println("Radius Recieved from the client is: " + clientRadius);
            double areaOfCircle = Math.PI
                    * clientRadius * clientRadius;

            dos.writeDouble(areaOfCircle);

        } catch (Exception e) {
            System.out.println("Error in the client handler is: " + e);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
                if (dis != null) {
                    dis.close();
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Qno6Server {
    public static void main(String[] args) {
        ServerSocket server = null;

        try {
            // server is listening on port 1234
            server = new ServerSocket(1234);
            server.setReuseAddress(true);

            // running infinite loop for getting client request
            System.out.println("Server Listening!!!");
            while (true) {
                // socket object to receive incoming client requests
                Socket client = server.accept();

                // Displaying that new client is connected to server
                System.out.println("New client connected: "
                        + client.getInetAddress()
                                .getHostAddress());

                // create a new thread object
                ClientHandler clientSock = new ClientHandler(client);

                // This thread will handle the client separately
                clientSock.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in The Server Main Class: " + e);
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
