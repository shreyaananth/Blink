import java.net.*;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    static Socket s;
    public static String p;
    
    public static void send(String t) {
        try {
            mes m = new mes(t,p);
            ObjectOutputStream d = new ObjectOutputStream(s.getOutputStream());  
            d.writeObject(m);
            rec();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void rec(){
        try {
            ObjectInputStream h = new ObjectInputStream(s.getInputStream());
            mes t = (mes)h.readObject();
           // System.out.println("Message: " + t.t);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void connect() {
        try {
            s = new Socket("192.168.1.10",43580);
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

