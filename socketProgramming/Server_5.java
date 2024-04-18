import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_5 {

    // public static String Palindrome(String s){

    //     String temp = s;

    //     String compare = "";

    //     for(int i=s.length()-1;i>=0;i--){
    //         compare += s.charAt(i);
    //     }

    //     if(compare.equals(temp)){
    //         return "String is Palindrome";
    //     }

    //     return "Not a Palindrome String";
    // }

    public static String Comapre(String s1,String s2){
        if(s1.equals(s2)){
            return "Both the String is Equal";
        }

        return "Both the Strings are not equal";
    }

    public static void main(String[] args) {
        try {
            
            ServerSocket sc = new ServerSocket(4000);

            System.out.println("Waiting for Client");

            Socket clientServer = sc.accept();

            System.out.println("Connection Established");

            // Get message from client

            // DataInputStream getMsg = new DataInputStream(clientServer.getInputStream());
            // String message = getMsg.readUTF();

            // String result = Palindrome(message);

            // Send back the response to the client
            // DataOutputStream sendResult = new DataOutputStream(clientServer.getOutputStream());
            // sendResult.writeUTF(result);


            // String Comparision

            // Get message from client

            DataInputStream getMsg = new DataInputStream(clientServer.getInputStream());
            String message1 = getMsg.readUTF();
            String message2 = getMsg.readUTF();

            String result = Comapre(message1, message2);

            // Send back the response to the client

            DataOutputStream sendResult = new DataOutputStream(clientServer.getOutputStream());
            sendResult.writeUTF(result);

            sc.close();
            clientServer.close();

        } catch (Exception e) {
            
            System.out.println(e);

        }
    }
}
