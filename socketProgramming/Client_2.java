import java.io.DataOutputStream;
import java.net.Socket;

public class Client_2 {
    public static void main(String[] args) {
        try {

            Socket clientServer = new Socket("localhost",4000);

            DataOutputStream sendMessage = new DataOutputStream(clientServer.getOutputStream());
            sendMessage.writeUTF("Hi I am Client and I am Sending message to the Server");

            clientServer.close();
            
        } catch (Exception e) {
            System.out.println("Unable to established the connection");
        }
    }
}
