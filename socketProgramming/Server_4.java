import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_4 {
    public static void main(String[] args) {
        try {
            ServerSocket sc = new ServerSocket(5000);

            System.out.println("Waiting for Client");

            Socket clientServer = sc.accept();

            System.out.println("Connection Established");

            DataInputStream getString = new DataInputStream(clientServer.getInputStream());
            String stringLen = getString.readUTF();

            System.out.println("Length of the String is = "+stringLen.length());

            sc.close();

            clientServer.close();
            
        } catch (Exception e) {

            System.out.println("Connection Refused!!");

        }
    }
}
