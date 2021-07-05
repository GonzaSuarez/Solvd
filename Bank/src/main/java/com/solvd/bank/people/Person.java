package com.solvd.bank.people;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.enums.Sex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public abstract class Person {

    protected String name;
    protected String lastName;
    protected long id;
    protected Date birthDate;
    protected Logger logger = LogManager.getLogger(Account.class);
    private Sex sex;

    public Person(){}

    public Person(String name, String lastName, long id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
