package com.solvd.bank.enums;

public enum WorkPosition {

    MANAGER("Manager"), ACCOUNT_ASSISTANT("Account_Assistant"), ACCOUNTANT("Accountant");

    private String rol;

    private WorkPosition(String rol){
        this.rol = rol;
    }

    @Override
    public String toString() {
        return rol;
    }
}
