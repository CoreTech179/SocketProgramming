import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_4 {
    public static void main(String[] args) {

        
        try {
            Scanner sc = new Scanner(System.in);
    
            System.out.print("Enter any String:");
            String s1 = sc.nextLine();

            Socket clientServer = new Socket("localhost",5000);

            DataOutputStream sendMessage = new DataOutputStream(clientServer.getOutputStream());
            sendMessage.writeUTF(s1);

            clientServer.close();
            sc.close();
            
        } catch (Exception e) {

            System.out.println("Unable to established the connection");

        }

    }
}
