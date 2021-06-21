package com.solvd.bank.transactions;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.exceptions.NullCurrencyException;
import com.solvd.bank.exceptions.UnpayableTransactionException;
import com.solvd.bank.paymethods.Currency;

import java.util.ArrayList;
import java.util.List;

public class Transference extends Transaction{

    private Account receiver;

    public Transference() {}

    public Transference(Currency currency, Account receiver) {
        super(currency);
        this.receiver = receiver;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
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
            try {
                if (accountCurrencies.get(accountCurrencyIndex).getAmmount() > (this.currency.getAmmount() + tax)) {
                    List<Currency> destinyCurrencies = null;
                    try {
                        destinyCurrencies = receiver.getCurrencies();
                    } catch (NullCurrencyException e) {
                        logger.error("There are no currencies related to this client");
                    }
                    if (destinyCurrencies.contains(this.currency)) {
                        int destinyCurrencyIndex = destinyCurrencies.indexOf(this.currency);
                        destinyCurrencies.get(destinyCurrencyIndex).setAmmount(destinyCurrencies.get(destinyCurrencyIndex).getAmmount() + this.currency.getAmmount());
                    } else {
                        receiver.addCurrency(this.currency);
                    }
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
