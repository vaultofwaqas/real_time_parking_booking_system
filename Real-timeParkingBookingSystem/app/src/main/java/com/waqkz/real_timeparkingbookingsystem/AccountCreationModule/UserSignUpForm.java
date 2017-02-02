package com.waqkz.real_timeparkingbookingsystem.AccountCreationModule;

/**
 * Created by waqkz on 1/27/17.
 */

public class UserSignUpForm {

    private String userUUID;
    private String username;
    private String userFullName;
    private String userEmail;
    private String userPassword;

    public UserSignUpForm() {
    }

    public UserSignUpForm(String userUUID,
                          String username,
                          String userFullName,
                          String userEmail,
                          String userPassword) {

        this.userUUID = userUUID;
        this.username = username;
        this.userFullName = userFullName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
