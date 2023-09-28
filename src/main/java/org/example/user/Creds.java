package org.example.user;

public class Creds {
    private String email;
    private String password;

    public Creds() {
    }

    public  Creds(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public static Creds from(FullUser fullUser) {
        Creds c = new Creds();
        c.setEmail(fullUser.getEmail());
        c.setPassword(fullUser.getPassword());
        return c;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
