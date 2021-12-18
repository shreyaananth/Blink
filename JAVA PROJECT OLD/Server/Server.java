import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;  
public class Server implements Runnable{
    static ServerSocket k;
    static Socket a;
    static int c = 0;
    static Connection con;
    static Statement stmt;
    
    
    public static void sersend(Socket a){
        try { 
            ObjectOutputStream h = new ObjectOutputStream(a.getOutputStream());
            String t = "hello client\n";
            mes m = new mes(t,null);
            h.writeObject(m);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void serrec(Socket a){
        try {
            //System.out.println("Client " + c + ": " + a.toString());
            ObjectInputStream d = new ObjectInputStream(a.getInputStream());
                mes m = (mes)d.readObject();
                
                //System.out.println(m.r + " message: " + m.t);
                sersend(a);
                a.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){

        try {
            k = new ServerSocket(43580);
            try {  
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Server","root","shreya@02");
                stmt = con.createStatement();
                
            } catch (SQLException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(true){
                a = k.accept();
                System.out.println(a);
                Server t = new Server();
                Thread thread = new Thread(t);
                c++;
                thread.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        
    }
    
    @Override
    public void run(){
        serrec(a);
    }
}
/*
CREATE TABLE `Server`.`Users` ( `user_id` BIGINT NOT NULL AUTO_INCREMENT ,  `email_id` VARCHAR(100) NOT NULL ,  `status` INT(1) NOT NULL ,    PRIMARY KEY  (`user_id`),    UNIQUE  `unique_email` (`email_id`)) ENGINE = InnoDB;
ALTER TABLE `Users` CHANGE `status` `status` INT NOT NULL DEFAULT '0';
CREATE TABLE `Server`.`message_outbox` ( `id` BIGINT NOT NULL AUTO_INCREMENT ,  `from_emailid` VARCHAR(100) NOT NULL ,  `dt` DATETIME NOT NULL ,  `mes` LONGTEXT NOT NULL ,  `send_mesid` BIGINT NOT NULL ,    PRIMARY KEY  (`id`)) ENGINE = InnoDB;
*/


/*
java -cp .:/Users/shreyaananth/"Documents – Shreya’s MacBook Air"/mysql-connector-java-8.0.27/mysql-connector-java-8.0.27.jar Server
*/
