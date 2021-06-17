package com.solvd.bank.people;

import com.solvd.bank.accounts.Account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client extends Person{

    private List<Account> accounts;

    public Client(){}

    public Client(String name, String lastName, int id, Date birthDate) {
        super(name, lastName, id, birthDate);
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean addAccount(Account account){
        return this.accounts.add(account);
    }

    public boolean removeAccount(Account account){
        if(this.accounts.contains(account)){
            return this.accounts.remove(account);
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = 1;
        result = (prime * result) + ((this.name == null) ? 0 : this.name.hashCode());
        result = (prime * result) + ((this.lastName == null) ? 0 : this.lastName.hashCode());
        result = (prime * result) + (int)this.id;
        result = (prime * result) + ((this.birthDate == null) ? 0 : this.birthDate.hashCode());
        result = (prime * result) + ((this.accounts == null) ? 0 : this.accounts.hashCode());
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
                this.birthDate.equals(client.getBirthDate()) &&
                this.accounts.equals(client.getAccounts());
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "," + " Lastname: " + this.lastName + ","  + " ID: " + this.id + "," + " Birthdate: " + this.birthDate;
    }
}
