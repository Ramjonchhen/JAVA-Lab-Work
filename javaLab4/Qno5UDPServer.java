package javaLab4;

import java.net.*;

public class Qno5UDPServer {
    public static void main(String[] args) {
        try {
            // create datagram socket
            DatagramSocket socket = new DatagramSocket(6969);
            System.out.println("Server is listening on the port: "+socket.getPort());

            // Receive request from the client
            byte[] bytes = new byte[256];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            socket.receive(packet);

            String received = new String(packet.getData());
            System.out.println("Request from the UDP Client is: "+received);

            // prepare mesage for client
            InetAddress address = packet.getAddress();
            int port = packet.getPort();

            String s = "Hello from UDP Server!!!";
            bytes = s.getBytes();

            // sending the message to the client
            packet =  new DatagramPacket(bytes,bytes.length,address, port);
            socket.send(packet);
            
            socket.close();
        } catch (Exception e) {
            System.out.println("Error on the UDP Server is: "+e);
        }
    }
}

