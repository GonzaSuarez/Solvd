package com.solvd.booking.hotel;

import com.solvd.booking.travelcompany.UserAccount;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name= "user")
public class User {

    @XmlAttribute(name="id")
    private int id;
    @XmlElement(name= "first_name")
    private String firstName;
    @XmlElement(name= "last_name")
    private String lastName;
    @XmlElement(name= "email")
    private String email;
    @XmlElement(name= "address")
    private String address;
    @XmlElement(name= "phone")
    private int phone;
    @XmlElement(name= "details")
    private String details;
    @XmlElement(name = "accounts")
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
