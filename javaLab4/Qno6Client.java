package javaLab4;

import java.net.*;
import java.io.*;
import java.util.*;

public class Qno6Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 1234);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            System.out.println("Enter the radius to send to server: ");
            Scanner scanner = new Scanner(System.in);
            double radius = scanner.nextDouble();
            dos.writeDouble(radius);
            
            double areaOfCircle = dis.readDouble();
            System.out.println("area of circle from the server is:"+areaOfCircle);
           
            scanner.close(); dos.flush(); dos.close();
            dis.close();s.close();
        } catch (Exception e) {
            System.out.println("Error in the client is: " + e);
        }
    }
}
