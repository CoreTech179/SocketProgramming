import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    public static void main(String[] args) {
        try {
            
            Socket clientServer = new Socket("localhost",6000);

            String exit = "bye";

            Scanner sc = new Scanner(System.in);

            while(true){

                System.out.print("Enter any String (To exit write 'bye'):");
                String s1 = sc.nextLine();

                if(s1.equals(exit)){
                    break;
                }

                
                // Send some message to the Server Side
                DataOutputStream sendMessage = new DataOutputStream(clientServer.getOutputStream());
                sendMessage.writeUTF(s1);
                
                // Read Corrosponding Response from the Server Side and Display
                DataInputStream readResponse = new DataInputStream(clientServer.getInputStream());
                
                String read = readResponse.readUTF();
                
        
                if(read.equals(exit)){
                    break;
                }

                System.out.println(read);
            }

            clientServer.close();
            sc.close();

        }catch(EOFException e){

            System.out.println("Client Closed Successfully");

        } catch (Exception e) {

            System.out.println("Connection Refused!");

        }
    }
}
