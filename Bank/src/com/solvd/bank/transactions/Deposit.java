package com.solvd.bank.transactions;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.paymethods.Currency;

import java.util.List;

public class Deposit extends Transaction {


    public Deposit() {
    }

    public Deposit(Currency currency) {
        super(currency);
    }

    @Override
    public boolean transact(Account account, float tax) {
        List<Currency> accountCurrencies = account.getCurrencies();
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
