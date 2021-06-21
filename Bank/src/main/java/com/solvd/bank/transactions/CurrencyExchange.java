package com.solvd.bank.transactions;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.exceptions.NullCurrencyException;
import com.solvd.bank.exceptions.UnpayableTransactionException;
import com.solvd.bank.paymethods.Currency;

import java.util.ArrayList;
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
    public boolean transact(Account account, float tax){
        List<Currency> accountCurrencies = new ArrayList<>();
        try {
            accountCurrencies = account.getCurrencies();
        } catch (NullCurrencyException e) {
            logger.error("There are no currencies related to this client");
        }
        int paymentCurrencyIndex = accountCurrencies.indexOf(currency);
        try {
            if (accountCurrencies.get(paymentCurrencyIndex).getAmmount() > currency.getAmmount()) {
                if (accountCurrencies.contains(this.newCurrency)) {
                    currency.setAmmount(newCurrency.getAmmount());
                    int newCurrencyIndex = accountCurrencies.indexOf(newCurrency);
                    accountCurrencies.get(newCurrencyIndex).setAmmount(accountCurrencies.get(newCurrencyIndex).getAmmount() + newCurrency.getAmmount());
                } else {
                    account.addCurrency(newCurrency);
                }
                accountCurrencies.get(paymentCurrencyIndex).setAmmount(accountCurrencies.get(paymentCurrencyIndex).getAmmount() - currency.getAmmount());
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
