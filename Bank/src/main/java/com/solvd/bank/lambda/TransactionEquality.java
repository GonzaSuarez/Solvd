package com.solvd.bank.lambda;

import com.solvd.bank.interfaces.comparator.IComparator;
import com.solvd.bank.transactions.Transaction;

public class TransactionEquality {

    private Transaction myTransaction;

    public TransactionEquality() {
    }

    public TransactionEquality(Transaction transaction) {
        this.myTransaction = transaction;
    }

    public Transaction getTransaction() {
        return myTransaction;
    }

    public void setTransaction(Transaction transaction) {
        this.myTransaction = transaction;
    }

    public boolean compare(IComparator<Transaction> comparator, Transaction transaction){
        return comparator.compare(myTransaction, transaction);
    }
}
