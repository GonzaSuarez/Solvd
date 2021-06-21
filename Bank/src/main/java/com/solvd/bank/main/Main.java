package com.solvd.bank.main;

import com.solvd.bank.accounts.CheckingAccount;
import com.solvd.bank.people.Banker;
import com.solvd.bank.paymethods.Currency;
import com.solvd.bank.people.Client;
import com.solvd.bank.transactions.Transference;

import java.util.Date;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] ags){
        Banker banker = new Banker("Steve", "Gonzalez", 5854786, new Date());
        Client clientJohn = new Client("John", "Rogers", 874259, new Date());
        Client clientRick = new Client("Rick", "Rogers", 874878, new Date());
        banker.openAccount(clientJohn, new CheckingAccount(clientJohn, 789456, 0.08f));
        banker.openAccount(clientRick, new CheckingAccount(clientRick, 879, 0.06f));
        clientJohn.getAccounts().get(0).addCurrency(new Currency("Peso", 1000));
        clientRick.getAccounts().get(0).addCurrency(new Currency("Peso", 10000));

        Logger log = new Logger();

        System.out.println("John has: " + clientJohn.getAccounts().get(0).getCurrencies().get(0).getAmmount() + clientJohn.getAccounts().get(0).getCurrencies().get(0).getName());
        System.out.println("Rick has: " + clientRick.getAccounts().get(0).getCurrencies().get(0).getAmmount() + clientRick.getAccounts().get(0).getCurrencies().get(0).getName());

        new Transference(new Currency("Peso", 1000), clientJohn.getAccounts().get(0)).transact(clientRick.getAccounts().get(0), 0.06f);

        System.out.println("John now has: " + clientJohn.getAccounts().get(0).getCurrencies().get(0).getAmmount() + clientJohn.getAccounts().get(0).getCurrencies().get(0).getName());
        System.out.println("Rick now has: " + clientRick.getAccounts().get(0).getCurrencies().get(0).getAmmount() + clientRick.getAccounts().get(0).getCurrencies().get(0).getName());



    }
}
