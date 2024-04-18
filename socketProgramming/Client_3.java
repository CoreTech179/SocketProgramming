import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client_3 {
    public static void main(String[] args) {
        try {

            Socket clientServer = new Socket("localhost",4000);

            // Here I am sending a meesage to the Server side as a String
            DataOutputStream sendMessage = new DataOutputStream(clientServer.getOutputStream());
            
            sendMessage.writeUTF("Server what is the Time right now ?");

            // Here we are receiving the Response from the Server Side
            DataInputStream gettingDate = new DataInputStream(clientServer.getInputStream());

            String showDate = gettingDate.readUTF();

            System.out.println("Response from Server Side......");

            System.out.println(showDate);

            clientServer.close();
            
        } catch (Exception e) {

            System.out.println("Unable to established the connection");

        }
    }
}
