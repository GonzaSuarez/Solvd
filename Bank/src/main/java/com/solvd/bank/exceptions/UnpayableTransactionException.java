package com.solvd.bank.exceptions;

import com.solvd.bank.transactions.Transaction;

public class UnpayableTransactionException extends Exception{

    public UnpayableTransactionException(){}

    public UnpayableTransactionException(String errorMessage) {
        super(errorMessage);
    }
}

