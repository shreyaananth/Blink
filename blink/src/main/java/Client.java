import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Client {
    public static void creation(){
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection c = DriverManager.getConnection("jdbc:sqlite:client.db");
            Statement stmt = c.createStatement();
            String messages = "CREATE TABLE \"messages\" (\n" +
                              "	\"uid\"	INTEGER,\n" +
                              "	\"toid\"	TEXT,\n" +
                              "	\"mes\"	TEXT,\n" +
                              "	\"mes_date\"	TEXT,\n" +
                              "	\"status\"	INTEGER,\n" +
                              "	PRIMARY KEY(\"uid\" AUTOINCREMENT)\n" +
                              ")";
            
            String signal_inbox = "CREATE TABLE \"signal_inbox\" (\n" +
                                   "	\"sno\"	INTEGER,\n" +
                                   "	\"uid\"	INTEGER,\n" +
                                   "	\"sig\"	INTEGER,\n" +
                                   "	PRIMARY KEY(\"sno\" AUTOINCREMENT),\n" +
                                   "	UNIQUE(\"uid\",\"sig\")\n" +
                                   ")";
            String signal_outbox = "CREATE TABLE \"signal_outbox\" (\n" +
                                   "	\"sno\"	INTEGER,\n" +
                                   "	\"uid\"	INTEGER,\n" +
                                   "	\"toid\"	TEXT,\n" +
                                   "	\"sig\"	INTEGER,\n" +
                                   "	PRIMARY KEY(\"sno\" AUTOINCREMENT),\n" +
                                   "	UNIQUE(\"uid\",\"toid\",\"sig\")\n" +
                                   ")";
            stmt.executeUpdate(messages);
            stmt.executeUpdate(signal_inbox);
            stmt.executeUpdate(signal_outbox);
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void connect(){
        
    }
    
     public static void main(String[] args){
         creation();
     }
}
