package com.solvd.bank.people;

import java.util.Date;

public abstract class Person {

    protected String name;
    protected String lastName;
    protected long id;
    protected Date birthDate;

    public Person(){}

    public Person(String name, String lastName, long id, Date birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.birthDate = birthDate;
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

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
