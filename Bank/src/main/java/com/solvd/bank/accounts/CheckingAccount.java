package com.solvd.bank.accounts;

import com.solvd.bank.exceptions.NullCreditCardException;
import com.solvd.bank.exceptions.UnpayableTransactionException;
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
        try{
            if (this.creditCard != null) {
                creditCard.pay(transference, account);
            } else {
                throw new NullCreditCardException("There are no credit card related to this acount");
            }
        }
        catch (NullCreditCardException e){
            logger.error(e);
        }
    }

    @Override
    public boolean transact(Transaction transaction, Account account) {
        try {
            if (transaction.transact(this, transactionTax)) {
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

