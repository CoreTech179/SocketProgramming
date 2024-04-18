import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            
            Socket clientServer = new Socket("localhost",4000);

            DataOutputStream sendMessage = new DataOutputStream(clientServer.getOutputStream());

            System.out.println("Enter a number for factorial:");
            String number = sc.nextLine();

            sendMessage.writeUTF(number);

            // get response from the server

            DataInputStream getResult = new DataInputStream(clientServer.getInputStream());
            String displayResult = getResult.readUTF();
            System.out.println("factorial is = "+displayResult);

            clientServer.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
