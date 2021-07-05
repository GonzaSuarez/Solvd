package com.solvd.bank.lambda;

import com.solvd.bank.interfaces.calculator.ICalculator;
import com.solvd.bank.transactions.Transaction;

import java.util.List;

public class TransactionCalculator {

    private List<Transaction> transactions;

    public TransactionCalculator(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public TransactionCalculator() {
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double calculate(ICalculator<List<Transaction>> calculator){
        return calculator.calculate(transactions);
    }
}
