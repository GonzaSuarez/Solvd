package com.solvd.bank.transactions;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.paymethods.Currency;

public abstract class Transaction {

    protected Currency currency;

    public Transaction(){}

    public Transaction(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public abstract boolean transact(Account account, float tax);
}
