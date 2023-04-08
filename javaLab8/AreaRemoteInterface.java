package javaLab8;

import java.rmi.*;

public interface AreaRemoteInterface extends Remote{
    double areaOfCircle(double radius) throws RemoteException;
    double areaofRectangle(double length, double breadth) throws RemoteException;
    double areaOfSphere(double radius) throws RemoteException;
}
