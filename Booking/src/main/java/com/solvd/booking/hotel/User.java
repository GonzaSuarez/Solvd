package com.solvd.booking.hotel;

import com.solvd.booking.travelcompany.UserAccount;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private int phone;
    private String details;
    private List<UserAccount> accounts;

    public User() {
    }

    public User(int id, String firstName, String email) {
        this.firstName = firstName;
        this.id = id;
        this.email = email;
        this.accounts = new ArrayList<>();
    }

    public List<UserAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<UserAccount> accounts) {
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
