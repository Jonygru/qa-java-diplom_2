package org.example.user;

public class ResponsServerWithSuccessAutorization {
private boolean success;
private  String accessToken;
private  String refreshToken;
private User user;

    public ResponsServerWithSuccessAutorization() {
    }

    public ResponsServerWithSuccessAutorization(boolean success, String accessToken, String refreshToken, User user) {
        this.success = success;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public User getUserFieldResponse() {
        return user;
    }

    public void setUserFieldResponse(User user) {
        this.user = user;
    }
}
