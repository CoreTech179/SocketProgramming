import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_5 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        try {
            
            Socket clientServer = new Socket("localhost",4000);

            DataOutputStream sendMessage = new DataOutputStream(clientServer.getOutputStream());

            // System.out.print("Enter any String:");
            // String s1 = sc.nextLine();

            // Send a String to the Server
            // sendMessage.writeUTF(s1);

            // Get response from the server
            // DataInputStream getResult = new DataInputStream(clientServer.getInputStream());
            // String result = getResult.readUTF();

            // System.out.println(result);

            System.out.println("Enter 1st String:");
            String s1 = sc.nextLine();

            System.out.println("Enter 2nd String:");
            String s2 = sc.nextLine();

            // Sendig 2 Strings to the Server
            sendMessage.writeUTF(s1);
            sendMessage.writeUTF(s2);

            // Get response from the server
            DataInputStream getResult = new DataInputStream(clientServer.getInputStream());
            String displayResult = getResult.readUTF();
            System.out.println(displayResult);

            clientServer.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
