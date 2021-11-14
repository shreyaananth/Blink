import java.io.Serializable;
class message implements Serializable{
    long uid;
    String fromid, toid, mes;
}

class message_out implements Serializable{
    long uid;
    String fromid, toid, mes;
    String date;
}

class signal_out implements Serializable{
    long uid;
    String toid, fromid;
    int sig;
}

class signal_in implements Serializable{
    long uid;
    int sig;
}

