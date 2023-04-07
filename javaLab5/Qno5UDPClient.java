import java.net.*;

public class Qno5UDPClient {
    public static void main(String[] args) {
        try { 
            // Create Datagram Socket Object
            DatagramSocket socket = new DatagramSocket();

            byte[] bytes = new byte[256];
            bytes = "Hello from the UDP Client!!!".getBytes();
            InetAddress address = InetAddress.getByName("localhost");

            // send request to the server
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 6969);
            socket.send(packet);

            // receive response from the server
            socket.receive(packet);

            // display response 
            String received = new String(packet.getData());
            System.out.println("Response from the UDP Server is: "+received);

            socket.close();
        } catch (Exception e) {
            System.out.println("Error on the UDP Client is: "+e);
        }
    }
}
