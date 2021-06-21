package com.solvd.bank.accounts;

import com.solvd.bank.transactions.Transaction;
import com.solvd.bank.transactions.Transference;
import com.solvd.bank.paymethods.CreditCard;
import com.solvd.bank.people.Client;

public class CheckingAccount extends Account {

    private float transactionTax;
    private CreditCard creditCard;

    public CheckingAccount() {}

    public CheckingAccount(Client owner, long cbu, float transactionTax) {
        super(owner, cbu);
        this.transactionTax = transactionTax;
    }

    public float getTransactionTax() {
        return transactionTax;
    }

    public void setTransactionTax(float transactionTax) {
        this.transactionTax = transactionTax;
    }



    public void payCredit(Transference transference, Account account){
        creditCard.pay(transference,account);
    }

    @Override
    public boolean transact(Transaction transaction, Account account) {
        if (transaction.transact(this, transactionTax)) {
            return this.transactionsRegister.add(transaction);
        }
        return false;
    }
}

