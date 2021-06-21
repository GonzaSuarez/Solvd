package com.solvd.bank.paymethods;

import com.solvd.bank.accounts.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Currency{

    private String name;
    private double ammount;
    private Logger logger = LogManager.getLogger(Account.class);

    public Currency() {}

    public Currency(String name, float ammount) {
        this.ammount = ammount;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmmount(){
        return this.ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = 1;
        result = (prime * result) + ((this.name == null) ? 0 : this.name.hashCode());
        result = (prime * result) + ((int) ammount);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Currency currency = (Currency)obj;
        return this.name.equals(currency.name);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Ammount: " + this.ammount;
    }
}
