package info.rekayasa.nyantai.models;

/**
 * Created by rachmadi on 4/17/17. POJO = Plain Old Java Object
 */

public class User {

    public String email;
    public String displayName;

    public User() {
    }

    public User(String email, String displayName) {
        this.email = email;
        this.displayName = displayName;
    }
}
