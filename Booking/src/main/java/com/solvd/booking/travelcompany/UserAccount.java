package com.solvd.booking.travelcompany;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="useraccount")
public class UserAccount {

    @XmlAttribute(name="id")
    private int id;
    @XmlElement(name= "first_name")
    private String firstName;
    @XmlElement(name= "last_name")
    private String lastName;
    @XmlElement(name= "email")
    private String email;
    @XmlElement(name= "user")
    private String user;
    @XmlElement(name= "password")
    private String password;
    @XmlElement(name= "idcompany")
    private int idCompany;


    public UserAccount() {
    }

    public UserAccount(int id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
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

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }
}
