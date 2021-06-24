package com.solvd.bank.transactions;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.exceptions.NullCurrencyException;
import com.solvd.bank.exceptions.UnpayableTransactionException;
import com.solvd.bank.paymethods.Currency;

import java.util.*;

public class Deposit extends Transaction {


    public Deposit() {
    }

    public Deposit(Currency currency) {
        super(currency);
    }

    @Override
    public boolean transact(Account account, float tax){
        Map<String, Currency> accountCurrencies = new HashMap<>();
        try {
            if(account.getCurrencies()!=null){
                accountCurrencies = account.getCurrencies();
            }
            else {
                throw new NullCurrencyException("There are no currencies related to this client");
            }
        } catch (NullCurrencyException e) {
            logger.error("There are no currencies related to this client");
        }
        Set<String> currenciesSet = accountCurrencies.keySet();
        if(currenciesSet.contains(this.currency)){
            accountCurrencies.get(this.currency.getName()).setAmmount(accountCurrencies.get(this.currency.getName()).getAmmount() + this.currency.getAmmount() - tax);
        }
        else {
            account.addCurrency(this.currency);
        }
        return true;
    }
}
