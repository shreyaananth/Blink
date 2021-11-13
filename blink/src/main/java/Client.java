import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Client {
    public static void main(String[] args){
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection c = DriverManager.getConnection("jdbc:sqlite:client.db");
            System.out.println("test");
            System.out.println("test23");
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Opened database successfully");
    }
}
