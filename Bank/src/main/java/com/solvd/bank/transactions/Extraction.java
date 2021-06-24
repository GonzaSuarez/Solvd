package com.solvd.bank.transactions;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.exceptions.NullCurrencyException;
import com.solvd.bank.exceptions.UnpayableTransactionException;
import com.solvd.bank.paymethods.Currency;

import java.util.*;

public class Extraction extends Transaction {

    public Extraction() {}

    public Extraction(Currency currency) {
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
        if (currenciesSet.contains(this.currency)) {
            try {
                if (accountCurrencies.get(this.currency.getName()).getAmmount() > (this.currency.getAmmount() + tax)) {
                    accountCurrencies.get(this.currency.getName()).setAmmount(accountCurrencies.get(this.currency.getName()).getAmmount() - this.currency.getAmmount() - tax);
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
