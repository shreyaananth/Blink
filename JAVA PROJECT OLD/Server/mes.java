import java.io.*;
import java.lang.String;

public class mes implements Serializable{
    String from;
    String to;
    String mes;
    int mesid;
    
    public mes(String t1, String r1){
        from = t1; 
        mes = r1;
    }

}

