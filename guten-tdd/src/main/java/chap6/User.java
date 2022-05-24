package chap6;

/**
 * @author gutenlee
 * @since 2022/05/25
 */
public class User {

    private String id;
    private String pw;
    private String email;

    public User(String id, String pw1, String s) {
        this.id = id;
        this.pw = pw1;
        this.email = s;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getEmail() {
        return email;
    }
}
