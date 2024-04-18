
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientServer = new Socket("localhost",3000);

            clientServer.close();
            
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            System.out.println("Unable to Established the Connection");
        }
    }
}
