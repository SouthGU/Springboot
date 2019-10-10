package demo06_Redis;

public class User implements java.io.Serializable{
    String uid;
    String username;
    String password;
    public User(){super();}
    public User(String uid,String username,String password){
        super();
        this.uid=uid;
        username=username;
        password=password;
    }

    public String getUid() {
        return uid;
    }
}
