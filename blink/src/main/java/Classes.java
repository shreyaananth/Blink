import java.io.Serializable;
class message implements Serializable{
    long uid;
    String fromid, toid, mes;
}

class signal_out implements Serializable{
    long uid;
    String toid;
    int sig;
}

class signal_in implements Serializable{
    long uid;
    int sig;
}

