package com.solvd.bank.accounts;

import com.solvd.bank.exceptions.UnpayableTransactionException;
import com.solvd.bank.transactions.Transaction;
import com.solvd.bank.people.Client;

public class SalaryAccount extends FreeAccount {

    private String workingCertificate;

    public SalaryAccount() {}

    public SalaryAccount(Client owner, long cbu, String workingCertificate) {
        super(owner, cbu);
        this.workingCertificate = workingCertificate;
    }

    public String getWorkingCertificate() {
        return workingCertificate;
    }

    public void setWorkingCertificate(String workingCertificate) {
        this.workingCertificate = workingCertificate;
    }

    public boolean transact(Transaction transaction, Account account){
        try {
            if(transaction.transact(this, TAX)){
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
