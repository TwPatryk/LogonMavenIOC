package root.model;

public class User {
    private String login;
    private String pass;


    public User (String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }
    public String getPass() {
        return pass;
    }
    public void setLogin() {
        this.login = login;
    }
    public void setPass() {
        this.pass = pass;
    }
}
