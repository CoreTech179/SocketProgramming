
import java.net.ServerSocket;

public class Server{
    public static void main(String[] args) {
        try {
            
            ServerSocket serverSocket = new ServerSocket(3000);
            System.out.println("Server is Running...");
            System.out.println("Waiting for Client....");

            serverSocket.accept();
            System.out.println("Connection Established");
            serverSocket.close();

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            System.out.println("Connection Refused!");
        }
    }
}