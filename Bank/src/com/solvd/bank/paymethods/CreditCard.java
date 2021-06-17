package com.solvd.bank.paymethods;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.transactions.Transference;

public class CreditCard {

    private String name;
    private long number;
    private double limit;

    public CreditCard(){}

    public CreditCard(String name, long number, double limit) {
        this.name = name;
        this.number = number;
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public boolean pay(Transference transference, Account account){
        if(transference.getCurrency().getAmmount() < this.limit){
            int tax = 0;
            this.setLimit(this.getLimit() - transference.getCurrency().getAmmount());
            return transference.transact(account,tax);
        }
        return false;
    }
}
