package org.example.user;

public class EditUser {
    private String email;
    private String name;

    public EditUser() {
    }

    public  EditUser(String email, String name) {
        this.email = email;
        this.name = name;
    }
    public static EditUser from(FullUser fullUser) {
        EditUser e = new EditUser();
        e.setEmail(fullUser.getEmail());
        e.setName(fullUser.getName());
        return e;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
