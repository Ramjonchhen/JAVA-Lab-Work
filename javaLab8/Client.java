package javaLab8;

import java.rmi.registry.*;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(9000);
            AreaRemoteInterface area = (AreaRemoteInterface) registry.lookup("area");
            double areaOfCircle = area.areaOfCircle(2.5);
            System.out.println("Area of circle is: " + areaOfCircle);
            
            double areaOfRect = area.areaofRectangle(2.5,3.5);
            System.out.println("Area of rectangle is: " + areaOfRect);

            double areaOfSphere = area.areaOfSphere(3.7);
            System.out.println("Area of sphere is: " + areaOfSphere);

        } catch (Exception e) {
            System.out.println("exception in client is: "+e);
        }
    }
}
