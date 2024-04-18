import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat {
    public static void main(String[] args) {
        
        try {

            Scanner s = new Scanner(System.in);
            
            ServerSocket sc = new ServerSocket(6000);

            System.out.println("Waiting for Client");

            Socket clientServer = sc.accept();

            System.out.println("Connection Established");

            String s2 = "bye";

            while(true){

                // read message from the Client Side
                DataInputStream readMessage = new DataInputStream(clientServer.getInputStream());
                String message = readMessage.readUTF();
                
                if(message.equals(s2)){
                    break;
                }

                System.out.println(message);

                // Send Corrosponding Response to the Client side
                DataOutputStream sendResponse = new DataOutputStream(clientServer.getOutputStream());

                System.out.print("Enter any Response:");
                
                String response = s.nextLine();

                sendResponse.writeUTF(response);

            }
            
            clientServer.close();
            sc.close();
            s.close();

        }catch(EOFException e){

            System.out.println("Server Closed Successfully!");
            
        } catch (Exception e) {

            System.out.println(e);

        }
    }
}