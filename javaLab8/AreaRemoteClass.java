package javaLab8;

import java.rmi.*;
import java.rmi.server.*;

public class AreaRemoteClass extends UnicastRemoteObject implements AreaRemoteInterface {
    public AreaRemoteClass() throws RemoteException{
        super();
    }

    public double areaOfCircle(double radius) {
        return Math.PI * radius * radius;
    }

    public double areaofRectangle(double length, double breadth) {
        return length * breadth;
    }

    public double areaOfSphere(double radius) {
        return 4 * Math.PI * radius * radius;
    } 
}
