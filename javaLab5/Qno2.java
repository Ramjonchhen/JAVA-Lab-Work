import java.net.*;

public class Qno2 {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("www.google.com");
            System.out.println("Host Name is: "+ip.getHostName());
            System.out.println("Host Address is: "+ip.getHostAddress());
        } catch (Exception e) {
            System.out.println("Error is: "+e);
        }
    }
}