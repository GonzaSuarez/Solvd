package com.solvd.bank.accounts;

import com.solvd.bank.people.Client;
import com.solvd.bank.transactions.Transaction;
import com.solvd.bank.paymethods.Currency;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    protected Client owner;
    protected long cbu;
    protected List<Currency> balances;
    protected List<Transaction> transactionsRegister;

    public Account(){
        this.transactionsRegister = new ArrayList<>();
    }

    public Account(Client owner, long cbu) {
        this.owner = owner;
        this.cbu = cbu;
        this.balances = new ArrayList<>();
        this.transactionsRegister = new ArrayList<>();
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public List<Currency> getCurrencies() {
        return balances;
    }

    public void setCurrencies(List<Currency> balances) {
        this.balances = balances;
    }

    public long getCbu() {
        return cbu;
    }

    public void setCbu(int cbu) {
        this.cbu = cbu;
    }

    public List<Transaction> getTransactionsRegister() {
        return transactionsRegister;
    }

    public void setTransactionsRegister(List<Transaction> transactionsRegister) {
        this.transactionsRegister = transactionsRegister;
    }

    public boolean addCurrency(Currency currency){
        return this.balances.add(currency);
    }

    public abstract boolean transact(Transaction transaction, Account account);
}
