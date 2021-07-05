package com.solvd.bank.lambda;

import com.solvd.bank.interfaces.searcher.ISearcher;
import com.solvd.bank.transactions.Transaction;

import java.util.List;

public class TransactionFinder {

    private List<Transaction> searchList;

    public TransactionFinder() {}

    public TransactionFinder(List<Transaction> searchList) {
        this.searchList = searchList;
    }

    public List<Transaction> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<Transaction> searchList) {
        this.searchList = searchList;
    }

    public List<Transaction> search(ISearcher<Transaction, Double> searcher, Double value){
        return searcher.search(searchList, value);
    }

}
