package task011.models;

/**
 * Created by Denis on 28.12.15.
 */
public class User {

    private String login;
    private String password;
    private String email;
    private String type;
    private boolean guest;

    public User(String login, String email, String password, String type) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login) {
        this.login = login;
        this.guest = true;
    }

    public String getLogin() { return login; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getType() { return type; }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isGuest() {
        return guest;
    }
}
