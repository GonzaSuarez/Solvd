package com.solvd.bank.transactions;

import com.solvd.bank.accounts.Account;
import com.solvd.bank.paymethods.Currency;

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
    public boolean transact(Account account, float tax) {
        List<Currency> accountCurrencies = account.getCurrencies();
        if(accountCurrencies.contains(this.currency)){
            int accountCurrencyIndex = accountCurrencies.indexOf(this.currency);
            if(accountCurrencies.get(accountCurrencyIndex).getAmmount() >(this.currency.getAmmount() + tax)){
                List<Currency> destinyCurrencies = receiver.getCurrencies();
                if(destinyCurrencies.contains(this.currency)){
                    int destinyCurrencyIndex = destinyCurrencies.indexOf(this.currency);
                    destinyCurrencies.get(destinyCurrencyIndex).setAmmount(destinyCurrencies.get(destinyCurrencyIndex).getAmmount() + this.currency.getAmmount());
                }
                else {
                    receiver.addCurrency(this.currency);
                }
                accountCurrencies.get(accountCurrencyIndex).setAmmount(accountCurrencies.get(accountCurrencyIndex).getAmmount() - this.currency.getAmmount() - tax);
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
