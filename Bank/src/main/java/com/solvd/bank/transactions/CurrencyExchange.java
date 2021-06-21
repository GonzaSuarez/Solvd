package com.solvd.bank.transactions;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.paymethods.Currency;

import java.util.List;


public class CurrencyExchange extends Transaction {

    private Currency newCurrency;

    public CurrencyExchange() {
    }

    public CurrencyExchange(Currency currency,Currency newCurrency) {
        super(currency);
        this.newCurrency = newCurrency;
    }

    @Override
    public boolean transact(Account account, float tax) {
        List<Currency> accountCurrencies = account.getCurrencies();
        int paymentCurrencyIndex = accountCurrencies.indexOf(currency);
        if(accountCurrencies.contains(this.newCurrency)){
            currency.setAmmount(newCurrency.getAmmount());
            int newCurrencyIndex = accountCurrencies.indexOf(newCurrency);
            accountCurrencies.get(newCurrencyIndex).setAmmount(accountCurrencies.get(newCurrencyIndex).getAmmount() + newCurrency.getAmmount());
        }
        else{
            account.addCurrency(newCurrency);
        }
        accountCurrencies.get(paymentCurrencyIndex).setAmmount(accountCurrencies.get(paymentCurrencyIndex).getAmmount() - currency.getAmmount());
        return true;
    }
}
