package com.solvd.booking.travelcompany;

public class UserAccount {

    private String firstName;
    private String lastName;
    private String email;
    private String user;
    private String password;


    public UserAccount() {
    }

    public UserAccount(String email, String user, String password) {
        this.email = email;
        this.user = user;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
