package com.solvd.bank.transactions;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.exceptions.NullCurrencyException;
import com.solvd.bank.exceptions.UnpayableTransactionException;
import com.solvd.bank.paymethods.Currency;

import java.util.*;


public class CurrencyExchange extends Transaction {

    private Currency newCurrency;

    public CurrencyExchange() {
    }

    public CurrencyExchange(Currency currency,Currency newCurrency) {
        super(currency);
        this.newCurrency = newCurrency;
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
        try {
            if (accountCurrencies.get(currency.getName()).getAmmount() > currency.getAmmount()) {
                Set<String> currenciesSet = accountCurrencies.keySet();
                if (currenciesSet.contains(this.newCurrency)) {
                    currency.setAmmount(newCurrency.getAmmount());
                    accountCurrencies.get(newCurrency.getName()).setAmmount(accountCurrencies.get(newCurrency.getName()).getAmmount() + newCurrency.getAmmount());
                } else {
                    account.addCurrency(newCurrency);
                }
                accountCurrencies.get(this.currency.getName()).setAmmount(accountCurrencies.get(this.currency.getName()).getAmmount() - currency.getAmmount());
            }
            else {
                throw new UnpayableTransactionException("There are no enough " + currency.getName() + " to complete the transacction");
            }
        }
        catch (UnpayableTransactionException e){
            logger.error(e);
        }

        return true;
    }
}
