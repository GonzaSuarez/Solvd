package com.solvd.bank.transactions;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.exceptions.NullCurrencyException;
import com.solvd.bank.exceptions.UnpayableTransactionException;
import com.solvd.bank.paymethods.Currency;

import java.util.ArrayList;
import java.util.List;

public class Deposit extends Transaction {


    public Deposit() {
    }

    public Deposit(Currency currency) {
        super(currency);
    }

    @Override
    public boolean transact(Account account, float tax){
        List<Currency> accountCurrencies = new ArrayList<>();
        try {
            accountCurrencies = account.getCurrencies();
        } catch (NullCurrencyException e) {
            logger.error("There are no currencies related to this client");
        }
        if(accountCurrencies.contains(this.currency)){
            int accountCurrencyIndex = accountCurrencies.indexOf(this.currency);
            accountCurrencies.get(accountCurrencyIndex).setAmmount(accountCurrencies.get(accountCurrencyIndex).getAmmount() + this.currency.getAmmount() - tax);
            return true;
        }
        else {
            return account.addCurrency(this.currency);
        }
    }
}
