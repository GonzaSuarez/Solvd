package com.solvd.bank.interfaces.searcher;

import com.solvd.bank.paymethods.Currency;

import java.util.List;
@FunctionalInterface
public interface ISearcher<T, V> {

    List<T> search(List<T> searchList, V criteria);
}
