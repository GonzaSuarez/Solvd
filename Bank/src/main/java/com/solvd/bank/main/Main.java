package com.solvd.bank.main;

import com.solvd.bank.exceptions.NullAccountsException;
import com.solvd.bank.lambda.*;
import com.solvd.bank.transactions.Transaction;
import com.solvd.bank.transactions.Transference;
import com.solvd.linkedlist.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] ags) throws NullAccountsException {

        //BANK TESTING FUNCTIONALITIES

    /*        Banker banker = new Banker("Steve", "Gonzalez", 5854786, new Date());
        Client clientJohn = new Client("John", "Rogers", 874259, new Date());
        Client clientRick = new Client("Rick", "Rogers", 874878, new Date());

        banker.openAccount(clientJohn, new CheckingAccount(clientJohn, 789456, 0.08f));
        banker.openAccount(clientRick, new CheckingAccount(clientRick, 879, 0.06f));
        clientJohn.getAccounts().get(0).addCurrency(new Currency("Peso", 1000));
        clientRick.getAccounts().get(0).addCurrency(new Currency("Peso", 10000));


        try {
            logger.info("John has: " + clientJohn.getAccounts().get(0).getCurrencies().get(0).getAmmount() + clientJohn.getAccounts().get(0).getCurrencies().get(0).getName());
        } catch (NullCurrencyException e) {
            logger.error(e);
        }
        try {
            logger.info("Rick has: " + clientRick.getAccounts().get(0).getCurrencies().get(0).getAmmount() + clientRick.getAccounts().get(0).getCurrencies().get(0).getName());
        } catch (NullCurrencyException e) {
            logger.error(e);
        }

        new Transference(new Currency("Peso", 1000), clientJohn.getAccounts().get(0)).transact(clientRick.getAccounts().get(0), 0.06f);

        try {
            logger.info("John now has: " + clientJohn.getAccounts().get(0).getCurrencies().get(0).getAmmount() + clientJohn.getAccounts().get(0).getCurrencies().get(0).getName());
        } catch (NullCurrencyException e) {
            logger.error(e);
        }
        try {
            logger.info("Rick now has: " + clientRick.getAccounts().get(0).getCurrencies().get(0).getAmmount() + clientRick.getAccounts().get(0).getCurrencies().get(0).getName());
        } catch (NullCurrencyException e) {
            logger.error(e);
        }
    */

        // LINKED LIST TESTING FUNCTIONALITIES

        LinkedList<Integer> myLinkedList = new LinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        logger.info("List in order:");
        logger.info(myLinkedList.toString());
        logger.info("List backwards");
        logger.info(myLinkedList.toStringBackwards());
        myLinkedList.add(5, 2);
        logger.info("List in order after adding in the middle:");
        logger.info(myLinkedList.toString());
        logger.info("List backwards after adding in the middle:");
        logger.info(myLinkedList.toStringBackwards());
        myLinkedList.remove(2);
        logger.info("List in order after removing a value:");
        logger.info(myLinkedList.toString());


/*
    // CUSTOM LAMBDAS TESTING FUNCTIONALITIES

        TransactionFinder transactionFinder = new TransactionFinder();
        Double value = 1000d;
        List<Transaction> filteredTransactions = transactionFinder.search((transactions, criteria) ->{
                                                    for (Transaction t: transactions) {
                                                        if(t.getCurrency().getAmmount() > criteria){
                                                            transactions.add(t);
                                                        }
                                                    }
                                                    return transactions;
                                                }, value);


        TransactionCalculator calculator = new TransactionCalculator();
        Double d = calculator.calculate((transactions) -> {
            double doubleValue = 0;
            for (Transaction t: transactions) {
                doubleValue += t.getCurrency().getAmmount();
            }
            return doubleValue;
        });

        TransactionEquality comaprator = new TransactionEquality();
        Transaction transact = new Transference();
        comaprator.compare((myTransaction, transaction) -> myTransaction.equals(transaction), transact);

    // USAGE OF EXISTING LAMBDAS

        IntToDouble intToDouble = new IntToDouble(100000000);
        double output = intToDouble.calculate((input)-> input/3);

        DoubleFunction doubleFunction = new DoubleFunction(230204201013d);
        double result = doubleFunction.calculate((val) -> (double)val);


    }*/


    }
}
