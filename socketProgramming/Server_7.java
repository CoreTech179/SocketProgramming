import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_7 {

    public static int Factorial(int number){

        if(number==1){
            return 1;
        }

        return number * Factorial(number-1);
    }

    public static void main(String[] args) {
        try {
            
            ServerSocket sc = new ServerSocket(4000);

            System.out.println("Waiting for Client");

            Socket clientServer = sc.accept();

            System.out.println("Connection Established");

            // Get number from the Client
            DataInputStream getNumber = new DataInputStream(clientServer.getInputStream());
            String Stringnumber = getNumber.readUTF();

            int number = Integer.parseInt(Stringnumber);

            int result = Factorial(number);

            // converting integer type result to string 
            String finalResult = Integer.toString(result);

            // Send back response to the client

            DataOutputStream sendResult = new DataOutputStream(clientServer.getOutputStream());
            sendResult.writeUTF(finalResult);

            clientServer.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
