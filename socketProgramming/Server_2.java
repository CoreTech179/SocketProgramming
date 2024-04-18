import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_2 {
    public static void main(String[] args) {
        
        try {
            ServerSocket sc = new ServerSocket(4000);

            System.out.println("Waiting for Client");

            Socket clientServer = sc.accept();

            System.out.println("Connection Established");

            DataInputStream gettingInput = new DataInputStream(clientServer.getInputStream());
            String displayMessage = gettingInput.readUTF();
            System.out.println("Message Received from Client is = "+" "+displayMessage);

            sc.close();
            clientServer.close();
            
        } catch (Exception e) {
            System.out.println("Connection Refused!!");
        }
    }
}
