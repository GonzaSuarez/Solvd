package com.solvd.bank.main;

import com.solvd.bank.accounts.CheckingAccount;
import com.solvd.bank.exceptions.NullAccountsException;
import com.solvd.bank.exceptions.NullCurrencyException;
import com.solvd.bank.interfaces.sorter.BubbleSort;
import com.solvd.bank.people.Banker;
import com.solvd.bank.paymethods.Currency;
import com.solvd.bank.people.Client;
import com.solvd.bank.transactions.Transference;
import com.solvd.linkedlist.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void printList(LinkedList list){
        LinkedList searcher = list;
        for(int i = 0; i<list.size(); i++){
            logger.info(searcher.toString());
            searcher = searcher.getNext();
        }
    }

    public static void printListBackwards(LinkedList list){
        LinkedList searcher = list.lastNode();
        for(int i = 0; i<list.size(); i++){
            logger.info(searcher.toString());
            searcher = searcher.getPrevious();
        }
    }

        public static void main(String[] ags) throws NullAccountsException {
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

        LinkedList<Integer> myLinkedList = new LinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        logger.info("List in order:");
        printList(myLinkedList);
        logger.info("List backwards");
        printListBackwards(myLinkedList);
        myLinkedList.add(5, 2);
        logger.info("List in order after adding in the middle:");
        printList(myLinkedList);
        logger.info("List backwards after adding in the middle");
        printListBackwards(myLinkedList);
        myLinkedList.remove(2);
        logger.info("List in order after removing a value:");
        printList(myLinkedList);
    }
}
