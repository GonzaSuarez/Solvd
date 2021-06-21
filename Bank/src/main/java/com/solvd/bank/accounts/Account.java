package com.solvd.bank.accounts;

import com.solvd.bank.exceptions.NullAccountsException;
import com.solvd.bank.exceptions.NullCurrencyException;
import com.solvd.bank.exceptions.NullOwnerException;
import com.solvd.bank.people.Client;
import com.solvd.bank.transactions.Transaction;
import com.solvd.bank.paymethods.Currency;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    protected Client owner;
    protected long cbu;
    protected List<Currency> balances;
    protected List<Transaction> transactionsRegister;
    protected Logger logger = LogManager.getLogger(Account.class);


    public Account(){
        this.transactionsRegister = new ArrayList();
    }

    public Account(Client owner, long cbu) {
        this.owner = owner;
        this.cbu = cbu;
        this.balances = new ArrayList();
        this.transactionsRegister = new ArrayList();
    }

    public Client getOwner() {
        try{
            if(this.owner != null){
                return owner;
            }
            else {
                throw new NullOwnerException("There isn't an owner set to the current account");
            }
        }
        catch (NullOwnerException e){
            logger.error(e);
        }
        return null;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public List<Currency> getCurrencies()throws NullCurrencyException {
        if(this.balances.isEmpty()){
            throw new NullCurrencyException("There are no currencies related to this account");
        }
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
