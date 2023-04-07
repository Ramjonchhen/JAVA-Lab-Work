import java.net.*;
import java.io.*;

public class Qno3Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            
            System.out.println("Server Listening!!!");
            double clientRadius = dis.readDouble();
            double areaOfCircle = Math.PI
                    * clientRadius * clientRadius;

            dos.writeDouble(areaOfCircle);

            dis.close();
            dos.flush();
            dos.close();
            ss.close();
        } catch (Exception e) {
            System.out.println("Error in the server is: " + e);
        }
    }
}