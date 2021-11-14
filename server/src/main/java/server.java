import java.io.*;  
import java.net.*;  
import java.util.logging.Level;
import java.util.logging.Logger;

public class server {  
    static ObjectInputStream dis;
    static ObjectOutputStream dout;
    public static void establish(){
        try {
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept();//establishes connection
            dout=new ObjectOutputStream(s.getOutputStream());
            dis=new ObjectInputStream(s.getInputStream());
            try {
                message m = (message)dis.readObject();
                System.out.println("Message:\n\tFrom: " + m.fromid + "\n\tTo: " + m.toid + "\n\tMessage id: " + m.uid + "\n\tMessage: " + m.mes);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
    
    public static void main(String[] args){
        establish();
    }
}
