package org.example.user;

public class UserChangeRespons {

    private boolean success;
    private User user;

    public UserChangeRespons() {
    }

    public UserChangeRespons(boolean success, User user) {
        this.success = success;
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public User getUserFieldResponse() {
        return user;
    }

    public void setUserFieldResponse(User user) {
        this.user = user;
    }
}
