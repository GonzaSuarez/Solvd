package com.solvd.bank.accounts;

import com.solvd.bank.exceptions.UnpayableTransactionException;
import com.solvd.bank.paymethods.Currency;
import com.solvd.bank.transactions.Transaction;
import com.solvd.bank.people.Client;

import java.util.Date;

public class SavingsAccount extends FreeAccount {

    private float transactionLimit;
    private float fixedTerm;
    private Date creationDate;
    private String invertionCurrency;

    public SavingsAccount(){
        this.creationDate = new Date();
    }

    public SavingsAccount(Client owner, long cbu, String invertionCurrency) {
        super(owner, cbu);
        this.creationDate = new Date();
        this.invertionCurrency = invertionCurrency;
    }

    public String getInvertionCurrency() {
        return invertionCurrency;
    }

    public void setInvertionCurrency(String invertionCurrency) {
        this.invertionCurrency = invertionCurrency;
    }

    public float getExtractionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(float transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public float getFixedTerm() {
        return fixedTerm;
    }

    public void setFixedTerm(float fixedTerm) {
        this.fixedTerm = fixedTerm;
    }

    public void invertionBalance(){
        if((new Date().getMonth() - this.creationDate.getMonth()) > 0) {
            this.balances.get(this.invertionCurrency).setAmmount(this.balances.get(this.invertionCurrency).getAmmount() * fixedTerm);
        }
    }

    @Override
    public boolean transact(Transaction transaction, Account account) {
        try {
            if (transaction.transact(this, TAX)) {
                return this.transactionsRegister.add(transaction);
            }
            else {
                throw new UnpayableTransactionException("There is not enough balance for this transaction");
            }
        } catch (UnpayableTransactionException e) {
            logger.error(e);
        }
        return false;
    }

}
