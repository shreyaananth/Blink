import java.io.*;  
import java.net.*;  
import java.util.logging.Level;
import java.util.logging.Logger;

public class server {  
    public static void establish(){
        try {
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept();//establishes connection
            ObjectInputStream dis=new ObjectInputStream(s.getInputStream());
            
        
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
}
