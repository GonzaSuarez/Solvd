package com.solvd.bank.accounts;

import com.solvd.bank.people.Client;

public abstract class FreeAccount extends Account {

    protected static final float TAX = 0;

    public FreeAccount() {}

    public FreeAccount(Client owner, long cbu) {
        super(owner, cbu);
    }

}
