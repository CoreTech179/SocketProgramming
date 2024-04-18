import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server_3 {
    public static void main(String[] args) {
        try {
            ServerSocket sc = new ServerSocket(4000);

            System.out.println("Waiting for Client");

            Socket clientServer = sc.accept();

            System.out.println("Connection Established");

            // Here we are receiving the message from the client site
            DataInputStream gettingInput = new DataInputStream(clientServer.getInputStream());

            String displayMessage = gettingInput.readUTF();

            // Display Client site Message
            System.out.println("Client Message is = "+" "+displayMessage);

            // Sending message to the client Side that what is the time write now
            DataOutputStream sendMessage = new DataOutputStream(clientServer.getOutputStream());

            sendMessage.writeUTF("Time Write Now is = "+" "+new Date().toString()) ;

            sc.close();

            clientServer.close();
            
        } catch (Exception e) {

            System.out.println("Connection Refused!!");

        }
    }
}
