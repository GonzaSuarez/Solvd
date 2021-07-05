package com.solvd.bank.paymethods;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.enums.CreditCardProvider;
import com.solvd.bank.transactions.Transference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreditCard {

    private CreditCardProvider name;
    private int number;
    private double limit;

    private Logger logger = LogManager.getLogger(Account.class);

    public CreditCard(){}

    public CreditCard(CreditCardProvider name, int number, double limit) {
        this.name = name;
        this.limit = limit;
        this.number = Integer.valueOf(String.valueOf(this.name.getHeadNumber()) + String.valueOf(number));
    }

    public String getName() {
        return name.getName();
    }

    public void setName(CreditCardProvider name) {
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
