package com.solvd.bank.exceptions;

import com.solvd.bank.transactions.Transaction;

public class TransactionException extends Exception{

    public TransactionException(){}

    public TransactionException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}

