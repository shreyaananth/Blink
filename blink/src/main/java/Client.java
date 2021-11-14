import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;  
import java.net.*; 

public class Client {
    static Connection c;
    public static void database(){
        try {
            Class.forName("org.sqlite.JDBC");
            try {
                c = DriverManager.getConnection("jdbc:sqlite:client.db");
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void creation(){
        try {
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
    
    public static void send(String m, String r){
        try {
            Socket s=new Socket("localhost",6666);
            ObjectOutputStream dout=new ObjectOutputStream(s.getOutputStream());
            long uid = 0;
            
            try {
                Statement stmt = c.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            String insert = "INSERT INTO messages (toid, mes, status) values(\"" + r + "\",\"" + m + "\"," + 0 + ")";
            PreparedStatement prep = null;
            try {
                prep = c.prepareStatement(insert ,Statement.RETURN_GENERATED_KEYS);
                prep.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ResultSet result = prep.getGeneratedKeys();
                if(result.next())
                    uid = result.getLong(1);
                    
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            message t = new message();
            t.uid = uid;
            t.fromid = "test";
            t.toid = r;
            t.mes = m;
            
            dout.writeObject(t);
            dout.flush();
            dout.close();  
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
