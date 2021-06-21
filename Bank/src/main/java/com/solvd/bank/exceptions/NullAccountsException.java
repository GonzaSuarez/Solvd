package com.solvd.bank.exceptions;

public class NullAccountsException extends Exception{

    public NullAccountsException(){}

    public NullAccountsException(String errorMessage){
        super(errorMessage);
    }
}
