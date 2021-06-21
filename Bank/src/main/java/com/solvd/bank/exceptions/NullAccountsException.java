package com.solvd.bank.exceptions;

public class AccountException extends Exception{

    public AccountException(){}

    public AccountException(String errorMessage, Throwable error){
        super(errorMessage, error);
    }
}
