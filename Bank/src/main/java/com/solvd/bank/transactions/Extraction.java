package com.solvd.bank.transactions;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.exceptions.NullCurrencyException;
import com.solvd.bank.exceptions.UnpayableTransactionException;
import com.solvd.bank.paymethods.Currency;

import java.util.ArrayList;
import java.util.List;

public class Extraction extends Transaction {

    public Extraction() {}

    public Extraction(Currency currency) {
        super(currency);
    }

    @Override
    public boolean transact(Account account, float tax){
        List<Currency> accountCurrencies = new ArrayList<>();
        try {
            accountCurrencies = account.getCurrencies();
        } catch (NullCurrencyException e) {
            e.printStackTrace();
        }
        int accountCurrencyIndex = accountCurrencies.indexOf(this.currency);
        if(accountCurrencies.contains(this.currency)){
            try {
                if (accountCurrencies.get(accountCurrencyIndex).getAmmount() > (this.currency.getAmmount() + tax)) {
                    accountCurrencies.get(accountCurrencyIndex).setAmmount(accountCurrencies.get(accountCurrencyIndex).getAmmount() - this.currency.getAmmount() - tax);
                    return true;
                } else {
                    throw new UnpayableTransactionException("There are no enough " + currency.getName() + " to complete the transacction");
                }
            }
            catch (UnpayableTransactionException e){
                logger.error(e);
            }
        }
        return false;
    }
}
