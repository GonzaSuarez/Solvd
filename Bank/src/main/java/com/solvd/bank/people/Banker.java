package com.solvd.bank.people;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.enums.WorkPosition;
import com.solvd.bank.exceptions.NullAccountsException;

import java.util.Date;

public class Banker extends Person{

    private WorkPosition workPosition;

    public Banker() {}

    public Banker(String name, String lastName, int id, WorkPosition workPosition) {
        super(name, lastName, id);
        this.workPosition = workPosition;
    }

    public void openAccount(Client client, Account account){
        client.addAccount(account);
    }

    public void closeAccount(Client client, Account account){
        try {
            client.removeAccount(account);
        } catch (NullAccountsException e) {
            logger.error("There are no accounts related to this client");
        }
    }

    public WorkPosition getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(WorkPosition workPosition) {
        this.workPosition = workPosition;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = 1;
        result = (prime * result) + ((this.name == null) ? 0 : this.name.hashCode());
        result = (prime * result) + ((this.lastName == null) ? 0 : this.lastName.hashCode());
        result = (prime * result) + (int)this.id;
        result = (prime * result) + ((this.birthDate == null) ? 0 : this.birthDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return this.id == client.getId() &&
                this.name.equals(client.name) &&
                this.lastName.equals(client.lastName) &&
                this.birthDate.equals(client.getBirthDate());
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "," + " Lastname: " + this.lastName + ","  + " ID: " + this.id + "," + " Birthdate: " + this.birthDate;
    }
}
