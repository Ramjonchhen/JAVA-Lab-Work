package javaLab8;

import java.rmi.registry.*;

public class Server {
    public static void main(String[] args) {
        try {
            AreaRemoteClass obj = new AreaRemoteClass();
            Registry registry = LocateRegistry.createRegistry(9000);
            registry.rebind("area",obj);
            System.out.println("Server is ready");         

        } catch (Exception e) {
            System.out.println("exception in server is: "+e);
        }

    }
}

